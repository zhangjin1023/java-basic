package string;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSplit {
    public static void main(String[] args) {
        String test = "20110725160412,0\n1234567890100";
        System.out.println(test);

        String content = "尊敬的客户，您正在开通银行尾号 3117 银行卡快捷支付，验证码为 566493 ，验证码请勿泄露。";
        String replacedContent = content.replaceAll("[0-9]", "");//去掉数字
        System.out.println(replacedContent);
        System.out.println("字节数：" + replacedContent.getBytes().length);

        Date date = new Date();
        SimpleDateFormat formate = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        System.out.println("日期时间：" + formate.format(date));


    }

}
