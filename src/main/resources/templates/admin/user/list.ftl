<#include "../layout/layout.ftl"/>
<@html page_title="用户" page_tab="user">
    <section class="content-header">
        <h1>
            用户
            <small>列表</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/admin/index"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li><a href="/admin/user/list">用户</a></li>
            <li class="active">列表</li>
        </ol>
    </section>
    <section class="content">
        <div class="box box-info">
            <div class="box-header with-border">
                <h3 class="box-title">用户列表</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
                <form action="/admin/user/list" class="form-inline">
                    <div class="form-group" style="margin-bottom: 10px;">
                        <input type="text" id="username" name="username" value="${username!}" class="form-control"
                               placeholder="用户名">
                        <button type="submit" class="btn btn-primary btn-sm">搜索</button>
                    </div>
                </form>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>用户名</th>
                        <th>邮箱</th>
                        <th>积分</th>
                        <th>时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list page.records as user>
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.username!}</td>
                            <td>${user.email!}</td>
                            <td>${user.score!0}</td>
                            <td>${user.inTime?datetime}</td>
                            <td>
                                <a href="javascript:;" data-id="${user.id}" class="sendNotificationBtn btn btn-xs btn-primary">发送通知</a>
                                <#if sec.hasPermission("user:edit")>
                                    <a href="/admin/user/edit?id=${user.id}" class="btn btn-xs btn-warning">编辑</a>
                                </#if>
                                <#if sec.hasPermission("user:delete")>
                                    <button onclick="deleteUser('${user.id}')" class="btn btn-xs btn-danger">删除</button>
                                </#if>
                            </td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
        <button class="hidden" id="openModal" data-toggle="modal" data-target="#myModal"></button>
        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog modal-md" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                    aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">发送通知</h4>
                    </div>
                    <div class="modal-body">
                        <form onsubmit="return;" id="form">
                            <#--<input type="hidden" name="userId" id="userId" value=""/>-->
                            <input type="hidden" name="targetUserId" id="targetUserId" value=""/>
                            <div class="from-group">
                                <label for="name">内容</label>
                                <textarea class="form-control" name="content" id="content" cols="30" rows="7" placeholder="内容"></textarea>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
                        <button type="button" onclick="sendNotification()" class="btn btn-primary">发送</button>
                    </div>
                </div>
            </div>
        </div>
        <#include "../layout/paginate.ftl">
        <@paginate currentPage=page.current totalPage=page.pages actionUrl="/admin/user/list" urlParas=""/>
    </section>
    <script>
        <#if sec.hasPermission("user:delete")>

        $(function () {
            $(".sendNotificationBtn").click(function () {
                $("#targetUserId").val($(this).attr("data-id"));
                $("#openModal").click();
            })
        })

        function deleteUser(id) {
            if (confirm("确定要删除这个用户吗？\n 删除用户后，它发的帖子评论以及收藏就都没了，还请三思!!")) {
                $.get("/admin/user/delete?id=" + id, function (data) {
                    if (data.code === 200) {
                        toast("删除成功", "success");
                        setTimeout(function () {
                            window.location.reload();
                        }, 700);
                    } else {
                        toast(data.description);
                    }
                })
            }
        }

        function sendNotification() {
            // var userId = $("userId").val();
            var targetUserId = $("#targetUserId").val();
            var content = $("#content").val();
            $.post("/admin/notification/send", {
                targetUserId: targetUserId,
                content: content
            }, function (data) {
                if (data.code === 200) {
                    toast("删除成功", "success");
                    setTimeout(function () {
                        window.location.reload();
                    }, 700);
                } else {
                    toast(data.description);
                }
            })
        }

        </#if>
    </script>
</@html>
