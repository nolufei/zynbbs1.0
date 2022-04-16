package com.zynbbs.service;

import com.zynbbs.mapper.FollowMapper;
import com.zynbbs.model.Follow;
import com.zynbbs.service.impl.SystemConfigService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Follow)表服务实现类
 *
 * @author tomoya
 * @since 2022-04-04 08:16:06
 */
@Service
public class FollowService extends ServiceImpl<FollowMapper, Follow> {

    @Resource
    private SystemConfigService systemConfigService;

    public int countByUserId(Integer userId) {
        LambdaQueryWrapper<Follow> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Follow::getUserId, userId);
        return super.count(wrapper);
    }

    public IPage<Follow> page(Integer pageNo, Integer userId) {
        IPage<Follow> page = new Page<>(pageNo, Integer.parseInt(systemConfigService
                .selectAllConfig().get("page_size").toString()));
        LambdaQueryWrapper<Follow> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Follow::getUserId, userId);
        return super.page(page, wrapper);
    }

    public Follow getByUserIdAndFollowUserId(Integer userId, Integer followUserId) {
        LambdaQueryWrapper<Follow> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Follow::getUserId, userId);
        wrapper.eq(Follow::getFollowUserId, followUserId);
        List<Follow> list = super.list(wrapper);
        return list.size() > 0 ? list.get(0) : null;
    }

    public void addFollow(Integer userId, Integer followUserId) {
        Follow follow = getByUserIdAndFollowUserId(userId, followUserId);
        if (follow != null) return;

        follow = new Follow();
        follow.setUserId(userId);
        follow.setFollowUserId(followUserId);
        follow.setInTime(new Date());
        super.save(follow);
    }

    public void cancelFollow(Integer userId, Integer followUserId) {
        LambdaQueryWrapper<Follow> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Follow::getUserId, userId);
        wrapper.eq(Follow::getFollowUserId, followUserId);
        super.remove(wrapper);
    }
}
