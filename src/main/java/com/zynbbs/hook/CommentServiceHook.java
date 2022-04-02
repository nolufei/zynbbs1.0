package com.zynbbs.hook;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by tomoya.
 * Copyright (c) 2018, All Rights Reserved.
 * https://yiiu.co
 */
public class CommentServiceHook {

    @Pointcut("execution(public * com.zynbbs.service.ICommentService.selectByTopicId(..))")
    public void selectByTopicId() {
    }

    @Pointcut("execution(public * com.zynbbs.service.ICommentService.insert(..))")
    public void insert() {
    }

    @Pointcut("execution(public * com.zynbbs.service.ICommentService.update(..))")
    public void update() {
    }

    @Pointcut("execution(public * com.zynbbs.service.ICommentService.vote(..))")
    public void vote() {
    }

    @Pointcut("execution(public * com.zynbbs.service.ICommentService.delete(..))")
    public void delete() {
    }

}
