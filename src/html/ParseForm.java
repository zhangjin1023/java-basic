package html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

public class ParseForm {
    public static void main(String[] args) {
        String formStr = "<form id=\"payment\" name=\"paymentForm\" action=\"http://pay.soopay.net/spay/pay/payservice.do\" method=\"post\">"
                + "<input type=\"hidden\" name=\"charset\" value=\"UTF-8\"/>"
                + "<input type=\"hidden\" name=\"amount\" value=\"1\"/>"
                + "<input type=\"hidden\" name=\"mer_id\" value=\"50147\"/>"
                + "<input type=\"hidden\" name=\"sign\" value=\"jcZt5UtAkVYw2zhGJLt+Omn8or3x1H2Mct9qI5lkWgeSZfNr0nPZ6YzgxU3hujPIBFzMgFQyaQeurv7b6/DG/2Tf1jrvNH3pXmF75sC9ugZAIrmqWlQ2pZZwlSt4y4uR7czQc47VbJrUxwMy6mFG7LlFgZJcLtJhUl+EiHsEjok=\"/>"
                + "<input type=\"hidden\" name=\"expire_time\" value=\"120\"/>"
                + "<input type=\"hidden\" name=\"notify_url\" value=\"http://118.89.64.85:8099/opfp-aip/orders/ump/callback\"/>"
                + "<input type=\"hidden\" name=\"amt_type\" value=\"RMB\"/>"
                + "<input type=\"hidden\" name=\"version\" value=\"4.0\"/>"
                + "<input type=\"hidden\" name=\"mer_date\" value=\"20170831\"/>"
                + "<input type=\"hidden\" name=\"gate_id\" value=\"ABC\"/>"
                + "<input type=\"hidden\" name=\"service\" value=\"req_front_page_pay\"/>"
                + "<input type=\"hidden\" name=\"pay_type\" value=\"B2CDEBITBANK\"/>"
                + "<input type=\"hidden\" name=\"interface_type\" value=\"02\"/>"
                + "<input type=\"hidden\" name=\"order_id\" value=\"U2017083100000000013\"/>"
                + "<input type=\"hidden\" name=\"res_format\" value=\"HTML\"/>"
                + "<input type=\"hidden\" name=\"sign_type\" value=\"RSA\"/>"
                + "<input type=\"hidden\" name=\"ret_url\" value=\"http://118.89.64.85:8099/opfp-aip/orders/ump/frontCallback\"/>"
                + "<input type=\"submit\" value=\"submit\" style=\"display:none;\">" + "</form>";

        System.out.println(parseToMap(formStr));
        System.out.println(parseToStr(formStr));
    }

    public static Map<String, String> parseToMap(String htmlStr) {
        Map<String, String> map = new HashMap<>();

        Document doc = Jsoup.parse(htmlStr);
        // 1.获取form的action属性
        Elements form = doc.getElementsByTag("form");
        String url = form.attr("action");
        map.put("url", url);

        // 2.获取form表单下的所有input元素
        Elements inputs = doc.getElementsByTag("input");
        for (Element element : inputs) {
            if (!element.attr("name").equals("") && !element.attr("name").equals("charset")) {
                map.put(element.attr("name"), element.attr("value"));
            }
        }
        return map;
    }

    /**
     * 返回字符串，属性之间用&隔开
     *
     * @param htmlStr
     * @return
     */
    public static String parseToStr(String htmlStr) {
        StringBuilder sb = new StringBuilder();
        Document doc = Jsoup.parse(htmlStr);

        // 2.获取form表单下的所有input元素
        Elements inputs = doc.getElementsByTag("input");
        for (Element element : inputs) {
            if (!element.attr("name").equals("")) {
                sb.append(element.attr("name")).append("=").append(element.attr("value")).append("&");
            }
        }
        String result = sb.toString();
        return result.substring(0, result.length() - 1);
    }

    /**
     * 获取表单属性 action
     *
     * @param htmlStr
     * @return
     */
    public static String getFormAttr(String htmlStr) {
        Document doc = Jsoup.parse(htmlStr);
        // 1.获取form的action属性
        Elements form = doc.getElementsByTag("form");
        String url = form.attr("action");
        return url;
    }

}
