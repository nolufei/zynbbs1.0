package com.zynbbs.hook;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by tomoya.
 * Copyright (c) 2018, All Rights Reserved.
 * https://yiiu.co
 */
public class TopicServiceHook {

    @Pointcut("execution(public * com.zynbbs.service.ITopicService.search(..))")
    public void search() {
    }

    @Pointcut("execution(public * com.zynbbs.service.ITopicService.selectById(..))")
    public void selectById() {
    }

    @Pointcut("execution(public * com.zynbbs.service.ITopicService.update(..))")
    public void update() {
    }

    @Pointcut("execution(public * com.zynbbs.service.ITopicService.vote(..))")
    public void vote() {
    }

    @Pointcut("execution(public * com.zynbbs.service.ITopicService.updateViewCount(..))")
    public void updateViewCount() {
    }

}
