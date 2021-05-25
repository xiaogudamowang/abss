package com.leiduoduo.abss.dao;

import com.leiduoduo.abss.pojo.Sort;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SortDao {
    List<Sort> getSortList();
    /*
    通过类别编号获取类别名称
     */
    String getNameByCode(String Code);

    int addSort(Sort sort);

    int delSort(String sortCode);
}
