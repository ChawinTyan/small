package common.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by tianwenyuan on 2016/6/7.
 */
public class HttpClientTest {

    public static void main(String args[]) throws Exception {

//        System.out.println(SimpleHttpClient.httpPostRequest("http://10.40.190.217:19126/confirmation-web/sql/query","{\"sql\":\"select * from occupy_info limit 5\"}"));
        System.out.println(SimpleHttpClient.httpPostRequest("http://10.40.190.217:19130/movie-resource-web/sql/query","select * from cinema limit 5"));
    }
}
