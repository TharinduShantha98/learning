package com.learning.tutorials.service;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ScheduleService {


    @Scheduled(fixedRate = 2000)
    @SchedulerLock(name = "sendEmailPromo",lockAtMostFor = "5m",lockAtLeastFor = "5s")
    public void sendEmailPromotion() {
        System.out.println("Scheduled task at " + new Date());

    }

}

