package com.hatcher.eduService.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hatcher.R;
import com.hatcher.eduService.entity.EduTeacher;
import com.hatcher.eduService.entity.vo.TeacherQuery;
import com.hatcher.eduService.service.EduTeacherService;
import com.mysql.cj.util.StringUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author Hatcher
 * @since 2021-04-18
 */
@RestController
@RequestMapping("/eduService/edu-teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    @ApiOperation("查询所有数据")
    @GetMapping("/start")
    public R getAllInfo(){
        List<EduTeacher> list = eduTeacherService.list();
        return R.success().data("表中所有数据",list).message("查询数据成功");
    }
    @ApiOperation("根据id删除")
    @DeleteMapping("/{id}")
    public Boolean deleteTeacherService(@ApiParam("要删除的id值") @PathVariable("id") String id) {
        boolean b = eduTeacherService.removeById(id);
        return b;
    }
    @ApiOperation("分页查询")
    @GetMapping("/pageInfo/{current}/{limit}")
    public R getInfoByPage(@ApiParam("当前页")@PathVariable("current") Integer current,@ApiParam("一页有多少数据")@PathVariable("limit") Integer limit){
        Page<EduTeacher> p = new Page<>(current,limit);
        eduTeacherService.page(p);

        return R.success().data("当前页数据",p.getRecords());
    }

    @ApiOperation("条件查询教师")
    @PostMapping ("/queryTeacherCondition/{current}/{limit}")
    public R queryTeacherCondition(@ApiParam("当前页")@PathVariable("current") Integer current,
                                   @ApiParam("一页有多少数据")@PathVariable("limit") Integer limit,
                                   @ApiParam("查询条件")@RequestBody(required = false) TeacherQuery teacherQuery){
        String name = teacherQuery.getName();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        Integer level = teacherQuery.getLevel();

        Page<EduTeacher> p = new Page<>(current,limit);
        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isNullOrEmpty(name)){
            queryWrapper.like("name",name);
        }
        if (level != null){
            queryWrapper.eq("level",level);
        }
        if (!StringUtils.isNullOrEmpty(end)){
            queryWrapper.ge("gmt_create",begin);//大于等于
        }
        if (!StringUtils.isNullOrEmpty(end)){
            queryWrapper.le("gmt_create",end);//小于等于
        }
        eduTeacherService.page(p,queryWrapper);

        return R.success().data("当前页数据",p.getRecords());
    }
    @ApiOperation("添加教师")
    @PostMapping("/insertTeacher")
    public R insetTeacher(@ApiParam("教师信息")@RequestBody()EduTeacher eduTeacher){
        boolean save = eduTeacherService.save(eduTeacher);
        if (save){
            return R.success();
        }else {
            return R.error();
        }
    }
    @PostMapping("/selectById")
    @ApiOperation("根据id查询数据")
    public R selectInfoById(String id){
        EduTeacher byId = eduTeacherService.getById(id);
        return R.success().message(byId.toString());
    }
    @PostMapping("/changeInfoById")
    @ApiOperation("根据id修改内容")
    public R changeInfoById(@RequestBody EduTeacher eduTeacher){
        boolean b = eduTeacherService.updateById(eduTeacher);
        if (b){
            return R.success();
        }{
            return R.error();
        }
    }
}

