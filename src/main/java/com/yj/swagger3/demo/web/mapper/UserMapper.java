package com.yj.swagger3.demo.web.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.yj.swagger3.demo.web.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author wuzhouyang
 * @description 针对表【user】的数据库操作Mapper
 * @createDate 2023-12-21 17:33:18
 * @Entity generator.domain.User
 */
public interface UserMapper extends BaseMapper<User> {
    User selectByPrimaryKey(Integer id);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKey(User user);

    int insertUser(User user);

    List<User> selectAll();
}




