package BankAccountApp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Simple bank account application
 * @author Zoey Luu
 */
public class BankAccountApp {
    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<Account>();

        String file = "C:\\Projects\\Bank_Application\\NewBankAccounts.csv";

        // Read a CSV File then create new accounts based on that data
        List<String[]> newAccountHolder = readCSV(file);
        for (String[] accountHolder : newAccountHolder) {
            String name = accountHolder[0];
            String niNumber = accountHolder[1];
            String accountType = accountHolder[2];
            double initialDeposit = Double.parseDouble(accountHolder[3]);
            if (accountType.equals("Savings")) {
                accounts.add(new Savings(name, niNumber, initialDeposit));
            } else if (accountType.equals("Current")) {
                accounts.add(new Savings(name, niNumber, initialDeposit));
            } else {
                System.out.println("ERROR READING ACCOUNT TYPE");
            }
        }

        for (Account acc : accounts) {
            System.out.println("\n******************************");
            acc.showInfo();
        }
    }

    /**
     * Read data from CSV
     * @param file file path of CSV file
     * @return List of data from CSV file
     */
    private static List<String[]> readCSV(String file) {
        java.util.List<String[]> data = new LinkedList<>();
        String dataRow;
        try {
            BufferedReader br = new BufferedReader((new FileReader(file)));
            while ( (dataRow = br.readLine()) != null ) {
                String[] dataRecords = dataRow.split(",");
                data.add(dataRecords);
            }
        } catch (FileNotFoundException e) {
            System.out.println("COULD NOT FIND FILE");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("COULD NOT READ FILE");
            e.printStackTrace();
        }
        return data;
    }
}
