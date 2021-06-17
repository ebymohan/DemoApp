package org.joychou.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;



@Controller
public class Path {
	
    @RequestMapping("/path_traversal")
    public static String index(Model model, HttpServletRequest request) {
        String username = request.getUserPrincipal().getName();
        model.addAttribute("user", username);
        return "path_traversal";
    }
}
