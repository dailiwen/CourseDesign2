package version1;

/**
 * 版本1
 * 控制台界面实现
 *根据算法，在控制台输出用户想要的功能
 * @author 11603080209 代利文
 */

import java.util.Scanner;

public class ATMMachine1 {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        Account1[] account = new Account1[100];
        for (int i = 0; i < 100; i++) {
            account[i] = new Account1(i, 1000);
        }
        while (true) {

            System.out.print("Please enter your account ID (0-99) > ");
            int accountChoose = input.nextInt();
            if (accountChoose < 0 || accountChoose > 99) {
                System.out.println("Please enter the correct order > 0-99");
                System.out.println();
                continue;
            }

            while (true) {
                System.out.println("Main menu");
                System.out.println("1:check balance");
                System.out.println("2:withdraw");
                System.out.println("3:deposit");
                System.out.println("4:exit");
                System.out.print("Choose the function you need(1-4) > ");
                int choose = input.nextInt();
                if ((choose == 1 || choose == 2 || choose == 3 || choose == 4) == false) {
                    System.out.println("Please enter the correct order > 1-4");
                    System.out.println();
                    continue;
                }
                System.out.println();
                if (choose == 1) {
                    System.out.println("Your balance is " + account[accountChoose].getBalance());
                    System.out.println();
                }
                else if (choose == 2) {
                    System.out.println("Your balance is " + account[accountChoose].getBalance());
                    System.out.print("Please enter the amount of your withdrawal > ");
                    double Withdraw = input.nextDouble();
                    account[accountChoose].withdraw(account[accountChoose],Withdraw);
                }
                else if (choose == 3) {
                    System.out.println("Your balance is " + account[accountChoose].getBalance());
                    System.out.print("Please enter the amount of your deposit > ");
                    double Deposit = input.nextDouble();
                    account[accountChoose].deposit(account[accountChoose],Deposit);
                }
                else {
                    break;
                }
            }
            break;
        }
    }
}
