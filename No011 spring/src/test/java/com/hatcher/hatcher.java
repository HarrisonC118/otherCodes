package com.hatcher;

import com.hatcher.dao.UserDao;
import com.hatcher.service.UserService;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: HatcherCheung
 * Date:  2021/9/27
 */
public class hatcher {
    @Test
    public void testAutowired() throws Exception {
        UserService o = (UserService) Class.forName("com.hatcher.service.UserService").getDeclaredConstructor().newInstance();
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getClass().getTypeName());
            String methodName = "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
            System.out.println(methodName);
            Method declaredMethod = o.getClass().getDeclaredMethod(methodName, UserDao.class);
            declaredMethod.invoke(o, new UserDao());
        }
        o.saveUser("123");
    }
}
