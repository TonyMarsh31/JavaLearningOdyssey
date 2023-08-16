package com.st.controller;

import com.st.service.FaceService;
import com.st.utils.ImageUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
@RequestMapping("/admin/face")
public class FaceController {
    private final FaceService service;

    public FaceController(FaceService service) {
        this.service = service;
    }

    /**
     * 跳转页面到登录页面
     *
     * @return face/login
     */
    @RequestMapping("/tologin")
    public String toLogin() {
        return "face/login";
    }

    /**
     * 跳转页面到录入信息页面
     *
     * @return face/input
     */
    @RequestMapping("/toinput")
    public String toInput() {
        return "face/input";
    }


    @ResponseBody
    @RequestMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("imgData") String imgData, HttpServletRequest request) {
        String savePath = request.getServletContext().getRealPath("/img/face/");
        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + ".png";
        System.out.println(savePath);
        ImageUtils.generateImage(imgData.substring(22), savePath, fileName);

        service.addFaceToFaceSet(savePath + "/" + fileName);
        return ResponseEntity.ok("success");
    }

    @ResponseBody
    @RequestMapping("/login")
    public ResponseEntity<String> login(@RequestParam("imgData") String imgData, HttpServletRequest request) {
        String savePath = request.getServletContext().getRealPath("/img/face/");
        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + ".png";
        System.out.println(savePath);
        ImageUtils.generateImage(imgData.substring(22), savePath, fileName);

        boolean result = service.loginByFace(savePath + "/" + fileName);
        if (result) {
            return ResponseEntity.ok("登录成功");
        } else {
            return ResponseEntity.ok("登录失败");
        }
    }
}
