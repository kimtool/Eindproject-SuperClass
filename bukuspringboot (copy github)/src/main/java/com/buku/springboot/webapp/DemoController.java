/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.springboot.webapp;

import com.buku.springboot.webapp.domain.Demo;
import com.buku.springboot.webapp.domain.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kim Tool <kimtool@hotmail.com>
 */
@RestController
public class DemoController {
    
    @Autowired
    private DemoRepository demoRepository;
    
    @RequestMapping("/demos")
    public Iterable<Demo> getDemos(){
        return demoRepository.findAll();
    }
    
//    @RequestMapping("/demos")
//    public String getAllDemos(){
//        return "all demos";
//    }
    
}
