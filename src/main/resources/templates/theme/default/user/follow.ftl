<#include "../layout/layout.ftl"/>
<@html page_title="我的关注" page_tab="">
    <div class="row">
        <div class="col-md-9">
            <div class="card">
                <div class="card-header">
                    ${username!} 的关注
                </div>
                <table class="table">
                    <tr>
                        <th>用户名</th>
                        <th>积分</th>
                        <th>#</th>
                    </tr>
                    <#list page.records as follow>
                        <tr>
                            <td><a href="/user/${follow.user.username}">${follow.user.username}</a></td>
                            <td>${follow.user.score}</td>
                            <td>
                                <#if _user?? && _user.username == username>
                                    <button class="pull-right btn btn-sm btn-danger" data-id="${follow.followUserId}" id="cancelFollow">取消关注</button>
                                </#if>
                            </td>
                        </tr>
                    </#list>
                </table>
                <#include "../components/paginate.ftl"/>
                <@paginate currentPage=page.current totalPage=page.pages!0 actionUrl="/user/${username}/follow" urlParas=""/>
            </div>
        </div>
        <div class="col-md-3 d-none d-md-block">
            <#if _user??>
                <#include "../components/user_info.ftl"/>
            <#else>
                <#include "../components/welcome.ftl"/>
            </#if>
        </div>
    </div>
    <script>
        $(function () {
            $("#cancelFollow").click(function () {
                var _this = this;
                var targetUserId = $(this).attr("data-id");
                $(_this).button("loading");
                req("delete", "/api/follow/" + targetUserId, {}, "${_user.token!}", function (data) {
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
        });
    </script>
</@html>
