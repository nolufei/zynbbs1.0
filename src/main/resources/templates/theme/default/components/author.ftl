<div class="card">
    <div class="card-header">
        作者
        <#if _user?? && _user.id != topicUser.id>
        <#if follow??>
            <button class="pull-right btn btn-sm btn-danger" id="cancelFollow">取消关注</button>
        <#else>
            <button class="pull-right btn btn-sm btn-primary" id="addFollow">添加关注</button>
        </#if>

            <script type="text/javascript">
                $(function () {
                    $("#cancelFollow").click(function () {
                        var _this = this;
                        $(_this).button("loading");
                        req("delete", "/api/follow/${topicUser.id}", {}, "${_user.token!}", function (data) {
                            if (data.code === 200) {
                                suc("取消关注成功");
                                setTimeout(function () {
                                    window.location.reload();
                                }, 700);
                            } else {
                                err(data.description);
                                $(_this).button("reset");
                            }
                        });
                    })
                    $("#addFollow").click(function () {
                        var _this = this;
                        $(_this).button("loading");
                        req("post", "/api/follow/${topicUser.id}", {}, "${_user.token!}", function (data) {
                            if (data.code === 200) {
                                suc("关注成功");
                                setTimeout(function () {
                                    window.location.reload();
                                }, 700);
                            } else {
                                err(data.description);
                                $(_this).button("reset");
                            }
                        });
                    })
                })
            </script>
        </#if>
    </div>
    <div class="card-body">
        <div class="media">
            <a href="/user/${topicUser.username}" class="mr-3">
                <img src="${topicUser.avatar!}" title="${topicUser.username}" class="avatar"/>
            </a>
            <div class="media-body">
                <div class="media-heading">
                    <a href="/user/${topicUser.username!}">${topicUser.username}</a>
                </div>
                <p>积分：${topicUser.score}</p>
            </div>
        </div>
        <div style="color: #7A7A7A; font-size: 12px;margin-top:5px;">
            <i>${(topicUser.bio!"这家伙很懒，什么都没有留下")?html}</i>
        </div>
    </div>
</div>
s