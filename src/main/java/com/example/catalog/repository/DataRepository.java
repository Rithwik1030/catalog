package com.example.catalog.repository;

import com.example.catalog.model.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataRepository {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


//    public ResponseData getResponseData(int styleId) {
//
//      List<ResponseData> responseDataList=  namedParameterJdbcTemplate.query("",ResponseData.class);
//    }
}
