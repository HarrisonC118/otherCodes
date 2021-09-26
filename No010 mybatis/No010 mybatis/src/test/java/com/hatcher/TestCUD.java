package com.hatcher;

import com.hatcher.dao.UserDao;
import com.hatcher.entity.Stu;
import com.hatcher.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: HatcherCheung
 * Date:  2021/9/26
 */
public class TestCUD {
    @Test
    public void save() throws IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        try {
            Stu stu = new Stu();
            stu.setAge(25);
            stu.setName("囍汪汪");
            mapper.saveUser(stu);
            System.out.println("新添加的ID是" + stu.getId());
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtil.close(sqlSession);
        }
    }
    @Test
    public void update() throws IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        try {
            Stu stu = new Stu();
            stu.setId(1237);
            stu.setAge(25);
            stu.setName("啊汪汪");
            mapper.updateUser(stu);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtil.close(sqlSession);
        }
    }    @Test
    public void delete() throws IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        try {
            mapper.deleteUser(1209);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtil.close(sqlSession);
        }
    }
}
