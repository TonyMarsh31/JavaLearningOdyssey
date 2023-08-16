package NewHttpClientAPI;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsynchronousRequest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1.先创建HttpClient对象
        HttpClient client = HttpClient.newHttpClient();
        //2.创建HttpRequest请求
        HttpRequest getRequest = HttpRequest.newBuilder().GET()
                .uri(URI.create("https://www.baidu.com")).build();
        //3.使⽤HttpClient发送request，得到response
        CompletableFuture<HttpResponse<String>> completableFuture =
                client.sendAsync(getRequest,
                        HttpResponse.BodyHandlers.ofString());
        HttpResponse<String> stringHttpResponse = completableFuture.get();
        String body = stringHttpResponse.body();
        System.out.println(body);
    }
}
