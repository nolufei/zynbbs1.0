package com.zynbbs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zynbbs.model.SensitiveWord;

import java.util.List;

/**
 * Created by tomoya.
 * Copyright (c) 2018, All Rights Reserved.
 * https://yiiu.co
 */
public interface ISensitiveWordService {
    void save(SensitiveWord sensitiveWord);

    void update(SensitiveWord sensitiveWord);

    List<SensitiveWord> selectAll();

    void deleteById(Integer id);

    IPage<SensitiveWord> page(Integer pageNo, String word);

    void updateWordById(Integer id, String word);

    SensitiveWord selectByWord(String word);
}
