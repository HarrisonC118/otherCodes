package com.hatcher.sping_data_jdbc_demo.dao;

import com.hatcher.sping_data_jdbc_demo.entity.Demo;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

/**
 * @author: HatcherCheung
 * @Date: 2021/12/12
 * @Description:
 */
@SpringBootTest
public class test {
	@Autowired
	private DemoRepository template;

	@Test
	public void test1(){

		Demo demo = new Demo("1234","lucy11");
		demo.setVersion(0);
//		template.insert(demo);
		Optional<Demo> byId = template.findById("1234");
		if(byId.isPresent()) {
			Demo demo1 = byId.get();
			demo1.setName("hatcher");
			template.save(demo1);
		}
//		byId.setName("dashibi");
//		template.update(byId);


	}


}
