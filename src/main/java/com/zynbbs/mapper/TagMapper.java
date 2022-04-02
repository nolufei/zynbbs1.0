package com.zynbbs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zynbbs.model.Tag;
import com.zynbbs.util.MyPage;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * Created by tomoya.
 * Copyright (c) 2018, All Rights Reserved.
 * https://yiiu.co
 */
public interface TagMapper extends BaseMapper<Tag> {

    MyPage<Map<String, Object>> selectTopicByTagId(MyPage<Map<String, Object>> iPage, @Param("tagId") Integer tagId);

    int countToday();
}
