package com.lzj.springbatch.config;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.lzj.quartz.QuartzConfiguration;
import com.lzj.springbatch.model.User;
import com.lzj.springbatch.processor.MyProcessor;
import com.lzj.springbatch.reader.MyReader;
import com.lzj.springbatch.writer.MyWriter;

@Configuration
@EnableBatchProcessing
//@Import({QuartzConfiguration.class})
public class BatchConfiguration {
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	
	/*创建job*/
	@Bean
	public Job jobMethod(){
		return jobBuilderFactory.get("lzjJob")
				.start(stepMethod())
				.build();
	}
	
	/*创建step*/
	@Bean
	public Step stepMethod(){
		return stepBuilderFactory.get("myStep")
				.<User, User>chunk(3)
				.reader(new MyReader())
				.processor(new MyProcessor())
				.writer(new MyWriter())
				.allowStartIfComplete(true)
				.build();
	}
	

}
