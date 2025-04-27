package com.fengzhu.mpDemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fengzhu.mpDemo.dao.bo.dto.UserDTO;
import com.fengzhu.mpDemo.dao.entity.User;
import com.fengzhu.mpDemo.dao.qo.UserQO;
import com.fengzhu.mpDemo.dao.vo.UserVO;
import com.fengzhu.mpDemo.mapper.UserMapper;
import com.fengzhu.mpDemo.service.UserService;
import com.fengzhu.mpDemo.utils.CopyTools;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean createUser(UserDTO userDTO) {
        User user = new User();
        // 将DTO的属性拷贝到Entity
        BeanUtils.copyProperties(userDTO, user);
        // 插入
        return userMapper.insert(user) > 0;
    }

    @Override
    public List<UserVO> listAllUsers() {
        List<User> users = userMapper.selectList(new QueryWrapper<>());
        List<UserVO> vos = new ArrayList<>();
        for (User user : users) {
            UserVO vo = new UserVO();
            BeanUtils.copyProperties(user, vo);
            vos.add(vo);
        }
        return vos;
    }

    // 新增用户
    @Override
    public void addUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user); // dto转entity
        userMapper.insert(user);
    }

    // 查询用户列表
    @Override
    public List<UserVO> listUsers(UserQO userQO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (userQO.getNameLike() != null) {
            queryWrapper.like("name", userQO.getNameLike());
        }
        if (userQO.getMinAge() != null) {
            queryWrapper.ge("age", userQO.getMinAge());
        }
        if (userQO.getMaxAge() != null) {
            queryWrapper.le("age", userQO.getMaxAge());
        }

        List<User> users = userMapper.selectList(queryWrapper);

        List<UserVO> result = CopyTools.copyList(users, UserVO.class);

        return result;
    }

    @Override
    public List<UserVO> searchUsers(String name, Integer age) {
        List<User> users = userMapper.searchUsers(name, age);
        List<UserVO> vos = new ArrayList<>();
        for (User user : users) {
            UserVO vo = new UserVO();
            BeanUtils.copyProperties(user, vo);
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public UserVO searchUsers(Long id) {
        User user = userMapper.selectById(id);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }
}
