package th.ac.ku.atm.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.ac.ku.atm.model.BankAccount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BankAccountService {

    private RestTemplate restTemplate;
    private ArrayList<BankAccount> bankAccountsList;
    public BankAccountService(RestTemplate restTemplate,ArrayList<BankAccount> bankAccountsList) {
        this.restTemplate = restTemplate;
        this.bankAccountsList = bankAccountsList;
    }

    public List<BankAccount> getCustomerBankAccount(int customerId) {
        String url = "http://localhost:8091/api/bankaccount/customer/" +
                customerId;
        ResponseEntity<BankAccount[]> response =
                restTemplate.getForEntity(url, BankAccount[].class);

        BankAccount[] accounts = response.getBody();

        return Arrays.asList(accounts);
    }

//    public void createBankAccount(BankAccount bankAccount){
//        bankAccountsList.add(bankAccount);
//    }
//
//    public List<BankAccount> getBankAccounts() {
//        return new ArrayList<>(this.bankAccountsList);
//    }
}
