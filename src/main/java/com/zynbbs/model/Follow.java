package com.zynbbs.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * (Follow)表实体类
 *
 * @author tomoya
 * @since 2022-04-04 08:16:05
 */
@TableName("follow")
public class Follow implements Serializable {

    private static final long serialVersionUID = -35003688211663227L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    // 用户id
    private Integer userId;

    // 关注的用户id
    private Integer followUserId;

    private Date inTime;

    @TableField(exist = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFollowUserId() {
        return followUserId;
    }

    public void setFollowUserId(Integer followUserId) {
        this.followUserId = followUserId;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "id=" + id +
                ", userId=" + userId +
                ", followUserId=" + followUserId +
                ", inTime=" + inTime +
                '}';
    }
}
