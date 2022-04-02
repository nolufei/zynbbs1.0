package com.zynbbs.service;

import java.util.List;

import com.zynbbs.model.Tag;
import com.zynbbs.model.TopicTag;

/**
 * Created by tomoya.
 * Copyright (c) 2018, All Rights Reserved.
 * https://yiiu.co
 */
public interface ITopicTagService {
    List<TopicTag> selectByTopicId(Integer topicId);

    List<TopicTag> selectByTagId(Integer tagId);

    void insertTopicTag(Integer topicId, List<Tag> tagList);

    // 删除话题所有关联的标签记录
    void deleteByTopicId(Integer id);
}
