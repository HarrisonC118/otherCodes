package com.hatcher.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: HatcherCheung
 * Date:  2021/9/26
 */
public abstract class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        InputStream resourceAsStream = null;
        try {
            // 读取xml配置文件
            resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            // 创建sqlSession工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                resourceAsStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取sqlSession对象
     * @return sqlSession对象
     */
    public static SqlSession getSqlSession() {
        // 用工厂获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }

    /**
     * 关闭sqlSession
     * @param sqlSession 需要关闭的sqlSession
     */
    public static void close (SqlSession sqlSession) {
        sqlSession.close();
    }
}
