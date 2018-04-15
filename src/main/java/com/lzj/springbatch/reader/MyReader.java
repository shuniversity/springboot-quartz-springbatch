package com.lzj.springbatch.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.validation.BindException;

import com.lzj.springbatch.model.User;

public class MyReader extends FlatFileItemReader<User> {
	public MyReader(){
		createReader();
	}
	
	private void createReader(){
		this.setResource(new ClassPathResource("data/User.txt"));
		this.setLinesToSkip(1);
		this.setLineMapper(userLineMapper());
	}
	
	private LineMapper<User> userLineMapper(){
		DefaultLineMapper<User> lineMapper = new DefaultLineMapper<>();
		lineMapper.setLineTokenizer(userLineTokenizer());
		lineMapper.setFieldSetMapper(new UserFieldStepMapper());
		lineMapper.afterPropertiesSet(); 
		return lineMapper;
	}
	
    private LineTokenizer userLineTokenizer(){
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setNames(new String[]{"ID", "NAME", "AGE"});
        return tokenizer;
    }
    
    private static class UserFieldStepMapper implements FieldSetMapper<User>{
		@Override
		public User mapFieldSet(FieldSet fieldSet) throws BindException {
            return new User(fieldSet.readString("ID"), 
                    fieldSet.readString("NAME"), 
                    fieldSet.readString("AGE"));
		}

    }

    
}
