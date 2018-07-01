package version3;

/**
 * 版本3
 * 刽子手游戏算法
 * 4个功能：单词储存，单词选择，星号字符串创造，猜错判断。
 * 为后面的UI提供算法支持
 * @author 11603080209 代利文
 */

public class Algorithm {
    String words[] = {"that","interface","file","edit","refactor","navigte","analyze","build","window"};   //单词数组储存

    public String chooseWords() {             //单词选择
        int n = (int) (Math.random() * (words.length-1));
        String word = words[n];
        return word;
    }

    public String creatStart(String word) {  //星号字符串创造
        String start = new String();
        for (int i = 0;i<word.length();i++){
            start = start + "*";
        }
        return start;
    }

    public String guessWord(String guess,String words,String start) {  //猜错判断返回
        String guessWord = new String();
        for (int i = 0;i<words.length();i++) {
            if(guess.charAt(0)==words.charAt(i)) {
                guessWord = guessWord + guess;
            }
            else {
                if (start.charAt(i)!= '*'){
                    guessWord = guessWord + start.charAt(i);
                    continue;
                }
                guessWord = guessWord + "*";
            }
        }
        if(start.equals(guessWord))   //一个字母都没有猜到就返回1，
            return "1";
        return guessWord;
    }
}
