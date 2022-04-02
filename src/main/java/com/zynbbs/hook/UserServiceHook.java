package com.zynbbs.hook;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by tomoya.
 * Copyright (c) 2018, All Rights Reserved.
 * https://yiiu.co
 */
public class UserServiceHook {

    @Pointcut("execution(public * com.zynbbs.service.IUserService.selectByUsername(..))")
    public void selectByUsername() {
    }

    @Pointcut("execution(public * com.zynbbs.service.IUserService.selectByToken(..))")
    public void selectByToken() {
    }

    @Pointcut("execution(public * com.zynbbs.service.IUserService.selectById(..))")
    public void selectById() {
    }

    @Pointcut("execution(public * com.zynbbs.service.IUserService.delRedisUser(..))")
    public void delRedisUser() {
    }

}
