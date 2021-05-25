package com.leiduoduo.abss.service.scheduling;

import com.leiduoduo.abss.dao.BookShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulService {
    @Autowired
    BookShopDao bookShopDao;

    @Scheduled(cron = "0 0 0 * * ?")
    public void updMemberTiem(){
        bookShopDao.updMemberTiemSchedul();
    }
}
