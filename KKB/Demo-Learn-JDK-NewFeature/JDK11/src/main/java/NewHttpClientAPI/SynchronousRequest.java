package NewHttpClientAPI;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SynchronousRequest {
    public static void main(String[] args) throws IOException, InterruptedException {
        //1.先创建HttpClient对象
        HttpClient client = HttpClient.newHttpClient();
        //2.创建HttpRequest请求
        HttpRequest getRequest = HttpRequest.newBuilder().GET()
                .uri(URI.create("https://www.baidu.com")).build();
        //3.使⽤HttpClient发送request，得到response
        HttpResponse<String> response = client.send(getRequest,
                HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();
        System.out.println(responseBody);
    }
}
