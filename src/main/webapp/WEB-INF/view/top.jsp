<div class="indexcontent-right-top">
    <img  src="${ctx }/images/Full%20screen%20button.svg"/>
    <div class="indexcontent-right-top-right">
        <img  src="${ctx }/images/quit.svg"/>
        <p id="tuichu">退出</p>
    </div>
</div>
<script>
    $('#tuichu').click(function(){

        layer.confirm('是否退出', {
            btn: ['是','否'] //按钮
        }, function(){
            $(location).attr('href', '<%=basePath %>/admin2/loginOut')
        }, function(){

        });
    });

</script>