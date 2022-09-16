package com.warehouse.warehouse.service;

import com.warehouse.warehouse.Repostory.CSVUploadRepo;
import com.warehouse.warehouse.Repostory.ValidRepo;
import com.warehouse.warehouse.model.ValidDeal;
import helper.CSVHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class CSVService {
    @Autowired
    private final ValidRepo validRepo;
    @Autowired
    CSVUploadRepo repository;

    public CSVService(ValidRepo validRepo) {
        this.validRepo = validRepo;
    }

    public void save(MultipartFile file) {
        try {
            List<ValidDeal> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
            for (ValidDeal validDeal:tutorials) {
                validRepo.save(validDeal);
            }
//            repository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public ByteArrayInputStream load() {
        List<ValidDeal> tutorials = repository.findAll();

        ByteArrayInputStream in = CSVHelper.tutorialsToCSV(tutorials);
        return in;
    }

    public List<ValidDeal> getAllTutorials() {
        return repository.findAll();
    }
}

