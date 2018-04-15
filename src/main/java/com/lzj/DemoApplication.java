package com.lzj;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@EnableBatchProcessing
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args){
		
//		SpringApplication app = new SpringApplication(DemoApplication.class);
//		Set<Object> set = new HashSet<>();
//		set.add("classpath:job.xml");
//		app.setSources(set);
//		ApplicationContext ctx = app.run(args);
		
//		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("job.xml");
//		
//		SimpleJobLauncher launcher = (SimpleJobLauncher) ctx.getBean("laucher");
//		Job job = (Job) ctx.getBean("jobExample");
//		System.out.println(launcher);
//		System.out.println(job);
//		launcher.run(job, new JobParameters());
//		ctx.close();
		
		SpringApplication.run(DemoApplication.class, args);
	}
}
