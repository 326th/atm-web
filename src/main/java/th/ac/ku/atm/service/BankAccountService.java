package th.ac.ku.atm.service;

import org.springframework.stereotype.Service;
import th.ac.ku.atm.model.BankAccount;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountService {

    private ArrayList<BankAccount> bankAccountsList;

    @PostConstruct
    public void postContruct() {
        bankAccountsList = new ArrayList<>();
    }

    public void createBankAccount(BankAccount bankAccount){
        bankAccountsList.add(bankAccount);
    }

    public List<BankAccount> getBankAccounts() {
        return new ArrayList<>(this.bankAccountsList);
    }
}
