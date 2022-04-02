package com.zynbbs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zynbbs.model.User;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created by tomoya.
 * Copyright (c) 2018, All Rights Reserved.
 * https://yiiu.co
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    int countToday();
}
