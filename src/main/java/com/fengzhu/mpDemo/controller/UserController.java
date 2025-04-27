package com.fengzhu.mpDemo.controller;

import com.fengzhu.mpDemo.dao.bo.dto.UserDTO;
import com.fengzhu.mpDemo.dao.qo.UserQO;
import com.fengzhu.mpDemo.dao.vo.ResponseVO;
import com.fengzhu.mpDemo.dao.vo.UserVO;
import com.fengzhu.mpDemo.exception.BusinessException;
import com.fengzhu.mpDemo.service.UserService;
import com.fengzhu.mpDemo.utils.ResponseTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController extends ResponseTools {

    @Autowired
    private UserService userService;

    // 查询所有用户
    @GetMapping
    public ResponseVO<List<UserVO>> listUsers() {
        List<UserVO> users = userService.listAllUsers();
        return getSuccessResponseVo(users);
    }

    @GetMapping("/error")
    public ResponseVO<String> errorTest() {
        if (true) {
            throw new BusinessException(400, "自定义的业务异常，比如参数错误");
        }
        return getServerErrorResponseVo("ok");
    }

    // 查询用户列表（用QO接收查询条件）
    @PostMapping("/list")
    public ResponseVO<List<UserVO>> listUsers(@RequestBody UserQO userQO) {
        List<UserVO> userVOS = userService.listUsers(userQO);
        return getSuccessResponseVo(userVOS);
    }

    // 1. 使用 @RequestBody 接收 POST 请求体中的 JSON 数据
    @PostMapping("/add")
    public ResponseVO<String> createUser(@RequestBody UserDTO userDTO) {
        boolean result = userService.createUser(userDTO);
        return result ? getSuccessResponseVo("success") : getServerErrorResponseVo("error");
    }

    // 2. 使用 @RequestParam 接收查询参数
    @GetMapping("/search")
    public ResponseVO<List<UserVO>> searchUsers(@RequestParam String name, @RequestParam Integer age) {
        List<UserVO> userVOS = userService.searchUsers(name, age);
        return userVOS != null ? getSuccessResponseVo(userVOS) : getServerErrorResponseVo(userVOS);
    }

    // 3. 使用 @PathVariable 接收路径参数
    @GetMapping("/getByid/{id}")
    public ResponseVO<UserVO> getUser(@PathVariable Long id) {
        UserVO userVO = userService.searchUsers(id);
        return getSuccessResponseVo(userVO);
    }

}
