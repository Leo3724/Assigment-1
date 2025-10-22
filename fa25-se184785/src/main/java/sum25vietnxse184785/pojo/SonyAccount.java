package sum25vietnxse184785.pojo;

import jakarta.persistence.*;

@Entity
@Table(name = "SonyAccounts")
public class SonyAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AccountID")
    private int accountID;
    @Column(name = "RoleID")
    private int roleID;
    @Column(name = "Password")
    private String password;
    @Column(name = "Phone")
    private String phone;

    public SonyAccount() {
    }
    public SonyAccount(int accountID, int roleID, String password, String phone) {
        this.accountID = accountID;
        this.roleID = roleID;
        this.password = password;
        this.phone = phone;
    }
    public SonyAccount(int roleID, String password, String phone) {
        this.roleID = roleID;
        this.password = password;
        this.phone = phone;
    }

    public SonyAccount(String phone, String password, int roleID) {
        this.phone = phone;
        this.password = password;
        this.roleID = roleID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
