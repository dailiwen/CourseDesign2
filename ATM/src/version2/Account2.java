package version2;

/**
 * 版本2
 * 类的创造和算法的实现
 *
 * 分为六个功能：
 * 1、初始账户文件的创建
 * 2、登录状态判断和登录数据储存，根据返回Int值的不同和放入静态变量中
 * 3、注册状态判断和注册数据储存，根据返回Int值的不同和写入文件
 * 4、交易记录读取，通过读取交易记录文件，输出交易记录
 * 5、交易记录写入，通过写入文件实现，对交易记录的保存
 * 6、密码更改，更改用户数据文件的密码
 *
 * @author 11603080209 代利文
 */

import version1.Account1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Account2 extends Account1 {
    Scanner input = new Scanner(System.in);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList transactions) {
        this.transactions = transactions;
    }

    private String name;
    private String password;
    ArrayList transactions = new ArrayList();

    public Account2 () {
    }

    public Account2 (String name,String password,int id,double balance) {
        super(id,balance);
        this.name = name;
        this.password = password;
    }

    public void allCreat() throws IOException {
        try {
            File file = new File("ID.txt");
            FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i=100000;i<1000000;i++) {
                bw.write(String.valueOf(i)+"\n");
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    }

    public boolean login() throws IOException {
        Scanner input = new Scanner(System.in);
        ArrayList account = new ArrayList();                                        //构造ArrayList储存数据
        int judgment = 0;
        try {
            System.out.print("请输入你的账户ID > ");
            String ID = input.nextLine();

            System.out.print("请输入你的账户密码 > ");
            String password = input.nextLine();

            int count = 0;
            File logIn = new File("accounts.dat");
            if(logIn.isFile() && logIn.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(logIn));      //输出流
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {                           //读入数据件到ArrayList
                    account.add(lineTxt);
                    count++;
                }

                for (int i = 0; i < count; i++) {
                    if (i % 4 == 0) {
                        if (ID.equals(account.get(i))) {
                            if (password.equals(account.get(i + 2))) {
                                setId(Integer.parseInt(ID));
                                setPassword(password);
                                setBalance(Double.valueOf((String)account.get(i + 3)));
                                System.out.println("登录成功");
                                System.out.println();
                                judgment = 1;
                                break;
                            } else {
                                System.out.println("您输入的密码不正确，返回初始菜单");
                                System.out.println();
                                judgment = 2;
                                break;
                            }
                        }
                    }
                }

                if (judgment == 0) {
                    System.out.println("不存在此账户，返回初始菜单");
                    System.out.println();
                }
                read.close();

            }else{
                System.out.println("找不到指定的文件");
                judgment = 2;
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
            judgment = 2;
        }


        if (judgment == 1)
            return true;
        else
            return false;
    }




    public void register() throws IOException {
        Scanner input = new Scanner(System.in);
        ArrayList account = new ArrayList();                                        //构造ArrayList储存数据
        try {
            int count = 0;
            File file = new File("ID.txt");
            File registeredID = new File("accounts.dat");

            FileWriter fw1 = new FileWriter(file.getAbsoluteFile(),true);            //向文件中写入 true为可追加
            FileWriter fw2 = new FileWriter(registeredID.getAbsoluteFile(),true);
            BufferedWriter bw1 = new BufferedWriter(fw1);                                      //输入流
            BufferedWriter bw2 = new BufferedWriter(fw2);

            if(file.isFile() && file.exists()){
                InputStreamReader read = new InputStreamReader(new FileInputStream(file));      //输出流
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){                           //读入数据件到ArrayList
                    account.add(lineTxt);
                    count++;
                }
                int id = (int)(100000+Math.random()*900000);                                    //随机选取数字为ID
                bw2.write(account.get(id-100000)+"\n");                                    //向另一个文件输入ID保存
                while (true) {
                    System.out.println("您的账户ID是： "+account.get(id-100000));
                    System.out.print("请输入您的姓名  > ");
                    String name = input.nextLine();
                    bw2.write(name + "\n");
                    System.out.print("请设置您的密码 (6到10位) > ");
                    String passWord1 = input.nextLine();
                    if (passWord1.length()>10||passWord1.length()<6) {
                        System.out.println("密码长度过长，请重新设置");
                        System.out.println();
                        continue;
                    }
                    System.out.print("请重复您的密码 > ");
                    String passWord2 = input.nextLine();
                    if (passWord1.equals(passWord2)) {
                        bw2.write(passWord2 + "\n");
                        break;
                    }
                    else {
                        System.out.println("密码两次不一致，请重新设置密码");
                        System.out.println();
                        continue;
                    }
                }

                while (true) {
                    System.out.print("请设置您的账户余额 > ");
                    double balance = input.nextDouble();
                    if (balance<0) {
                        System.out.println("输入数据不合理，请重新输入");
                        System.out.println();
                        continue;
                    }
                    else {
                        bw2.write(balance + "\n");
                        System.out.println("设置成功");
                        System.out.println();
                        break;
                    }
                }
                System.out.println("注册成功，请重新登录");
                System.out.println();
                account.remove(id-100000);
                FileWriter fw = new FileWriter(file);
                fw.write("");
                for (int i =0;i<count-1;i++) {
                    bw1.write((String) account.get(i)+"\n");
                }
                bw1.close();
                bw2.close();
                read.close();
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    }

    public void transactionsSerch() throws IOException {
        try {
            int count1 = 0;
            transactions.clear();
            File Transactions = new File("transactions.dat");
            File fixBalance = new File("accounts.dat");
            if(Transactions.isFile() && Transactions.exists()) {
                InputStreamReader read1 = new InputStreamReader(new FileInputStream(Transactions));
                BufferedReader bufferedReader1 = new BufferedReader(read1);
                String lineTxt1 = null;
                while ((lineTxt1 = bufferedReader1.readLine()) != null) {                           //读入数据件到ArrayList
                    transactions.add(lineTxt1);
                    count1++;
                }

                String title = "id: "+getId();
                boolean judgment = false;
                for (int i=0;i<count1;i++) {
                    if(title.equals(transactions.get(i))) {
                        for (int n=i+1;n<count1;n=n+2) {
                            System.out.println(transactions.get(n));
                            System.out.println(transactions.get(n+1));
                            if(n+2<count1) {
                                String comPar = (String) transactions.get(n + 2);
                                if (comPar.charAt(0) == 'i') {
                                    break;
                                }
                            }
                        }
                    }
                }

                read1.close();
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        System.out.println();
    }

    public void transactions(String style,double change) throws IOException {
        try {
            int count1 = 0;
            int count2 = 0;
            ArrayList account = new ArrayList();
            transactions.clear();
            File Transactions = new File("transactions.dat");
            File fixBalance = new File("accounts.dat");
            if(Transactions.isFile() && Transactions.exists()) {
                InputStreamReader read1 = new InputStreamReader(new FileInputStream(Transactions));
                BufferedReader bufferedReader1 = new BufferedReader(read1);
                InputStreamReader read2 = new InputStreamReader(new FileInputStream(fixBalance));
                BufferedReader bufferedReader2 = new BufferedReader(read2);
                String lineTxt1 = null;
                String lineTxt2 = null;
                while ((lineTxt1 = bufferedReader1.readLine()) != null) {                           //读入数据件到ArrayList
                    transactions.add(lineTxt1);
                    count1++;
                }
                while ((lineTxt2 = bufferedReader2.readLine()) != null) {                           //读入数据件到ArrayList
                    account.add(lineTxt2);
                    count2++;
                }

                String title = "id: "+getId();
                boolean judgment = false;
                for (int i=0;i<count1;i++) {
                    if(title.equals(transactions.get(i))) {
                        transactions.add(i+1,style+" "+change+"  You balance is "+String.valueOf(getBalance()));
                        transactions.add(i+2,getDateCreated());
                        judgment = true;
                        count1 = count1+2;
                        break;
                    }
                }
                if (judgment == false) {
                    transactions.add(title);
                    transactions.add(style+" "+change+"  You balance is "+String.valueOf(getBalance()));
                    transactions.add(getDateCreated());
                    count1 = count1+3;
                }
                int balanceAdress = 0;
                for (int i = 0; i < count2; i++) {
                    if (String.valueOf(getId()).equals(account.get(i))) {
                        balanceAdress = i+3;
                        break;
                    }
                }
                account.remove(balanceAdress);
                account.add(balanceAdress,getBalance());


                FileWriter fw1 = new FileWriter(Transactions.getAbsoluteFile(),true);            //向文件中写入 true为可追加
                BufferedWriter bw1 = new BufferedWriter(fw1);
                FileWriter fw2 = new FileWriter(fixBalance.getAbsoluteFile(),true);            //向文件中写入 true为可追加
                BufferedWriter bw2 = new BufferedWriter(fw2);
                FileWriter fw = new FileWriter(Transactions);
                fw.write("");
                for (int i =0;i<count1;i++) {
                    bw1.write(transactions.get(i)+"\n");
                }
                FileWriter fw3 = new FileWriter(fixBalance);
                fw3.write("");
                for (int i =0;i<count2;i++) {
                    bw2.write(account.get(i)+"\n");
                }
                bw1.close();
                bw2.close();
                read1.close();
                read2.close();
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    }


    public void changePassword() throws IOException {
        Scanner input = new Scanner(System.in);
        ArrayList account = new ArrayList();                                        //构造ArrayList储存数据
        try {
            int count = 0;
            File changePassword = new File("accounts.dat");

            if(changePassword.isFile() && changePassword.exists()){
                InputStreamReader read = new InputStreamReader(new FileInputStream(changePassword));
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){                           //读入数据件到ArrayList
                    account.add(lineTxt);
                    count++;
                }

                int passwordAdress = 0;
                for (int i = 0; i < count; i++) {
                    if (String.valueOf(getId()).equals(account.get(i))) {
                        passwordAdress = i+2;
                        break;
                    }
                }
                while (true) {
                    System.out.println("您的账户ID是： "+getId());
                    System.out.print("请输入您旧的密码 > ");
                    String passWord = input.nextLine();
                    if (passWord.equals(getPassword()) == false) {
                        System.out.println("这不为旧密码，请重新输入");
                        System.out.println();
                        continue;
                    }
                    System.out.print("请重新设置您的密码 (6到10位) > ");
                    String passWord1 = input.nextLine();
                    if (passWord1.length()>10||passWord1.length()<6) {
                        System.out.println("密码长度过长，请重新设置");
                        System.out.println();
                        continue;
                    }
                    System.out.print("请重复您的密码 > ");
                    String passWord2 = input.nextLine();
                    if (passWord1.equals(passWord2)) {
                        account.remove(passwordAdress);
                        account.add(passwordAdress,passWord2);
                        break;
                    }
                    else {
                        System.out.println("密码两次不一致，请重新设置密码");
                        System.out.println();
                        continue;
                    }
                }
                FileWriter fw1 = new FileWriter(changePassword.getAbsoluteFile(),true);            //向文件中写入 true为可追加
                BufferedWriter bw = new BufferedWriter(fw1);
                FileWriter fw = new FileWriter(changePassword);
                fw.write("");
                for (int i =0;i<count;i++) {
                    bw.write((String) account.get(i)+"\n");
                }
                bw.close();
                read.close();
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    }
}
