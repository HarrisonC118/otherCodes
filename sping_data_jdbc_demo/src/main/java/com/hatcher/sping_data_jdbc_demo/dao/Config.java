package com.hatcher.sping_data_jdbc_demo.dao;

import com.hatcher.sping_data_jdbc_demo.entity.Demo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.conversion.MutableAggregateChange;
import org.springframework.data.relational.core.mapping.event.BeforeSaveCallback;

/**
 * @author: HatcherCheung
 * @Date: 2021/12/12
 * @Description:
 */
@Configuration
public class Config {
//	@Bean
//	public BeforeSaveCallback<Object> beforeSaveCallback(){
//		return ((aggregate, aggregateChange) -> {
//			if(aggregate instanceof Demo){
//				Demo demo = (Demo) aggregate;
//				if(demo.getId()==null){
//					demo.setId("1123232");
//				}
//			}
//			return aggregate;
//		});
//	}

}
