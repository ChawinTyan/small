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

    private static HttpClient client = SimpleHttpClient.getHttpClient(123);

    public static void main(String args[]) throws Exception {


        HttpGet httpget = new HttpGet("http://passport.tuniu.com/login/checkLogin?origin=" + URLEncoder.encode("http://172.17.69.234:9191/small/login/authByName", "UTF-8"));

        System.out.println("Executing request " + httpget.getRequestLine());

        // Create a custom response handler
        ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
            @Override
            public String handleResponse(
                    final HttpResponse response) throws ClientProtocolException, IOException {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            }
        };
        String responseBody = client.execute(httpget, responseHandler);
        System.out.println("----------------------------------------");
        System.out.println(responseBody);
    }
}
