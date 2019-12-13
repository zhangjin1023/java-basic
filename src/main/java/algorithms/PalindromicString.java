package algorithms;

/**
 * @description:判断字符串是否为 回文字符串
 * @Date : 2019/12/13 16:13
 * @Author : zhang_jin
 */
public class PalindromicString {
    public static void main(String[] args){
        System.out.println(isPalindromicString("a"));
        System.out.println(isPalindromicString("aa"));
        System.out.println(isPalindromicString("abca"));
        System.out.println(isPalindromicString("aba"));
        System.out.println(isPalindromicString("abba"));
    }

    public static boolean isPalindromicString(String str) {
        int lp = 0;// 左指针
        int rp = str.length() - 1;// 右指针

        while (lp < rp) {
            if (str.charAt(lp) == str.charAt(rp)) {
                lp++;
                rp--;
                continue;
            }
            return false;
        }
        return true;
    }

}
