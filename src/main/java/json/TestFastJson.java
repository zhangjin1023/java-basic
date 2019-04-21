package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TestFastJson {

    public static void main(String[] args) {
        Girl g1 = new Girl("feifei", 1);
        List<Girl> list = new ArrayList<Girl>();
        list.add(g1);
        list.add(new Girl("mm", 2));

        // 1.将集合或者对象序列化为JSON
        System.out.println(JSON.toJSON(g1));
        System.out.println(JSON.toJSON(list));

        // 2.JSON串反序列化为对象
        Girl girl = JSON.parseObject("{\"name\":\"yuyu\",\"id\":3,\"age\":20}", Girl.class);
        System.out.println(girl);

        // 3.数组对象反序列化为集合
        String str = "[{\"name\":\"lili\",\"id\":4},{\"name\":\"hmm\",\"id\":5}]";
        System.out.println(JSON.parseArray(str, Girl.class));

        // 4.转化为JSONObject
        JSONObject jsonObject = JSON.parseObject("{\"name\":\"yuyu\",\"id\":3}");
        System.out.println(jsonObject.getString("name") + "," + jsonObject.getString("id"));
        System.out.println(jsonObject.getString("name") + "," + jsonObject.getBigInteger("id"));
        System.out.println(jsonObject.getString("age"));// 尝试获取不存在的key值,返回null

        //5.没有对象直接解析JSON数组
        JSONArray jarr = JSON.parseArray("[{\"name\":\"李明\",\"id\":19},{\"name\":\"张三\",\"id\":12}]");
        for (Object obj : jarr) {
            System.out.println(obj.toString());
        }
    }

}
