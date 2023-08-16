package com.st.utils;

import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ImageUtils {
    public static boolean generateImage(String imgStr, String filePath, String fileName) {
        try {
            if (imgStr == null) {
                return false;
            }
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] b = decoder.decodeBuffer(imgStr);
            File file = new File(filePath);
            if (!file.exists()) {
                file.mkdirs();
            }
            OutputStream out = Files.newOutputStream(Paths.get(filePath + fileName));
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
