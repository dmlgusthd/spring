package com.blog.dmlgusthd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class BookDisuse {
	@Autowired
	LibraryDao libraryDao;
	
	//17시 마다 스케줄러가 실행된다
    @Scheduled(cron = "0 0 17 * * *")
    public void cronTest1(){
    	System.out.println("---DisuseScheduler 작동---");
        try {
            int value = libraryDao.disuseDelete();
            if(value>0){
            	System.out.println("---폐기예정일이 넘은 도서 "+value+"개가 삭제되었습니다.---");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
