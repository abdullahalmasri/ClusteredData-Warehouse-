package com.warehouse.warehouse.controller;

import com.warehouse.warehouse.model.CurrencyCode;
import com.warehouse.warehouse.model.Customer;
import com.warehouse.warehouse.model.ValidDeal;
import com.warehouse.warehouse.service.AccumulativeDealService;
import com.warehouse.warehouse.service.CSVService;
import com.warehouse.warehouse.service.CustomerService;
import com.warehouse.warehouse.service.DealService;
import helper.CSVHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1")
public class ValidDealController {
    private static final Logger log = LoggerFactory.getLogger(ValidDealController.class);
    private final DealService dealService;
    @Autowired
    private final CSVService fileService;
    @Autowired
    private final CustomerService customerService;
    @Autowired
    private  final AccumulativeDealService accumulativeDealService;


    @Autowired
    public ValidDealController(DealService dealService, CSVService fileService, CustomerService customerService, AccumulativeDealService accumulativeDealService) {
        this.dealService = dealService;
        this.fileService = fileService;
        this.customerService = customerService;
        this.accumulativeDealService = accumulativeDealService;
    }
    @RequestMapping(value = "/{customer_id}/saveDeal", method = RequestMethod.POST)
    public List<ValidDeal> create(@PathVariable(value = "customer_id") String customer_id,
            @RequestBody List<ValidDeal> validDeals) {
        log.info("starting saving list of Deals...");
        List<ValidDeal> savedDeals = new ArrayList<>();
        for (ValidDeal validDeal:validDeals){
            boolean created = validDeal.getId() == null;
            try {
                checkExist(validDeal.getDealId(),validDeal.getFromCurrency(),validDeal.getToCurrency());
//                UUID uuid = UUID.fromString(customer_id);
                List<Customer> customers = customerService.findCustomer();
                for(Customer customer:customers){
                    if(customer.getId().equals(customer_id))
                        validDeal.setCustomer(customer);
                }
//                Customer customer=customerService.findById(uuid);
//
                ValidDeal oldDeal = null;
                if (!created) {
                    oldDeal = dealService.findById(validDeal.getId());
                }
                ValidDeal savedDeal = dealService.saveValidDeal(validDeal);

                log.info("the deal will be saved with id {}", validDeal.getId());


                savedDeals.add(savedDeal);
                accumulativeDealService.findAll(validDeal.getDealId());

            }catch (Exception e){
                log.warn(e.getMessage());
            }
        }
        return savedDeals;
    }


    private void checkExist(String dealId, CurrencyCode fromCurrency, CurrencyCode toCurrency) throws Exception {
        List<ValidDeal> validDeals = dealService.findValidDeals();
        for (ValidDeal deal:validDeals){
            if(deal.getDealId().equals(dealId)&&deal.getFromCurrency().equals(fromCurrency)&&deal.getToCurrency().equals(toCurrency))
                throw new Exception("the record is already in our Database..");
        }
    }


    @RequestMapping(value="/findDeals",method = RequestMethod.GET)
    public List<ValidDeal> getValidDeals(){
        List<ValidDeal> validDeals = dealService.findValidDeals();
        log.info("the Deals are in database equal {}",validDeals.size());
        return dealService.findValidDeals();
    }



    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        log.info("Starting Upload the file");
        if (CSVHelper.hasCSVFormat(file)) {
            try {
                fileService.save(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                log.info("Uploaded the file successfully: {}" , file.getOriginalFilename());
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }



}
