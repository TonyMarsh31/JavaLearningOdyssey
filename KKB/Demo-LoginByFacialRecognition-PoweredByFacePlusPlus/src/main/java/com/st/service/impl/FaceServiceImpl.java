package com.st.service.impl;

import com.st.dao.FaceDao;
import com.st.service.FaceService;

public class FaceServiceImpl implements FaceService {

    private final FaceDao dao;

    public FaceServiceImpl(FaceDao dao) {
        this.dao = dao;
    }


    /**
     * 录入人脸信息到FaceSet
     *
     * @param filePath 图片路径
     */
    @Override
    public void addFaceToFaceSet(String filePath) {
        // 第一次添加时，FaceSet可能不存在
        FaceDao.FaceSetResponseEntity faceSet = null;
        try {
            faceSet = dao.getFaceSetDetail();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (faceSet == null) { // 若FaceSet不存在，则创建一个新的FaceSet
            dao.faceSetCreate();
        }

        // 首先进行人脸检测获取FaceToken
        FaceDao.DetectResponseEntity detect = dao.detect(filePath);
        // 循环遍历FaceToken(可能会一次录入到多张人脸从而生成多个FaceToken)，将其逐一添加到FaceSet中
        for (FaceDao.FaceEntity face : detect.getFaces()) {
            dao.addFaceToFaceSet(face.getFace_token());
        }

    }

    /**
     * 通过对比人脸信息，判断是否是同一个人，然后实现登录
     *
     * @param filePath 图片路径
     * @return 登录成功返回true，否则返回false
     */
    @Override
    public boolean loginByFace(String filePath) {
        boolean result = false;
        //region第一次登录时，FaceSet可能不存在
        FaceDao.FaceSetResponseEntity faceSet = null;
        try {
            faceSet = dao.getFaceSetDetail();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (faceSet == null) { // 若FaceSet不存在，则创建一个新的FaceSet，同时获取其中的信息
            dao.faceSetCreate();
            faceSet = dao.getFaceSetDetail();
            // todo 待完善：逻辑上存在漏洞，因为新创建的FaceSet中没有人脸信息，所以这次登录必定失败，应该提示用户先添加人脸信息
            //  但因为只会在第一次使用时会出错，并且这仅为一个demo，FaceSet数据正常应存入本地数据库，所以这里没有处理
        }
        //endregion

        //region 进行人脸检测获取FaceToken
        //进行人脸检测
        FaceDao.DetectResponseEntity detect = dao.detect(filePath);
        //获取检测到的人脸信息
        String faceToken;
        if (detect.getFace_num() > 0) {
            faceToken = detect.getFaces().get(0).getFace_token();//如果检测到多个人脸则只取第一个人脸的FaceToken
        } else {
            return false;//如果没有检测到人脸，则直接返回false
        }
        //endregion

        //region 对比FaceToken和FaceSet中的人脸信息
        for (String faceTokenInDB : faceSet.getFace_token()) {
            if (dao.compareFace(faceToken, faceTokenInDB)) {
                result = true;
                break;
            }
        }
        //endregion

        //todo 隐私数据，删除用户登录时上传到服务器的人脸图片
        return result;
    }
}

