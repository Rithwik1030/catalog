package com.example.catalog.repository;

import com.example.catalog.model.Cc;
import com.example.catalog.model.Sku;
import com.example.catalog.model.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CcDataRepository extends JpaRepository<Cc,Integer> {
    @Query(nativeQuery = true,value="select * from springboot_mysql_student.CC where style_id=:styleId")
    List<Cc> getCCByStyleId(int styleId);

    @Query(nativeQuery = true,value="select * from springboot_mysql_student.CC where cc_id=:ccid")
    List<Cc> getCCByCCId(int ccid);
}
