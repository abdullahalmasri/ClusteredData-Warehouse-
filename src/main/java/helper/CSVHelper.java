package helper;

import com.warehouse.warehouse.Repostory.ValidRepo;
import com.warehouse.warehouse.model.CurrencyCode;
import com.warehouse.warehouse.model.ValidDeal;
import org.apache.commons.csv.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = { "DEAL_ID","FROM_CURRENCY","TO_CURRENCY","TIMESTAMP","AMOUNT" };




    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<ValidDeal> csvToTutorials(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<ValidDeal> validDeals = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                String UUID = csvRecord.get("DEAL_ID");
//                long mostSig = Long.parseLong(UUID.substring(0, 16), 16);
//                long leastSig = Long.parseLong(UUID.substring(16, 32), 16);
//                UUID uuid = new UUID(mostSig,leastSig);
                String sDate = csvRecord.get("TIMESTAMP");
                LocalDateTime ldt =LocalDateTime.parse(sDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
//                DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//                LocalDate ld = LocalDate.parse(sDate);
//                LocalDateTime ldt = LocalDateTime.of(ld, LocalDateTime.now().toLocalTime());
                String num = csvRecord.get("AMOUNT");
                BigDecimal bigDecimal = new BigDecimal(num);

                ValidDeal validDeal = new ValidDeal();

                validDeal.setDealId(UUID);
                validDeal.setDateTime(ldt);
                validDeal.setAmount(bigDecimal);
                validDeal.setFromCurrency(CurrencyCode.valueOf(csvRecord.get("FROM_CURRENCY")));
                validDeal.setToCurrency(CurrencyCode.valueOf(csvRecord.get("TO_CURRENCY")));
                validDeal.setFileName("fromFile");
                validDeals.add(validDeal);
            }

            return validDeals;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static ByteArrayInputStream tutorialsToCSV(List<ValidDeal> validDeals) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (ValidDeal validDeal : validDeals) {
                List<String> data = Arrays.asList(
                        String.valueOf(validDeal.getId()),
                        validDeal.getDealId().toString(),
                        validDeal.getFromCurrency().toString(),
                        validDeal.getToCurrency().toString(),
                        validDeal.getAmount().toString(),
                        validDeal.getDateTime().toString(),
                        String.valueOf(validDeal.isAccpet())
                );

                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }

}
