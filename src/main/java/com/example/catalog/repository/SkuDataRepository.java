package com.example.catalog.repository;

import com.example.catalog.model.Sku;
import com.example.catalog.model.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkuDataRepository extends JpaRepository<Sku,Integer> {
    @Query(nativeQuery = true, value = "select * from springboot_mysql_student.sku where style_id=:styleId")
    List<Sku> getSkuByStyleId(int styleId);
    @Query(nativeQuery = true, value = "select * from springboot_mysql_student.sku where sku_id=:skuId")
    List<Sku> getSkuBySkuId(int skuId);
}
