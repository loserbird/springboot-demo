package com.loserbird.springboot_batch.batch;

import javax.validation.ValidationException;

import org.springframework.batch.item.validator.ValidatingItemProcessor;

import com.loserbird.springboot_batch.domain.Person;

public class CsvItemProcessor extends ValidatingItemProcessor<Person>{
	@Override
	public Person process(Person item) throws ValidationException {
		super.process(item); 
		
		if(item.getNation().equals("汉族")){ 
			item.setNation("01");
		}else{
			item.setNation("02");
		}
		return item;
	}
}
