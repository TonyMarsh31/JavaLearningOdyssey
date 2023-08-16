package com.st.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SocketController {

    //中间跳转
    @GetMapping("/tosocket")
    public ModelAndView socket() {
        return new ModelAndView("websocket");
    }
}
