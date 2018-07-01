package version2;

/**
 * 版本2
 * 控制台界面实现
 *根据算法，在控制台输出用户想要的功能
 * @author 11603080209 代利文
 */

import java.io.IOException;
import java.util.Scanner;

public class ATMMachine2 {
    public static void main (String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        Account2 account = new Account2();
        //2account.allCreat();
        while (true) {
            System.out.println("Main menu");
            System.out.println("1:login");
            System.out.println("2:register");
            System.out.print("Choose the function you need(1-2) > ");
            int choose = input.nextInt();
            if (choose == 1) {
                if(account.login() == false)
                    continue;
            } else if (choose == 2) {
                account.register();
                continue;
            } else {
                System.out.println("Please enter the correct order > 1-2");
                System.out.println();
                continue;
            }
            double withdaw = 0;
            while (true) {
                System.out.println("Main menu");
                System.out.println("1:check balance");
                System.out.println("2:withdraw");
                System.out.println("3:deposit");
                System.out.println("4:details of the transaction");
                System.out.println("5:change password");
                System.out.println("6:exit");
                System.out.print("Choose the function you need(1-6) > ");
                choose = input.nextInt();
                if ((choose == 1 || choose == 2 || choose == 3 || choose == 4 || choose == 5 || choose == 6) == false) {
                    System.out.println("Please enter the correct order > 1-6");
                    System.out.println();
                    continue;
                }
                System.out.println();
                if (choose == 1) {
                    System.out.println("Your balance is " + account.getBalance());
                    System.out.println();
                }
                else if (choose == 2) {
                    System.out.println("Your balance is " + account.getBalance());
                    System.out.print("Please enter the amount of your withdrawal > ");
                    double Withdraw = input.nextDouble();
                    withdaw = withdaw + Withdraw;
                    if(withdaw>5000) {
                        System.out.println("The daily withdrawal amount does not exceed 5000");
                        System.out.println();
                        continue;
                    }
                    if(Withdraw%100!=0) {
                        System.out.println("The withdrawal amount must be a multiple of 100");
                        System.out.println();
                        continue;
                    }
                    account.withdraw(account,Withdraw);
                    account.transactions("Withdraw",Withdraw);
                }
                else if (choose == 3) {
                    System.out.println("Your balance is " + account.getBalance());
                    System.out.print("Please enter the amount of your deposit > ");
                    double Deposit = input.nextDouble();
                    account.deposit(account,Deposit);
                    account.transactions("Deposit",Deposit);
                }
                else if (choose == 4){
                    account.transactionsSerch();
                }
                else if (choose == 5){
                    account.changePassword();
                }

                else {
                    break;
                }
            }
            break;
        }

    }
}
