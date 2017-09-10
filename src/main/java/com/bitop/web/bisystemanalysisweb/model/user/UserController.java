package com.bitop.web.bisystemanalysisweb.model.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
@RequestMapping("/user/")
public class UserController {
    @RequestMapping({""})
    public String index(Locale locale, Model model){
        return "index";
    }
}
