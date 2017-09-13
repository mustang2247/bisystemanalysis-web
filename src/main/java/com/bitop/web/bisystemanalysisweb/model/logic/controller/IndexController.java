package com.bitop.web.bisystemanalysisweb.model.logic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
@RequestMapping("/a")
public class IndexController {
    @RequestMapping({"/","/index"})
    public String index(Locale locale, Model model){
        return "index";
    }
}
