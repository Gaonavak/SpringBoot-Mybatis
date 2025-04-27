package com.fengzhu.mpDemo.service;

import com.fengzhu.mpDemo.dao.bo.dto.UserDTO;
import com.fengzhu.mpDemo.dao.qo.UserQO;
import com.fengzhu.mpDemo.dao.vo.UserVO;

import java.util.List;

public interface UserService {

    // 新增用户
    boolean createUser(UserDTO userDTO);

    // 查询所有用户
    List<UserVO> listAllUsers();

    void addUser(UserDTO userDTO);

    List<UserVO> listUsers(UserQO userQO);

    List<UserVO> searchUsers(String name, Integer age);

    UserVO searchUsers(Long id);
}
