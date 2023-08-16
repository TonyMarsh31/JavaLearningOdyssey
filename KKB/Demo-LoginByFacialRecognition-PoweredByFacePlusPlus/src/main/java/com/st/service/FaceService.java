package com.st.service;

public interface FaceService {

    /**
     * 录入人脸信息到FaceSet
     * @param filePath 图片路径
     */
    void addFaceToFaceSet(String filePath);

    /**
     * 通过对比人脸信息，判断是否是同一个人，然后实现登录
     * @return 登录成功返回true，否则返回false
     */
    boolean loginByFace(String filePath);
}
