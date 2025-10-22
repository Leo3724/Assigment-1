package sum25vietnxse184785.service;

import sum25vietnxse184785.pojo.SonyAccount;

import java.util.List;

public interface SonyAccountService {
    List<SonyAccount> getAllAccounts();
    void saveAccount(SonyAccount account);
    SonyAccount login(String phone, String password);
    void createAccount(SonyAccount account);
}
