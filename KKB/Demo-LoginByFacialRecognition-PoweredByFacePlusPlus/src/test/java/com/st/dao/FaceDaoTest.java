package com.st.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class FaceDaoTest {

    private final FaceDao faceDao;

    FaceDaoTest(FaceDao faceDao) {
        this.faceDao = faceDao;
    }


    @Test
    void detect() {
        FaceDao.DetectResponseEntity detect = faceDao.detect("C:\\Users\\tonym\\Pictures\\test.png");
        System.out.println(detect);
    }

    @Test
    public void createFaceSet() {
        faceDao.faceSetCreate();
    }
    @Test
    public void getFaceSetDetail() {
        FaceDao.FaceSetResponseEntity e = faceDao.getFaceSetDetail();
        System.out.println(e);
    }

    @Test
    public void addFaceToFaceSet() {
        faceDao.addFaceToFaceSet("0bf0c6e5c2690db10ea8f5ce9f909b11");
    }

    @Test
    public void compareFace() {
        boolean b = faceDao.compareFace("90fa0a629ba4625e4d7070e371330c0e",
                "675ae0081a086252c318f984bf52cf8a");
        System.out.println(b);
    }
}