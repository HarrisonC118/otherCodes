package com.hatcher.api;

import com.hatcher.mapper.UsersMapper;
import com.hatcher.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: HatcherCheung
 * Date:  2021/9/17
 */
@RestController
public class HelloWorld {
    private UsersMapper usersMapper;

    @Autowired
    public HelloWorld(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Transactional
    @GetMapping("hello")
    public Users hello() {
        return usersMapper.selectByPrimaryKey("1908017YR51G1XWH");
    }

    public void m() {
        System.out.println("12213135413");
    }
}
