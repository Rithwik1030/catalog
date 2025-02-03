package com.example.catalog.Controller;

import com.example.catalog.model.*;
import com.example.catalog.service.CreateDataService;
import org.hibernate.usertype.UserTypeLegacyBridge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreateDataController {
    @Autowired
    private CreateDataService createDataService;

    @PostMapping(path ="/style")
    public void createStyle(@RequestBody Style style) {
     createDataService.createStyle(style);
    }

    @PostMapping(path ="/cc")
    public void createStyle(@RequestBody Cc cc) {
        createDataService.createCC(cc);
    }

    @PostMapping(path ="/sku")
    public void createStyle(@RequestBody Sku sku) {
        createDataService.createSku(sku);
    }

    @GetMapping(path ="/getStyle")
    public StyleResponse getStyle(@RequestParam int productId,@RequestParam String productType) {
        StyleResponse responseData= createDataService.getStyle(productId,productType);
        return responseData;
    }


    @GetMapping(path ="/getStyle1")
    public StyleResponse getStyle1(@RequestParam int productId,@RequestParam String productType) {
        StyleResponse responseData= createDataService.getStyle(productId,productType);
        return responseData;
    }


}
