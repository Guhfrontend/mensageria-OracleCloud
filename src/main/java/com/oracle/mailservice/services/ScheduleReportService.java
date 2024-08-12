package com.oracle.mailservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class ScheduleReportService {

    @Autowired
    FileOSService fileOSService;

    @Autowired
    EmailService emailService;

    private List<String> emailList = Arrays.asList("jiyen36151@fuzitea.com");

    private final Integer ONE_HOUR_IN_MILISECONDS = 100 * 60 * 60;

    @Scheduled(fixedRate = 30000)
    public void sendReport(){
        try{
            String report = fileOSService.getReportFileContent("report.html");

            for (String email: emailList){
                emailService.sendReport(report,email);
            }


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
