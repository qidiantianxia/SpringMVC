package com.jike.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class QuartzTask {

	@Scheduled(cron = "0/5 * * * * ? ") // 间隔5秒执行
	public void taskCycle() {
		System.out.println("使用SpringMVC框架配置定时任务");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
	}
}
