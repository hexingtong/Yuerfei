<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglibs.jsp" %>
<%--<% String path = request.getContextPath(); %>--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>推广链接</title>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <link rel="stylesheet" type="text/css" href="${ctx }/css/common.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/css/font/iconfont.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/css/zxf_page.css"/>
    <script type="text/javascript" src="${ctx }/js/zxf_page.js"></script>
    <script type="text/javascript" src="${ctx }/js/layer/layer.js"></script>
    <style>

    </style>
</head>
<body>
<div id="indexBox">
    <div class="indexcontent">
        <%@ include file="left.jsp" %>
<!--推广链接右边-->
            <div class="indexcontent-right7" style="display: block;">
                <div class="indexcontent-right-main">
                    <div class="indexcontent-right-top">
                        <img src="${ctx }/images/Full screen button.svg">
                        <div class="indexcontent-right-top-right">
                            <img src="${ctx }/images/quit.svg">
                            <p>退出</p>
                        </div>
                    </div>
                    <div class="indexcontent-right-bottom" style="height: 884px;">
                        <div class="indexcontent-right-bottom-main">
                            <div class="indexcontent-right-bottom-main-header">
                                <div class="indexcontent-header-title">推广链接列表</div>
                                <div class="indexcontent-header-search">
                                    <input placeholder="请输入搜索关键词">
                                    <div class="search-img">
                                        <img src="${ctx }/images/SEARCH.svg">
                                    </div>
                                </div>
                            </div>
                            <div class="indexcontent-right-bottom-main-content">
                                <div class="refresh">
                                    <div style="border:1px solid  rgb(239,242,250);">刷新</div>
                                    <div class="promote-add" style="margin-left:-30px;background: rgb(255,141,47);color:#fff;">新增</div>
                                    <div class="labelSelet" style="width:80%;height:90px;margin-left:20px;margin-top:10px;padding:0px;">
                                        <div class="labelSelet-main">
                                            <div class="selectDiv">
                                                <p>上架方式</p>
                                                <select class="select">
                                                    <option>全部</option>
                                                    <option>已保存</option>
                                                    <option>已上架</option>
                                                    <option>已下架</option>
                                                </select>
                                            </div>
                                            <div class="selectDiv">
                                                <p>排序方式</p>
                                                <select class="select">
                                                    <option>推荐级别</option>
                                                    <option>添加时间</option>
                                                    <option>点击量</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="promote-tab">
                                    <div class="promote-thead">
                                        <ul>
                                            <li>产品名称</li>
                                            <li>短链接</li>
                                            <li>上架状态</li>
                                            <li>添加时间</li>
                                            <li>PV</li>
                                            <li>UV</li>
                                            <li>注册</li>
                                            <li>操作</li>
                                        </ul>
                                    </div>
                                    <div class="promote-tbody1">
                                        <div class="promote-tbody-item">
                                            <ul>
                                                <li>某某贷</li>
                                                <li>http://www.baidu.com</li>
                                                <li>上架中</li>
                                                <li>2019.02.23</li>
                                                <li>20</li>
                                                <li>50</li>
                                                <li>2019-02-23 16:20:35</li>
                                                <li>
                                                    <div class="promotesets">
                                                        <div>图形数据</div>
                                                        <div class="promoteEditor">编辑</div>
                                                        <div>删除</div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="promote-tbody-items">
                                            <ul>
                                                <li>某某贷</li>
                                                <li>http://www.baidu.com</li>
                                                <li>上架中</li>
                                                <li>2019.02.23</li>
                                                <li>20</li>
                                                <li>50</li>
                                                <li>2019-02-23 16:20:35</li>
                                                <li>
                                                    <div class="promotesets">
                                                        <div>图形数据</div>
                                                        <div class="promoteEditor">编辑</div>
                                                        <div>删除</div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="promote-tbody-item">
                                            <ul>
                                                <li>某某贷</li>
                                                <li>http://www.baidu.com</li>
                                                <li>上架中</li>
                                                <li>2019.02.23</li>
                                                <li>20</li>
                                                <li>50</li>
                                                <li>2019-02-23 16:20:35</li>
                                                <li>
                                                    <div class="promotesets">
                                                        <div>图形数据</div>
                                                        <div class="promoteEditor">编辑</div>
                                                        <div>删除</div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="promote-tbody-items">
                                            <ul>
                                                <li>某某贷</li>
                                                <li>http://www.baidu.com</li>
                                                <li>上架中</li>
                                                <li>2019.02.23</li>
                                                <li>20</li>
                                                <li>50</li>
                                                <li>2019-02-23 16:20:35</li>
                                                <li>
                                                    <div class="promotesets">
                                                        <div>图形数据</div>
                                                        <div class="promoteEditor">编辑</div>
                                                        <div>删除</div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="promote-tbody-item">
                                            <ul>
                                                <li>某某贷</li>
                                                <li>http://www.baidu.com</li>
                                                <li>上架中</li>
                                                <li>2019.02.23</li>
                                                <li>20</li>
                                                <li>50</li>
                                                <li>2019-02-23 16:20:35</li>
                                                <li>
                                                    <div class="promotesets">
                                                        <div>图形数据</div>
                                                        <div class="promoteEditor">编辑</div>
                                                        <div>删除</div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="promote-tbody-items">
                                            <ul>
                                                <li>某某贷</li>
                                                <li>http://www.baidu.com</li>
                                                <li>上架中</li>
                                                <li>2019.02.23</li>
                                                <li>20</li>
                                                <li>50</li>
                                                <li>2019-02-23 16:20:35</li>
                                                <li>
                                                    <div class="promotesets">
                                                        <div>图形数据</div>
                                                        <div class="promoteEditor">编辑</div>
                                                        <div>删除</div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="promote-tbody-item">
                                            <ul>
                                                <li>某某贷</li>
                                                <li>http://www.baidu.com</li>
                                                <li>上架中</li>
                                                <li>2019.02.23</li>
                                                <li>20</li>
                                                <li>50</li>
                                                <li>2019-02-23 16:20:35</li>
                                                <li>
                                                    <div class="promotesets">
                                                        <div>图形数据</div>
                                                        <div class="promoteEditor">编辑</div>
                                                        <div>删除</div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>

                                    </div>
                                </div>
                                <div class="indexcontent-tabPage">
                                    <div class="zxf_pagediv7"><span class="disabled">上一页</span><span class="current">1</span><a href="javascript:;" class="zxfPagenum nextpage">2</a><a href="javascript:;" class="zxfPagenum">3</a><span>...</span><a href="javascript:;" class="nextbtn">下一页</a><span>共<b>20</b>页，</span><span>到第<input type="number" class="zxfinput" value="5">页</span><span class="zxfokbtn">确定</span></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
</body>
</html>