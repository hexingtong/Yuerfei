<style>
    /*翻页*/
    .pagenation {
        padding: 40px 30px 60px 0;
        color: #666;
        -webkit-touch-callout:none;
        -webkit-user-select:none;
        -khtml-user-select:none;
        -moz-user-select:none;
        -ms-user-select:none;
        user-select:none;}

    .pagenation .pagenum {
        float: left;
        min-width: 30px;
        padding: 3px 5px;
        text-align: center;
        margin-right: 5px;
        cursor: pointer;
        font-size: 14px;
        border-radius: 3px;
        background: #f5f5f5;
        border: 1px solid #ddd;
        box-sizing: border-box;
    }

    .pagenation .pagenum.indexpage, .pagenation .pagenum.lastpage, .pagenation .pagenum.nextpage {
        background: rgba(255,255,255,0);
        color: #d9cfce;
    }

    .pagenation .pagenum.indexpage.active, .pagenation .pagenum.lastpage.active, .pagenation .pagenum.nextpage.active {
        background-color: #f5f5f5;
        color: #999;
    }

    .pagenation .pagenum.indexpage.active a, .pagenation .pagenum.lastpage.active a, .pagenation .pagenum.nextpage.active a {
        color: #999;
    }

    .pagenation .pagenum.pagetext, .pagenation .pagenum.totalpage {
        border-radius: 0px;
        background: rgba(255,255,255,0);
        border: none;
    }

    .pagenation .pagenum a {
        color: #999;
        text-decoration: none;
        display: block;
        width: 100%;
        height: 100%;
    }

    .pagenation .pageswiperbox {
        min-width: 35px;
        max-width: 175px;
        overflow: hidden;
        word-break: keep-all;
        white-space: nowrap;
        text-overflow: ellipsis;
        float: left;
    }

    .pagenation .pageswiper {
        width: auto;
    }

    .pagenation .pageswiper .pagenum {
        display: inline-block;
        float: none;
    }

    .pagenation .pagenum.curpage {
        background: rgba(255,255,255,0);
        color: #FE7200;
        border: none;
    }

    .pagenation .pagenum.curpage a {
        color: #FE7200;
        display: block;
        width: 100%;
    }

    .pagenation .pageinput {
        text-align: center;
        border: 1px solid #e5e5e5;
        width: 40px;
        margin: 0 3px;
        line-height: 17px;
        box-sizing: border-box;
        vertical-align: top;
    }

    .pagenation .pagesubbtn {
        background: rgba(255,255,255,0);
    }

    .pagenation .pagesubbtn a {
        color: #d9cfce;
    }

    .pagenation .pagesubbtn.active {
        background: #f5f5f5;
    }

    .pagenation .pagesubbtn a {
        color: #999;
    }
</style>
<script>
    function index(){
        $(location).attr('href', '${ctx }/url/indexUrl')
    }
    function MeberUrl() {
        $(location).attr('href', '${ctx }/url/MeberUrl')
    }
    function goodsAuthbuteUrl(){
        $(location).attr('href', '${ctx }/url/goodsAuthbuteUrl')
    }
    function GoodsUrl(){
        $(location).attr('href', '${ctx }/url/GoodsUrl')
    }

    function TagUrl(){
        $(location).attr('href', '${ctx }/url/TagUrl')
    }
    function MerchantUrl(){
        $(location).attr('href', '${ctx }/url/MerchantUrl')
    }
    function Supermarket(){
        $(location).attr('href', '${ctx }/url/SupermarketUrl')
    }
    function GenerallzeUrl(){
        $(location).attr('href', '${ctx }/url/GenerallzeUrl')
    }
    function MangerUrl(){
        $(location).attr('href', '${ctx }/url/MangerUrl')
    }
</script>
<div class="indexcontent-left">
    <div class="indexcontent-left-header">
        <img class="left-img1" src="${ctx }/images/logo.svg">
    </div>
    <div class="indexcontent-left-face">
        <div>
            <img class="left-img1" src="${ctx }/${user.img}">
        </div>
    </div>
    <div class="indexcontent-left-list">
        <div class="indexcontent-left-list-main">

            <div class="indexcontent-left-item active">
                <div class="indexcontent-left-item-left">
                    <i class="iconfont"></i>
                </div>
                <div class="indexcontent-left-item-middle" onclick="index()">欢迎来到首页</div>
                <div class="indexcontent-left-item-right">
                    <i class="iconfont"></i>
                </div>
            </div>
            <div class="indexcontent-left-item">
                <div class="indexcontent-left-item-left">
                    <i class="iconfont"></i>
                </div>
                <div class="indexcontent-left-item-middle" onclick="MeberUrl()">会员管理列表</div>
                    <div class="indexcontent-left-item-right">
                    <i class="iconfont"></i>
                </div>
            </div>
            <div class="indexcontent-left-item">
                <div class="indexcontent-left-item-left">
                    <i class="iconfont"></i>
                </div>
                <div class="indexcontent-left-item-middle" onclick="GoodsUrl()">商户管理列表</div>
                <div class="indexcontent-left-item-right">
                    <i class="iconfont"></i>
                </div>
            </div>
            <div class="indexcontent-left-item">
                <div class="indexcontent-left-item-left">
                    <i class="iconfont"></i>
                </div>
                <div class="indexcontent-left-item-middle" onclick="goodsAuthbuteUrl()">产品属性列表</div>
                <div class="indexcontent-left-item-right">
                    <i class="iconfont">
                        </i></div>
            </div>
            <div class="indexcontent-left-item">
                <div class="indexcontent-left-item-left"><i class="iconfont"></i></div>
                <div class="indexcontent-left-item-middle" onclick="TagUrl()">标签展示列表</div>
                <div class="indexcontent-left-item-right"><i class="iconfont"></i></div>
            </div>
            <div class="indexcontent-left-item">
                <div class="indexcontent-left-item-left"><i class="iconfont"></i></div>
                <div class="indexcontent-left-item-middle" onclick="MerchantUrl()" >商户展示列表</div>
                <div class="indexcontent-left-item-right"><i class="iconfont"></i></div>
            </div>
            <div class="indexcontent-left-item">
                <div class="indexcontent-left-item-left"><i class="iconfont"></i></div>
                <div class="indexcontent-left-item-middle" onclick="Supermarket()">超市展示列表</div>
                <div class="indexcontent-left-item-right"><i class="iconfont"></i></div>
            </div>
            <div class="indexcontent-left-item">
                <div class="indexcontent-left-item-left"><i class="iconfont"></i></div>
                <div class="indexcontent-left-item-middle" onclick="GenerallzeUrl()">推广链接列表</div>
                <div class="indexcontent-left-item-right"><i class="iconfont"></i></div>
            </div>
            <div class="indexcontent-left-item">
                <div class="indexcontent-left-item-left"><i class="iconfont"></i></div>
                <div class="indexcontent-left-item-middle" onclick="MangerUrl()">管理人员列表</div>
                <div class="indexcontent-left-item-right"><i class="iconfont"></i></div>
            </div>
        </div>
    </div>
</div>
