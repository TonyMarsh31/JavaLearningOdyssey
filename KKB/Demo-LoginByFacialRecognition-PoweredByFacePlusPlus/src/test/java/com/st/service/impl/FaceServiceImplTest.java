package com.st.service.impl;

import com.st.service.FaceService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class FaceServiceImplTest {

    private final FaceService service;

    FaceServiceImplTest(FaceService faceService) {
        this.service = faceService;
    }

    @Test
    void loginByFace() {
        service.loginByFace("C:\\Users\\tonym\\Pictures\\test.png");
    }
}