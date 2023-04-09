/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.example.funituremall.controller;

import com.example.funituremall.model.Furniture;
import com.example.funituremall.service.FurnitureService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/furniture")
public class FurnitureController {

    @Autowired
    private FurnitureService furnitureService;

    @CrossOrigin(origins = "https://my-react-app-0cn2.onrender.com")
    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Furniture> queryAll() {
        return furnitureService.queryAll();
    }

    @CrossOrigin(origins = "https://my-react-app-0cn2.onrender.com")
    @RequestMapping(value = "/queryById", method = RequestMethod.GET)
    @ResponseBody
    public Furniture queryById(String id, String username) {
        return furnitureService.queryById(id, username);
    }

    @CrossOrigin(origins = "https://my-react-app-0cn2.onrender.com")
    @RequestMapping(value = "/queryByName", method = RequestMethod.GET)
    @ResponseBody
    public List<Furniture> queryByName(String name) {
        return furnitureService.queryByName(name);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Furniture insert(@RequestBody Furniture furniture) {
        return furnitureService.insert(furniture);
    }
}