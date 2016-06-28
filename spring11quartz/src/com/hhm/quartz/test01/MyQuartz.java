package com.hhm.quartz.test01;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 测试任务调度器
 * @author 黄帅哥
 *
 */
public class MyQuartz extends QuartzJobBean{

	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		
		System.out.println(new Date()+"：这是quartz调度器”");
		
	}

}
