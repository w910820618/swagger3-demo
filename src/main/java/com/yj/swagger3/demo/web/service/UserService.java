package com.yj.swagger3.demo.web.service;

import com.yj.swagger3.demo.web.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author wuzhouyang
 * @description 针对表【user】的数据库操作Service
 * @createDate 2023-12-21 17:33:18
 */
public interface UserService extends IService<User> {
    User selectByPrimaryKey(Integer id);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKey(User user);

    int addUser(User user);

    List<User> selectAll();
}
