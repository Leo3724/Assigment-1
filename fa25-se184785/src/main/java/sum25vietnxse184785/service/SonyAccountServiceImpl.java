package sum25vietnxse184785.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sum25vietnxse184785.pojo.SonyAccount;
import sum25vietnxse184785.repository.SonyAccountsRepository;

import java.util.List;

@Service
public class SonyAccountServiceImpl implements SonyAccountService {

    @Autowired
    private SonyAccountsRepository accountsRepository;

    @Override
    public List<SonyAccount> getAllAccounts() {
        return accountsRepository.findAll();
    }

    @Override
    public void saveAccount(SonyAccount account) {
        accountsRepository.save(account);
    }

    @Override
    public SonyAccount login(String phone, String password) {
        return accountsRepository.findAll()
                .stream()
                .filter(acc -> acc.getPhone().equals(phone) && acc.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void createAccount(SonyAccount account) {
        accountsRepository.save(account);
    }
}