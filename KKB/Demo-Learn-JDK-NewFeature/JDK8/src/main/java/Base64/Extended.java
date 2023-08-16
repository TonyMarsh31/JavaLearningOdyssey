package Base64;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

/**
 * Base64更多使用示例
 */
public class Extended {
    public static void main(String[] args) {
        //url编码
        String encodedString = Base64.getUrlEncoder().encodeToString("https://www.youtube.com".getBytes(StandardCharsets.UTF_8));
        System.out.println(encodedString);


        //Mime编码
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuilder.append(UUID.randomUUID());
        }
        byte[] mimeBytes = stringBuilder.toString().getBytes(StandardCharsets.UTF_8);
        String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
        System.out.println("Base64 编码字符串 (MIME) :\n" + mimeEncodedString);
    }
}
