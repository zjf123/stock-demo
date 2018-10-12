package com.ocean.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * TODO 描述
 *
 * @author lei.liu on 2018/10/11.
 */
@RestController
@RequestMapping
public class IndexController {

    @RequestMapping(value = {"/"},produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    public ModelAndView doSomething(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/index/index.html");
        return mv;
    }

    @RequestMapping(value = {"/{do}"},produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    public ModelAndView doSomething(@PathVariable(value = "do") String path){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/index/"+path+".html");
        return mv;
    }
}
