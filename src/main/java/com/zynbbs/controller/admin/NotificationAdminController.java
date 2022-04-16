package com.zynbbs.controller.admin;

import com.zynbbs.service.INotificationService;
import com.zynbbs.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by tomoya.
 * Copyright (c) 2018, All Rights Reserved.
 * https://yiiu.co
 */
@Controller
@RequestMapping("/admin/notification")
public class NotificationAdminController extends BaseAdminController {

    @Resource
    private INotificationService notificationService;

    // 保存编辑后的用户信息
    @PostMapping("/send")
    @ResponseBody
    public Result send(String content, Integer targetUserId) {
        if (StringUtils.isEmpty(content)) return error("请输入通知内容");
        if (targetUserId == null) return error("请选择发给谁");
        notificationService.insert(0, targetUserId, 0, "SYSTEM", content);
        return success();
    }

}
