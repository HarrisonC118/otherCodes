package com.hatcher.dao;

import com.hatcher.entity.Stu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: HatcherCheung
 * Date:  2021/9/26
 */
public interface UserDao {
    /**
     * 添加用户信息
     * @param stu 要添加的对象
     * @return 影响数据的数量
     */
    int saveUser(Stu stu);

    /**
     * 更新用户信息
     * @param stu 要更新的对象
     * @return 影响数据的数量
     */
    int updateUser(Stu stu);

    /**
     * 根据id删除记录
     * @param id 要删除的id
     * @return 影响数据的数量
     */
    int deleteUser(int id);

    /**
     * 获取所有Stu数据
     * @return Stu的集合
     */
    List<Stu> getAllStu();

    /**
     * 获取指定Id的数据
     * @param id id
     * @return stu对象
     */
    Stu getStuById(Integer id);

    /**
     * 根据姓名模糊查询
     * @param name 姓名
     * @return 查到的数据
     */
    List<Stu> getLikeStu(String name);

    /**
     * 分页查询
     * @param start 起始位置
     * @param rows 每页显示的条数
     * @return 每页的数据
     */
    List<Stu> getLimitStu(@Param("start") Integer start, @Param("rows")Integer rows);
}
