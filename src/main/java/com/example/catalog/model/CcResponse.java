package com.example.catalog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Setter
@Getter
@Builder
public class CcResponse {
    private String bmcId;
    private int ccId;
    private int styleId;
    private List<SkuResponse> skuResponseList;

}

