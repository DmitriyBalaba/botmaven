package com.bot_wash.mvc.controller;

import com.bot_wash.mvc.services.IndexServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    IndexServices indexServices;

    @RequestMapping(value = "/",method = RequestMethod.GET, name = "getIndex")
    public ModelAndView index(){
        ModelAndView view = new ModelAndView();
        indexServices.myMethod();
        view.setViewName("index");
        return view;
    }
}
