package accounts;

import accounts.management.AccountManager;
import accounts.entites.Account;
import java.util.Scanner;

public class ConsoleApp {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        AccountManager am = new AccountManager();
        Account ac;
        int choice;

        do {
            choice = menu();
            switch (choice) {
                //Them tai khoan
                case 1:
                    ac = new Account();
                    System.out.print("* Ho ten: ");
                    ac.setFullName(kb.nextLine());

                    System.out.print("* So tai khoan (10 so): ");
                    do {
                        ac.setAccountCode(kb.nextLine());
                        if (ac.getAccountCode().length() == 10) {
                            break;
                        } else {
                            System.out.println("-> Nhap lai TK gom 10 ki tu: ");
                        }
                    } while (ac.getAccountCode().length() > 10 || ac.getAccountCode().length() <= 9);

                    System.out.print("* Ma pin (6 ki tu): ");
                    do {
                        ac.setPinCode(kb.nextLine());
                        if (ac.getPinCode().length() == 6) {
                            break;
                        } else {
                            System.out.print("-> Nhap ma pin gom 6 ki tu: ");
                        }
                    } while (ac.getPinCode().length() > 6 || ac.getPinCode().length() <= 5);

                    System.out.print("* So tien (>0): ");
                    do {
                        try {
                            ac.consign(kb.nextDouble());
                            if (ac.balance > 0) {
                                break;
                            } else {
                                ac.balance = 0;
                                System.out.println("-> Nhap lai so tien > 0");
                            }
                            kb.nextLine();
                        } catch (Exception ex) {
                            System.out.println("Lỗi: " + ex);
                            System.out.print("-> Nhap lai: ");
                            kb.nextLine();
                        }
                    } while (true);
                    kb.nextLine();
                    am.addAccount(ac);
                    break;

                //Sửa tài khoản
                case 2:
                    ac = new Account();
                    System.out.print("Nhap ma tai khoan can sua: ");

                    ac = am.findByAccountCode(kb.nextLine());
                    if (ac == null) {
                        System.out.print("Ko co gia tri thoa man");
                    } else {
                        ac.showAccountInfo();
                    }

                    System.out.println("Moi ban nhap ten moi: ");
                    ac.setFullName(kb.nextLine());
                    break;

                //Xoa tai khoan    
                case 3:
                    ac = new Account();
                    if (am.count == 0) {
                        System.out.println("\n* Chua co tai khoan nao trong DS");
                        break;
                    } else {
                        try {
                            System.out.print("* Nhap so TK muon xoa: ");

                            ac = am.findByAccountCode(kb.nextLine());

                            System.out.println("-> Da xoa thanh cong TK: " + ac.getAccountCode());

                        } catch (Exception ex) {
                            System.out.println("Loi, khong co ket qua nao phu hop");
                        }
                        //ac.showAccountInfo();

                    }
                    am.removeAccount(ac);
                    break;

                //Xem danh sach tai khoan    
                case 4:
                    System.out.println("* DS tai khoan co: " + am.count + " tai khoan");
                    am.viewAccountList();
                    break;

                //Sap xep DS theo balance
                case 5:
                    if (am.count == 0) {
                        System.out.println("\n* Chua co tai khoan nao trong DS");
                        break;
                    } else {
                        if (am.count == 1) {
                            System.out.println("\n* Moi co 1 tai khoan nen khong can sap xep");
                        } else {
                            System.out.println("* DS tai khoan co: " + am.count + " tai khoan va duoc sap xep tang dan theo balance");
                            am.sortAccountsByBalance();
                        }

                    }
                    break;

                //Kiem tra da sap xep chua    
                case 6:
                    if (am.count == 0) {
                        System.out.println("\n* Chua co tai khoan nao trong DS");
                    } else {
                        if (am.count == 1) {
                            System.out.println("\n-> DS chua sap xep");
                        } else {
                            if (am.checkSortedAccountByBalance() == true) {
                                System.out.println("-> DS da sap xep roi");
                            } else {
                                System.out.println("-> DS chua sap xep");
                            }
                        }

                    }
                    break;

                //Tim kiem theo so du    
                case 7:
                    ac = new Account();
                    if (am.count == 0) {
                        System.out.println("\n* Chua co tai khoan nao trong DS");
                        break;
                    } else {
                        try {
                            System.out.print("* Nhap ma so tai khoan muon tim: ");
                            ac = am.findByAccountCode(kb.nextLine());

                            System.out.println("-> Tim thay ma TK " + ac.getAccountCode() + " voi thong tin chi tiet sau: ");
                            ac.showAccountInfo();

                        } catch (Exception ex) {
                            System.out.println("Khong co ket qua nao phu hop");
                        }
                    }
                    break;
                //Them tk vao danh sach da sap xep
                case 8:
                    ac = new Account();
                    if (am.count == 0) {
                        System.out.println("\n* Chua co danh sach nao");
                    } else {
                        if (am.checkSortedAccountByBalance() == true) {

                            System.out.print("* Ho ten: ");
                            ac.setFullName(kb.nextLine());

                            System.out.print("* So tai khoan (13 so): ");
                            do {
                                ac.setAccountCode(kb.nextLine());
                                if (ac.getAccountCode().length() == 13) {
                                    break;
                                } else {
                                    System.out.println("-> Nhap lai TK gom 13 ki tu: ");
                                }
                            } while (ac.getAccountCode().length() > 13 || ac.getAccountCode().length() <= 12);

                            System.out.print("* Ma pin (6 ki tu): ");
                            do {
                                ac.setPinCode(kb.nextLine());
                                if (ac.getPinCode().length() == 6) {
                                    break;
                                } else {
                                    System.out.print("-> Nhap ma pin gom 6 ki tu: ");
                                }
                            } while (ac.getPinCode().length() > 6 || ac.getPinCode().length() <= 5);
                            System.out.print("* So tien (>0): ");
                            do {
                                try {
                                    ac.consign(kb.nextDouble());
                                    if (ac.balance > 0) {
                                        break;
                                    } else {
                                        ac.balance = 0;
                                        System.out.println("-> Nhap lai so tien > 0");
                                    }
                                    kb.nextLine();
                                } catch (Exception ex) {
                                    System.out.println("Lỗi: " + ex);
                                    System.out.print("-> Nhap lai: ");
                                    kb.nextLine();
                                }
                            } while (true);

                            kb.nextLine();
                            am.insertAccount(ac);
                        } else {
                            System.out.println("Ban chua thuc hien sap xep nen k the dung chuc nang nay");
                        }
                    }
                    break;

                //Gui tien vao tk    
                case 9:
                    ac = new Account();
                    if (am.count == 0) {
                        System.out.println("\n* Chua co tai khoan nao trong DS");
                        break;
                    } else {
                        System.out.print("* Nhap ma tai khoan gui tien: ");
                        try {
                            ac = am.findByAccountCode(kb.nextLine());
                            System.out.printf("-> Tai khoan %s hien co: %.0f$ %n", ac.getAccountCode(), ac.getBalance());
                            System.out.print("* Nhap tien gui vao: ");

                            try {
                                do {
                                    double a = kb.nextDouble();

                                    if (a > 0) {
                                        ac.consign(a);
                                        break;
                                    } else {

                                        System.out.println("-> Nhap lai so tien > 0");
                                    }
                                    kb.nextLine();
                                } while (true);

                            } catch (Exception ex) {
                                System.out.println("Loi, khong thay ket qua phu hop ");
                                System.out.print("-> Nhap lai: ");
                                kb.nextLine();
                            }

                            System.out.println("-> Da gui tien thanh cong!");
                            kb.nextLine();

                        } catch (Exception e) {
                            System.out.println("-> Loi: " + e);

                        }
                    }

                    break;

                //Chuyen khoan    
                case 10:
                    ac = new Account();
                    double bl;
                    Account ac2 = new Account();
                    if (am.count == 0 || am.count == 1) {
                        System.out.println("\n* Chua co du so tai khoan de thuc hien chuyen tien");

                    } else {
                        System.out.print("* Nhap ma TK nguoi chuyen: ");

                        ac = am.findByAccountCode(kb.nextLine());

                        System.out.print("* Nhap ma TK nguoi nhan: ");

                        ac2 = am.findByAccountCode(kb.nextLine());

                        System.out.print("* Nhap so tien can chuyen : ");
                        do {
                            bl = kb.nextDouble();

                            if (bl > 0 && bl < ac.balance) {
                                ac.drawing(bl);
                                ac2.consign(bl);
                                System.out.println("-> Da chuyen tien thanh cong!");
                                break;
                            } else {
                                System.out.println("Nhap lai so tien > 0 va nho hon tai khoan nguoi gui: ");
                            }
                            kb.nextLine();
                        } while (true);

                    }

                    break;

                case 0:
                    break;
            }

        } while (choice != 0);
    }

    public static int menu() {

        System.out.println("\n_____________________________________");
        System.out.println("1. Them tai khoan moi");
        System.out.println("2. Sua ten tai khoan");
        System.out.println("3. Xoa tai khoan");
        System.out.println("4. Xem danh sach tai khoan");
        System.out.println("5. Sap xep DS tang dan theo balance");
        System.out.println("6. Kiem tra da sap xep chua");
        System.out.println("7. Tim kiem TK theo ma TK");
        System.out.println("8. Them TK vao DS da sap xep");
        System.out.println("9. Gui tien vao tai khoan");
        System.out.println("10. Chuyen khoan");
        System.out.println("0. Ket thuc");
        System.out.println("_____________________________________");

        Scanner kb = new Scanner(System.in);
        int input = -1;

        while (input < 0 || input > 10) {
            System.out.print("-> Lua chon cua ban: ");
            if (kb.hasNextInt()) {
                input = kb.nextInt();
            } else {
                System.out.println("* Khong hop le.");
            }
            kb.nextLine();
        }
        return input;
    }
}
