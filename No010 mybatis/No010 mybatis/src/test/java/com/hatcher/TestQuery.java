package com.hatcher;

import com.hatcher.dao.UserDao;
import com.hatcher.entity.Stu;
import com.hatcher.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author: HatcherCheung
 * Date:  2021/9/26
 */
public class TestQuery {
    @Test
    public void testQueryAll() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<Stu> allStu = mapper.getAllStu();
        allStu.forEach(System.out::println);
        MyBatisUtil.close(sqlSession);
    }

    @Test
    public void testQueryStuById() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        Stu stuById = mapper.getStuById(1237);
        MyBatisUtil.close(sqlSession);
        System.out.println(stuById);
    }

    @Test
    public void testQueryLike() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<Stu> likeName = mapper.getLikeStu("汪");
        MyBatisUtil.close(sqlSession);
        likeName.forEach(System.out::println);
    }

    @Test
    public void testLimitStu() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<Stu> likeName = mapper.getLimitStu(0,3);
        MyBatisUtil.close(sqlSession);
        likeName.forEach(System.out::println);
    }
}
