package com.lzj.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class QuartzJobLauncher extends QuartzJobBean {
/*方式一*/
//	private String jobName;
//	private JobLauncher jobLauncher;
//	private JobLocator jobLocator;
//
//	public String getJobName() {
//		return jobName;
//	}
//
//	public void setJobName(String jobName) {
//		this.jobName = jobName;
//	}
//
//	public JobLauncher getJobLauncher() {
//		return jobLauncher;
//	}
//
//	public void setJobLauncher(JobLauncher jobLauncher) {
//		this.jobLauncher = jobLauncher;
//	}
//
//	public JobLocator getJobLocator() {
//		return jobLocator;
//	}
//
//	public void setJobLocator(JobLocator jobLocator) {
//		this.jobLocator = jobLocator;
//	}
//
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		/*方式二*/
		JobDetail jobDetail = context.getJobDetail();
		JobDataMap jobDataMap = jobDetail.getJobDataMap();
		String jobName = jobDataMap.getString("jobName");
		JobLauncher jobLauncher = (JobLauncher) jobDataMap.get("jobLauncher");
		JobLocator jobLocator = (JobLocator) jobDataMap.get("jobLocator");
		System.out.println("jobName : " + jobName);
		System.out.println("jobLauncher : " + jobLauncher);
		System.out.println("jobLocator : " + jobLocator);
		JobKey key = context.getJobDetail().getKey();
		System.out.println(key.getName() + " : " + key.getGroup());
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Current time : " + sf.format(new Date()));
		
		try {
			Job job = jobLocator.getJob(jobName);
			JobExecution jobExecution = jobLauncher.run(job, new JobParameters());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
