package version1;

import java.util.Scanner;

public class StringStatistics {
    public static int countLetters(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++) {
            if ((s.charAt(i)>='a'&&s.charAt(i)<'z')||(s.charAt(i)>='A'&&s.charAt(i)<'Z')) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入字符串,我们将统计其中的字母个数 > ");
        String string = input.nextLine();
        System.out.println("这个字符串中的字母个数为： "+countLetters(string));
    }
}
