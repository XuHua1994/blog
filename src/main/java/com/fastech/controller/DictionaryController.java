package com.fastech.controller;

import com.fastech.base.Return;
import com.fastech.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin/dictionary")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

   
    @RequestMapping(value = "/{type}" ,method = RequestMethod.GET)
    public Return getDictionaryByType(@PathVariable String type) {

        return dictionaryService.getDictionaryByType(type) ;
    }
    
   
   
}
