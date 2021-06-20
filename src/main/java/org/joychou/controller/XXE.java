package org.joychou.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class XXE {
    @RequestMapping("/xxe")
    public static String xxeHome(Model model, HttpServletRequest request) {
        String username = request.getUserPrincipal().getName();
        model.addAttribute("user", username);
        return "xxe";
    }
    @RequestMapping("/xxe/post")
    public static String xxeVulnPost(Model model, HttpServletRequest request) {
        String username = request.getUserPrincipal().getName();
        model.addAttribute("user", username);
        return "xxe_post";
    }
}
