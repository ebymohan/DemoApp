package org.joychou.controller;


import com.alibaba.fastjson.JSON;
import org.apache.catalina.util.ServerInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Controller
public class Actuator {
	
    @RequestMapping("/actuator")
    public static String index(Model model, HttpServletRequest request) {
        String username = request.getUserPrincipal().getName();
        model.addAttribute("user", username);
        return "actuator";
    }
}
