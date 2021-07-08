package com.employee.scheduler;

import java.util.Date;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
//@EnableAsync
public class TestScheduler {

	static int counter = 0;

	@Scheduled(initialDelay = 5000, fixedDelay = 2000)
	public void execute() throws InterruptedException {
		System.out.println("Into delay Rate at " + new Date());
		Thread.sleep(10000);
		System.out.println("Delayed Thread runs at " + new Date());
	}

	//@Async
	@Scheduled(fixedRate = 500)//spring.task.scheduling.pool.size=2 to increase threads
	public void execute2() throws InterruptedException {
		System.out.println(++counter + "Into Fixed Rate at " + new Date());
		Thread.sleep(10000);
		System.out.println("fixedRate Thread runs at " + new Date());
		counter = 0;
	}

	@Scheduled(cron = "*/3 * * * * ?")
	public void execute3() throws InterruptedException {
		System.out.println("Into cron Rate at " + new Date());
		Thread.sleep(2000);
		System.out.println("cron Thread runs at " + new Date());
	}

}
