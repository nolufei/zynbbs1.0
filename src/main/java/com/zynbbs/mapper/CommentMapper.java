package com.zynbbs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zynbbs.model.Comment;
import com.zynbbs.model.vo.CommentsByTopic;
import com.zynbbs.util.MyPage;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by tomoya.
 * Copyright (c) 2018, All Rights Reserved.
 * https://yiiu.co
 */
public interface CommentMapper extends BaseMapper<Comment> {

    List<CommentsByTopic> selectByTopicId(@Param("topicId") Integer topicId);

    MyPage<Map<String, Object>> selectByUserId(MyPage<Map<String, Object>> iPage, @Param("userId") Integer userId);

    MyPage<Map<String, Object>> selectAllForAdmin(MyPage<Map<String, Object>> iPage, @Param("startDate") String
            startDate, @Param("endDate") String endDate, @Param("username") String username);

    int countToday();
}
