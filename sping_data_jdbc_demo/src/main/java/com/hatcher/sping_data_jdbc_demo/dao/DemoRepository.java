package com.hatcher.sping_data_jdbc_demo.dao;

import com.hatcher.sping_data_jdbc_demo.entity.Demo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: HatcherCheung
 * @Date: 2021/12/12
 * @Description:
 */
@Repository
public interface DemoRepository extends CrudRepository<Demo,String> {

}
