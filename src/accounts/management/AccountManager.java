package accounts.management;

import accounts.entites.Account;
import java.util.Arrays;

public class AccountManager {

    public Account[] list;
    public int count = 0;
    public int max = 100;

    public AccountManager() {
        list = new Account[100];
    }

    public AccountManager(int maxAccount) {
        list = new Account[maxAccount];
    }

    //thêm một tài khoản mới vào mảng
    public boolean addAccount(Account newAccount) {
        if (count >= max) {
            return false;
        } else {
            list[count] = newAccount;
            count++;
            return true;
        }
    }

    //tìm kiếm tài khoản theo mã tài khoản
    public Account findByAccountCode(String accountCode) {

        for (int i = 0; i < list.length; i++) {
            if (list[i].getAccountCode().equals(accountCode)) {
                //nếu tìm thấy thì trả về vị trí tìm thấy 
                return list[i];
            }
        }
        return null;
    }

    //xóa tài khoản 
    public boolean removeAccount(Account account) {
        list[count] = account;
        count--;
        return true;
    }

    //hiển thị danh sách tài khoản
    public void viewAccountList() {

        for (int i = 0; i < count; i++) {
            list[i].showAccountInfo();
        }
    }

    public void sortAccountsByBalance() {
        Account temp;
        int j = 0;
        for (int i = 0; i < count - 1; i++) {
            for (j = i + 1; j < count; j++) {
                if (list[i].getBalance() > list[j].getBalance()) {
                    temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }

        for (int i = 0; i < count; i++) {
            list[i].showAccountInfo();
        }

    }

    public boolean checkSortedAccountByBalance() {

        for (int i = 0; i < count - 1; i++) {
            if (list[i].getBalance() > list[i + 1].getBalance()) {
                return false;
            }
        }
        return true;

    }

    public boolean insertAccount(Account newAccount) {
        if (count >= max) {
            return false;
        } else {
            list[count] = newAccount;
            count++;
            sortAccountsByBalance();

            return true;
        }
    }
}
