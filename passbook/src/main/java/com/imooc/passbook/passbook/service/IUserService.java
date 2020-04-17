package com.imooc.passbook.passbook.service;

import com.imooc.passbook.passbook.vo.Response;
import com.imooc.passbook.passbook.vo.User;

/* 用户服务： 创建 User 服务 */
public interface IUserService {

    /* 创建用户 */
    Response createUser(User user) throws Exception;
}
