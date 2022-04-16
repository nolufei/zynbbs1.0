package com.zynbbs.controller.api;

import com.zynbbs.exception.ApiAssert;
import com.zynbbs.model.User;
import com.zynbbs.service.FollowService;
import com.zynbbs.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by tomoya.
 * Copyright (c) 2018, All Rights Reserved.
 * https://yiiu.co
 */
@RestController
@RequestMapping("/api/follow")
public class FollowApiController extends BaseApiController {

    @Resource
    private FollowService followService;

    // 关注用户
    @PostMapping("/{followUserId}")
    public Result get(@PathVariable Integer followUserId) {
        ApiAssert.notNull(followUserId, "你要关注谁呢？");
        User user = getApiUser();
        followService.addFollow(user.getId(), followUserId);
        return success();
    }

    // 取消关注
    @DeleteMapping("/{followUserId}")
    public Result delete(@PathVariable Integer followUserId) {
        ApiAssert.notNull(followUserId, "你要取消关注谁呢？");
        User user = getApiUser();
        followService.cancelFollow(user.getId(), followUserId);
        return success();
    }
}
