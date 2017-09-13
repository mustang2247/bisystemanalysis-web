package com.bitop.web.bisystemanalysisweb.model.logic.controller;

import com.bitop.web.bisystemanalysisweb.utils.IPAddressUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/track")
public class HelloWorldController {
	
    @RequestMapping("")
    public String index() {
        return "hello welcome";
    }

    @RequestMapping(value = "/install/{data}", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String install(@PathVariable("data") String data, HttpServletRequest httpServletRequest){
        String ip = IPAddressUtil.getClientIpAddress(httpServletRequest);
        System.out.println(ip);
        return data + ip;
    }

}