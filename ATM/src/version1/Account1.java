package version1;

/**
 * 版本1
 * 类的创造和算法的实现
 *
 * 分为两个功能：
 * 1、存款
 * 2、取款
 *
 * @author 11603080209 代利文
 */

import java.math.BigDecimal;
import java.util.Date;
import java.util.Scanner;

public class Account1 {
    Scanner input = new Scanner(System.in);
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;
    BigDecimal bg;

    public Account1() {
        dateCreated = new Date();
    }

    public Account1(int id, double balance) {
        this.id = id;
        this.balance = balance;
        dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        annualInterestRate = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        this.annualInterestRate = annualInterestRate;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public double getMonthlyInterest() {
        return balance * (annualInterestRate / 1200);
    }

    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    public void withdraw(Account1 a,double withdraw) {
        while (true) {
            if (withdraw > a.getBalance()) {
                System.out.println("Your balance is insufficient");
                System.out.println();
                break;
            } else if (withdraw < 0) {
                System.out.println("Please enter a number bigger than 0");
                System.out.println();
                break;
            } else if (withdraw > 5000) {
                System.out.println("The daily withdrawal amount does not exceed 5000");
                System.out.println();
                break;
            } else {
                System.out.println("You have made a successful withdrawal!");
                a.setBalance(a.getBalance()-withdraw);
                System.out.println("Your balance is " + a.getBalance());
                System.out.println();
                break;
            }
        }
    }

    public void deposit(Account1 a,double deposit) {
        while (true) {
            if (deposit < 0) {
                System.out.println("Please enter a number bigger than 0");
                System.out.println();
                break;
            } else {
                System.out.println("You have made a successful deposit!");
                a.setBalance(a.getBalance()+deposit);
                System.out.println("Your balance is " + a.getBalance());
                System.out.println();
                break;
            }
        }
    }
}
