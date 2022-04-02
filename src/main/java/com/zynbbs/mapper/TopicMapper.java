package com.zynbbs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zynbbs.model.Topic;
import com.zynbbs.util.MyPage;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * Created by tomoya.
 * Copyright (c) 2018, All Rights Reserved.
 * https://yiiu.co
 */
public interface TopicMapper extends BaseMapper<Topic> {

    MyPage<Map<String, Object>> selectAll(MyPage<Map<String, Object>> iPage, @Param("tab") String tab);

    MyPage<Map<String, Object>> selectByTag(MyPage<Map<String, Object>> iPage, @Param("tag") String tag);

    MyPage<Map<String, Object>> selectByUserId(MyPage<Map<String, Object>> iPage, @Param("userId") Integer userId);

    MyPage<Map<String, Object>> selectAllForAdmin(MyPage<Map<String, Object>> iPage, @Param("startDate") String
            startDate, @Param("endDate") String endDate, @Param("username") String username);

    int countToday();

    MyPage<Map<String, Object>> search(MyPage<Map<String, Object>> iPage, @Param("keyword") String keyword);
}
