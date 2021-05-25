package com.leiduoduo.abss.service;

import com.leiduoduo.abss.dao.SortDao;
import com.leiduoduo.abss.pojo.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortServiceImpl implements SortService {
    @Autowired
    SortDao sortDao;

    @Override
    public List<Sort> getSortList() {
        return sortDao.getSortList();
    }

    @Override
    public int addSort(String sortName) {
        Sort sort = new Sort();
        sort.setSortCode(System.currentTimeMillis()+"");
        sort.setSortName(sortName);
        return sortDao.addSort(sort);
    }

    @Override
    public int delSort(String sortCode) {
        return sortDao.delSort(sortCode);
    }
}
