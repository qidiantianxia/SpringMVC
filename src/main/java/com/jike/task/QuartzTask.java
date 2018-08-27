package com.jike.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class QuartzTask {

	@Scheduled(cron = "0/5 * * * * ? ") // ���5��ִ��
	public void taskCycle() {
		System.out.println("ʹ��SpringMVC������ö�ʱ����");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
		System.out.println(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
	}
}
