package com.example.catalog.repository;

import com.example.catalog.model.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StyleDataRepository extends JpaRepository<Style,Integer> {
    @Query(nativeQuery = true,value="select * from springboot_mysql_student.style where style_id=:styleId")
    List<Style> getStyleByStyleId(int styleId);
}
