package com.fengzhu.mpDemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fengzhu.mpDemo.dao.entity.User;
import com.fengzhu.mpDemo.dao.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where age > 10 and age != 100 or name like 'abc'")
    List<User> selectRaw();

    List<User> searchUsers(String name, Integer age);

    UserVO getUserById(Long id);

    UserVO getUserProfile(String token);

    String getUserSettings(String settings);
}
