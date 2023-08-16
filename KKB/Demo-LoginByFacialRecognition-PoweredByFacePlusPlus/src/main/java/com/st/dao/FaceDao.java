package com.st.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

/**
 * 用于访问Face++人脸识别系统
 */
@ConfigurationProperties(prefix = "face.config")
@Component
public class FaceDao {

    private final RestTemplate restTemplate;
    private String apiKey;
    private String apiSecret;
    private String outerId;

    public FaceDao(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * 人脸检测 - 获得faceToken
     *
     * @param filePath 图片路径
     */
    public DetectResponseEntity detect(String filePath) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        // 普通域
        builder.part("api_key", apiKey);
        builder.part("api_secret", apiSecret);
        //文件域
        builder.part("image_file", new FileSystemResource(Paths.get(filePath)), MediaType.IMAGE_PNG);
        //build完整的消息体
        MultiValueMap<String, HttpEntity<?>> multipartBody = builder.build();

        ResponseEntity<DetectResponseEntity> responseEntity = restTemplate.postForEntity("https://api-cn.faceplusplus.com/facepp/v3/detect", multipartBody, DetectResponseEntity.class);

        return responseEntity.getBody();
    }

    /**
     * 创建faceSet
     * outer-id=travel-face-set
     */
    public void faceSetCreate() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("api_key", apiKey);
        map.add("api_secret", apiSecret);
        map.add("outer_id", outerId);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        restTemplate.postForEntity("https://api-cn.faceplusplus.com/facepp/v3/faceset/create", request, String.class);

    }

    /**
     * 根据得到outer-id=travel-face-set的信息
     */
    public FaceSetResponseEntity getFaceSetDetail() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("api_key", apiKey);
        map.add("api_secret", apiSecret);
        map.add("outer_id", outerId);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<FaceSetResponseEntity> responseEntity = restTemplate.postForEntity("https://api-cn.faceplusplus.com/facepp/v3/faceset/getdetail", request, FaceSetResponseEntity.class);
        return responseEntity.getBody();
    }


    /**
     * 添加faceToken到faceSet，即人脸录入
     */
    public void addFaceToFaceSet(String faceToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("api_key", apiKey);
        map.add("api_secret", apiSecret);
        map.add("outer_id", outerId);
        map.add("face_tokens", faceToken);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        restTemplate.postForEntity("https://api-cn.faceplusplus.com/facepp/v3/faceset/addface", request, String.class);

    }


    /**
     * 人脸对比
     * 登录时将摄像头录入的人脸与faceSet中的数据进行对比
     *
     * @param faceToken     人脸token
     * @param faceToCompare 待对比的人脸token
     * @return 对比结果
     */
    public boolean compareFace(String faceToken, String faceToCompare) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        // 普通域
        builder.part("api_key", apiKey);
        builder.part("api_secret", apiSecret);
        builder.part("face_token1", faceToken);
        builder.part("face_token2", faceToCompare);

        //build完整的消息体
        MultiValueMap<String, HttpEntity<?>> multipartBody = builder.build();

        ResponseEntity<CompareResponseEntity> responseEntity = restTemplate.postForEntity("https://api-cn.faceplusplus.com/facepp/v3/faceset/compare", multipartBody, CompareResponseEntity.class);

        System.out.println(responseEntity);
        CompareResponseEntity response = responseEntity.getBody();
        return Objects.requireNonNull(response).getConfidence() >= response.getThresholds().getE5();

    }

    /**
     *
     */
    @Data
    public static class DetectResponseEntity {
        private String request_id;
        private Integer face_num;
        private List<FaceEntity> faces;
    }

    /**
     * 人脸实体类
     */
    @Data
    public static class FaceEntity {
        private String face_token;

    }

    /**
     * faceSet返回的实体类
     */
    @Data
    public static class FaceSetResponseEntity {
        private String outer_id;
        private Integer face_count;
        private List<String> face_token;
    }

    /**
     * 人脸对比返回的实体类
     */
    @Data
    public static class CompareResponseEntity {
        private Double confidence; // 置信度
        private ThresholdResponseEntity thresholds; // 置信度阈值
    }

    /**
     * 人脸比对返回的阈值实体类
     */
    @Data
    public static class ThresholdResponseEntity {
        @JsonProperty("1e-5")
        private Double e5;
    }
}
