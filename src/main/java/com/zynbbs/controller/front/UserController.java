package com.zynbbs.controller.front;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zynbbs.model.Follow;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zynbbs.model.OAuthUser;
import com.zynbbs.model.User;
import com.zynbbs.service.ICollectService;
import com.zynbbs.service.IOAuthUserService;
import com.zynbbs.service.IUserService;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tomoya.
 * Copyright (c) 2018, All Rights Reserved.
 * https://yiiu.co
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource
    private IUserService userService;
    @Resource
    private ICollectService collectService;
    @Resource
    private IOAuthUserService oAuthUserService;
    @Resource
    private FollowService followService;

    @GetMapping("/{username}")
    public String profile(@PathVariable String username, Model model) {
        // 查询用户个人信息
        User user = userService.selectByUsername(username);
        // 查询oauth登录的用户信息
        List<OAuthUser> oAuthUsers = oAuthUserService.selectByUserId(user.getId());
        // 查询用户收藏的话题数
        Integer collectCount = collectService.countByUserId(user.getId());
        // 查询用户关注的用户数
        Integer followCount = followService.countByUserId(user.getId());

        // 找出oauth登录里有没有github，有的话把github的login提取出来
        List<String> logins = oAuthUsers.stream().filter(oAuthUser -> oAuthUser.getType().equals("GITHUB")).map
                (OAuthUser::getLogin).collect(Collectors.toList());
        if (logins.size() > 0) {
            model.addAttribute("githubLogin", logins.get(0));
        }

        model.addAttribute("user", user);
        model.addAttribute("username", username);
        model.addAttribute("oAuthUsers", oAuthUsers);
        model.addAttribute("collectCount", collectCount);
        model.addAttribute("followCount", followCount);
        return render("user/profile");
    }

    @GetMapping("/{username}/topics")
    public String topics(@PathVariable String username, @RequestParam(defaultValue = "1") Integer pageNo, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("pageNo", pageNo);
        return render("user/topics");
    }

    @GetMapping("/{username}/comments")
    public String comments(@PathVariable String username, @RequestParam(defaultValue = "1") Integer pageNo, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("pageNo", pageNo);
        return render("user/comments");
    }

    @GetMapping("/{username}/collects")
    public String collects(@PathVariable String username, @RequestParam(defaultValue = "1") Integer pageNo, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("pageNo", pageNo);
        return render("user/collects");
    }

    @GetMapping("/{username}/follow")
    public String follow(@PathVariable String username, @RequestParam(defaultValue = "1") Integer pageNo, Model model) {
        // 查询用户个人信息
        User user = userService.selectByUsername(username);
        IPage<Follow> page = followService.page(pageNo, user.getId());
        for (Follow record : page.getRecords()) {
            record.setUser(userService.selectById(record.getFollowUserId()));
        }
        model.addAttribute("username", username);
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("page", page);
        return render("user/follow");
    }
}