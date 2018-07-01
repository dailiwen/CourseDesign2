package version1;

/**
 * 版本1
 * 控制台上的刽子手游戏
 * @author 11603080209 代利文
 */

import java.util.Scanner;

public class version1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String words[] = {"write","that","program","math","remdom","create","steam","value","identical"};//单词储存

        String start = "***************************************";//星号字符储存

        for(;;){
            int n = (int) (Math.random()*words.length);//单词选择

            int i,count=0;
            int Length = words[n].length();
            boolean wordJudg = false,endJudg = true;
            String Ch;
            StringBuilder start1 = new StringBuilder(start.substring(0, Length));
            for(;;){
                System.out.print("(Guess) Enter a letter in word "+start1+" > ");
                Ch = input.nextLine();

                for(i=0;i<Length;i++){
                    if(Ch.charAt(0)==start1.charAt(i))
                        System.out.println(Ch.charAt(0)+" is already in the word");

                    if(words[n].charAt(i)==Ch.charAt(0)){
                        Ch=Ch.charAt(0)+"";
                        start1.replace(i,i+1,Ch);
                        wordJudg = true;
                    }
                }
                if(wordJudg==false){
                    System.out.println(Ch.charAt(0)+" is not in the word");
                    count++;
                }
                wordJudg = false;

                for(i=0;i<Length;i++)
                    if(start1.charAt(i)=='*')
                        endJudg = false;
                if(endJudg == true){
                    System.out.println("The word is "+start1+"."+"You missed "+count+" time");
                    break;
                }
                endJudg = true;
            }
            System.out.print("Do you want to guess another word? Enter y or n > ");
            String next = input.nextLine();
            if(next.charAt(0)=='n')
                break;
            System.out.println();
        }

        input.close();

    }

}


