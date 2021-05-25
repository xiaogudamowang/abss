package com.leiduoduo.abss.service;

import com.leiduoduo.abss.pojo.Sort;

import java.util.List;

public interface SortService {
    List<Sort> getSortList();

    int addSort(String sortName);

    int delSort(String sortCode);
}
