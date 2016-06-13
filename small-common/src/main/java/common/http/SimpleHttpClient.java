package common.http;

import com.fasterxml.jackson.core.type.TypeReference;
import common.json.JsonUtil;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by tianwenyuan on 2016/6/13.
 */
public class SimpleHttpClient {

    private static CloseableHttpClient httpClient = HttpClientManager.getDefaultHttpClient();

    public static String httpGetRequest(String url) throws Exception{
        HttpGet httpGet = new HttpGet(url);
        return httpRequest(httpGet);
    }

    public static String httpPostRequest(String url, String requestMsg) throws Exception{
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(requestMsg,"UTF-8"));
        return httpRequest(httpPost);
    }

    private static String httpRequest(HttpUriRequest request) throws Exception{
        CloseableHttpResponse response = httpClient.execute(request);
        String responseStr = "";
        try {
            HttpEntity httpEntity = response.getEntity();
            if(response.getStatusLine().getStatusCode() == 200){
                responseStr = EntityUtils.toString(httpEntity);
            }
            EntityUtils.consume(httpEntity);
        } catch (Exception e) {
            request.abort();
            e.printStackTrace();
        } finally {
            response.close();
        }
        return responseStr;
    }

    public static UrlEncodedFormEntity parseJsonToEntity(String jsonStr){
        Map<String, Object> jsonMap = JsonUtil.parseObject(jsonStr, new TypeReference<Map<String, Object>>() {});
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if(jsonMap != null){
            for(Map.Entry<String, Object> map : jsonMap.entrySet()){
                NameValuePair nvp = new BasicNameValuePair(map.getKey(),map.getValue().toString());
                nvps.add(nvp);
            }
        }
        UrlEncodedFormEntity urlEncodedFormEntity = null;
        try {
            urlEncodedFormEntity = new UrlEncodedFormEntity(nvps);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return urlEncodedFormEntity;
    }

}
