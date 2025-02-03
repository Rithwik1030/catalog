package com.example.catalog.service;

import com.example.catalog.model.*;
import com.example.catalog.repository.CcDataRepository;
import com.example.catalog.repository.SkuDataRepository;
import com.example.catalog.repository.StyleDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;

@Service
public class CreateDataService {

    @Autowired
    StyleDataRepository styleDataRepository;
    @Autowired
    SkuDataRepository skuDataRepository;
    @Autowired
    CcDataRepository ccDataRepository;

    public void createStyle(Style style) {
        styleDataRepository.save(style);
    }

    public void createCC(Cc cc) {
        ccDataRepository.save(cc);
    }

    public void createSku(Sku sku) {
        skuDataRepository.save(sku);
    }

    public StyleResponse getStyle(int productId,String productType) {
        //to get the entiry data from data base from style ,cc, sku
        List<Style> style ;
        List<Cc> cc ;
        List<Sku> sku ;


        if ("style".equalsIgnoreCase(productType)) {
            style = styleDataRepository.getStyleByStyleId(productId);
            cc = ccDataRepository.getCCByStyleId(productId);
            sku = skuDataRepository.getSkuByStyleId(productId);
        } else if ("CC".equalsIgnoreCase(productType)) {
            cc = ccDataRepository.getCCByCCId(productId);
            style = styleDataRepository.getStyleByStyleId(cc.get(0).getStyleId());
            sku = skuDataRepository.getSkuByStyleId(cc.get(0).getStyleId());
        } else {
            sku = skuDataRepository.getSkuBySkuId(productId);
            style = styleDataRepository.getStyleByStyleId(sku.get(0).getStyleId());
            cc = ccDataRepository.getCCByCCId(sku.get(0).getCcId());
        }
        //building the style hierarche data
        StyleResponse styleResponse = null;
        if (!style.isEmpty()) {
            styleResponse = StyleResponse.builder()
                    .styleId(style.get(0).getStyleId())
                    .build();
        }

        List<CcResponse> ccResponseList = new ArrayList<>();
        for (Cc cc1 : cc) {
            CcResponse ccResponse = CcResponse.builder()
                    .styleId(cc1.getStyleId())
                    .bmcId(cc1.getBmcId())
                    .ccId(cc1.getCcId())
                    .build();
            List<SkuResponse> skuResponsesList = new ArrayList<>();
            for (Sku sku1 : sku) {
                if (sku1.getCcId() == cc1.getCcId()) {
                    SkuResponse skuResponse = SkuResponse.builder()
                            .skuId(sku1.getSkuId())
                            .ccId(sku1.getCcId())
                            .styleId(sku1.getStyleId())
                            .bmcId(sku1.getBmcId())
                            .build();
                    skuResponsesList.add(skuResponse);
                }
            }
            ccResponse.setSkuResponseList(skuResponsesList);
            ccResponseList.add(ccResponse);
        }
        styleResponse.setCcList(ccResponseList);
        return styleResponse;
    }

}
