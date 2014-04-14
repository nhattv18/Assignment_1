package accounts.entites;

public class Account {

    private String accountCode;
    private String pinCode;
    private String fullName;
    public double balance;

//    public Account() {
//        accountCode = "0000000000";
//        pinCode = "0000";
//        fullName = "No Name";
//        balance = 0.0;
//    }
//
//    public Account(String accountCode, String pinCode, String fullName, double balance) {
//        this.accountCode = accountCode;
//        this.pinCode = pinCode;
//        this.fullName = fullName;
//        this.balance = balance;
//    }

    public String getAccountCode() {
        return this.accountCode;
    }

    public void setAccountCode(String value) {
        this.accountCode = value;
    }

    public String getPinCode() {
        return this.pinCode;
    }

    public void setPinCode(String value) {
        this.pinCode = value;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String value) {
        this.fullName = value;
    }

    public double getBalance() {
        return this.balance;
    }

    public boolean consign(double amount) {
        this.balance = this.balance + amount;
        return true;
    }

    public boolean drawing(double amount) {
        this.balance = this.balance - amount;
        return true;
    }

    public void showAccountInfo() {

        System.out.printf("Ten: %s | "
                + "T.Khoan: %s | "
                + "Ma Pin: ****** | "
                + "Tien: %.0f %n\n",
                this.getFullName(),
                this.getAccountCode(),
                this.getBalance());
    }
}
