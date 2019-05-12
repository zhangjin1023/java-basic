package string;

public class Main {
    public static void main(String[] args) {
        String test = "20171010111126";
        System.out.println(test.substring(8));

        String msg = "asdasn你好sda我好【小随代还】";
        String msg2 = "asdasn你好sda我好【XXX】";
        String msg3 = "asdasn你好sda我好";

        System.out.println(addSign(msg3));
        System.out.println(addSign(msg2));
        System.out.println(addSign(msg));

        System.out.println("langyu:" + addSign_langyu(msg));
        System.out.println("langyu:" + addSign_langyu(msg2));
        System.out.println("langyu:" + addSign_langyu(msg3));
    }

    public static String addSign(String msg) {
        if (msg.contains("【小随代还】")) {
            System.out.println("02");
            return msg.replace("【小随代还】", "");//去除签名
        } else if (msg.contains("【XXX】")) {
            System.out.println("01");
            return msg.replace("【XXX】", "");//去除签名
        } else {
            System.out.println("01");//若短信内容没有签名，则默认【XXX】签名
            return msg;
        }
    }

    public static String addSign_langyu(String msg) {
        if (!msg.contains("【") && !msg.contains("】")) {
            return msg + "【XXX】";
        }
        return msg;
    }


}
