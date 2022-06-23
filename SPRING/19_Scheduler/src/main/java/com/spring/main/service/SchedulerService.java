package com.spring.main.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {

	
	//@Scheduled(fixedDelay = 5000) //ms 단위 5초 후 실행 -> 이전 작업이 끝나면 5초 후
	//@Scheduled(fixedRate = 5000) //ms 단위 5초 마다 실행 -> 이전 작업 실행 시작부터 5초 후
	//crontab: 리눅스에서 쓰는 스케쥴러 (사용법 차용)
	//초 분 시 일 월 요일 년도(생략 가능)
	@Scheduled(cron="0/5 * * * * mon-fri")
	public void loop() {
		System.out.println("주기적으로 하는 작업");
	}
	
	
	
	
}
