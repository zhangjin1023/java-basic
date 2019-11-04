package htttpclient;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @Date : 2019/11/2 12:54
 * @Author : zhang_jin
 */
public class HttpClientTest {
    public static void main(String[] args){
        Map map = new HashMap();
        map.put("a","aaa");
        map.put("b","aaa");
        map.put("c","aaa");
        String jsonString = JSON.toJSONString(map);
        post("http://localhost:12317/peppa/loan/loanApply/F1908051000100160105/ZY",jsonString,null);
    }

    public static String post(String url, String jsonParams, Map<String, String> headers) {
        String output = null;
        HttpResponse response = null;
        CloseableHttpClient httpClient = null;
        RequestConfig.Builder configBuilder = RequestConfig.custom();
        // 设置连接超时
        configBuilder.setConnectTimeout(30000);
        // 设置读取超时
        configBuilder.setSocketTimeout(30000);
        RequestConfig requestConfig = configBuilder.build();
        try {
            httpClient = HttpClients.createDefault();
            HttpPost request = new HttpPost(url);
            request.setConfig(requestConfig);
            request.setHeader("Accept", "*/*");
            request.setHeader("Content-Type", "application/json");
            // add request header
            if (headers != null && !headers.isEmpty()) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    request.setHeader(entry.getKey(), entry.getValue());
                }
            }
            // add request body
            if (StringUtils.isNotEmpty(jsonParams)) {
                StringEntity input = new StringEntity(jsonParams, "utf-8");
                request.setEntity(input);
            }
            response = httpClient.execute(request);
            output = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("POST调用异常");
        }
        if (response.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("非200状态码,调用方异常.状态码为 " + response.getStatusLine().getStatusCode()); //当前针对短信发送,只处理此状态码
        }
        return output;
    }
}
