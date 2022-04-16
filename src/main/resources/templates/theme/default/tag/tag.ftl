<#include "../layout/layout.ftl"/>
<@html page_title="郑意你论坛" page_tab="">

    <#if tag.name == "校园服务" || tag.name == "娱乐交友" || tag.name == "学术探讨" || tag.name == "其他服务">
        <style type="text/css">
            .wrapper {
                background-color: transparent !important;
            <#if tag.name == "校园服务"> background-image: url("/static/images/xiaoyuanfuwu.JPG");
            </#if><#if tag.name == "娱乐交友"> background-image: url("/static/images/yulejiaoyou.JPG");
            </#if><#if tag.name == "学术探讨"> background-image: url("/static/images/xueshujiaoliu.JPG");
            </#if><#if tag.name == "其他服务"> background-image: url("/static/images/qitafuwu.JPG");
            </#if> background-repeat: no-repeat;
                background-size: cover;
                height: 100vh;
            }
        </style>
    </#if>

    <div class="row">
        <div class="col-md-9">
            <div class="card">
                <div class="card-body">
                    <h4 style="margin-top: 0; margin-bottom: 10px;">
                        <#if tag.icon??>
                            <img src="${tag.icon}" width="32" alt="">
                        </#if>
                        ${tag.name}
                        <small>共有${tag.topicCount!0}篇话题</small>
                        <#if _user??>
                            <a href="/topic/create?tag=${tag.name}" class="btn btn-sm btn-info pull-right">发布话题</a>
                        </#if>
                    </h4>
                    <small>${tag.description!}</small>
                    <span></span>
                </div>
                <div class="divide"></div>
                <div class="card-body paginate-bot">
                    <#include "../components/topics.ftl"/>
                    <@topics page=page tags=false/>

                    <#include "../components/paginate.ftl"/>
                    <@paginate currentPage=page.current totalPage=page.pages actionUrl="/topic/tag/${tag.name}"/>
                </div>
            </div>
        </div>
        <div class="col-md-3 hidden-xs">
            <#if _user??>
                <#include "../components/user_info.ftl"/>
            <#else>
                <#include "../components/welcome.ftl"/>
            </#if>
        </div>
    </div>
</@html>
