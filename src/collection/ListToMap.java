/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: zhang_jin[zhang_jin@suixingpay.com]
 * @date: 2018年11月20日 下午11:01:17
 * @Copyright ©2018 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author: zhang_jin[zhang_jin@suixingpay.com]
 * @date: 2018年11月20日 下午11:01:17
 * @version: V1.0
 * @review: zhang_jin[zhang_jin@suixingpay.com]/2018年11月20日 下午11:01:17
 */
public class ListToMap {
    public static void main(String[] args) {
        List<AcceptBank> list = new ArrayList<>();// 模拟从表中查出来的全部一级行别数据
        list.add(new AcceptBank("100", "01"));
        list.add(new AcceptBank("101", "01"));
        list.add(new AcceptBank("102", "01"));
        List<String> secList103 = new ArrayList<>();
        secList103.add("0103001");
        secList103.add("0103002");
        secList103.add("0103003");
        secList103.add("0103004");
        list.add(new AcceptBank("103", "02", secList103));
        List<String> secList104 = new ArrayList<>();
        secList104.add("0104001");
        secList104.add("0104002");
        secList104.add("0104003");
        secList104.add("0104004");
        list.add(new AcceptBank("104", "02", secList104));
        list.add(new AcceptBank("105", "01"));
        // ListToMap,key为bankCd,Value为AcceptBank
        Map<String, AcceptBank> map = new HashMap<>();
        map = list.stream().collect(Collectors.toMap(AcceptBank::getBankCd, a -> a, (k1, k2) -> k1));
        System.out.println(map);

    }

}
