package com.bitop.web.bisystemanalysisweb.model.logic.validator.web;

import com.bitop.web.bisystemanalysisweb.model.logic.validator.entity.PersonForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

/**
 * Created by fangzhipeng on 2017/4/19.
 */
@Controller
public class WebController extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("validator/results").setViewName("results");
    }

    @GetMapping("/validator")
    public String showForm(PersonForm personForm) {
        return "validator/form";
    }

    @PostMapping("/validator")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "validator/form";
        }

        return "redirect:validator/results";
    }
}
