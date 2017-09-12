package com.bitop.web.bisystemanalysisweb.model.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/track")
public class HelloWorldController {
	
    @RequestMapping("")
    public String index() {
        return "hello welcome";
    }

    @RequestMapping(value = "/install/{data}", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String install(@PathVariable("data") String data){
        return data;
    }

}