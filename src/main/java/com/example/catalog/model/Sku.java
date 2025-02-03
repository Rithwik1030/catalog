package com.example.catalog.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name="SKU")
public class Sku {
    @Id
    @Column(name="bmc_id")
    private String bmcId;
    private int skuId;
    private int ccId;
    private int styleId;
    private LocalDateTime actionTs;
    private String status;
}
