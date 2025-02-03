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
@Table(name="STYLE")
public class Style {
    @Id
    @Column(name="bmc_id")
    private String bmcId;
    @Column(name="style_id")
    private int styleId;
    private LocalDateTime actionTs;
    private String status;
}
