<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<%@ taglib
        uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ taglib
        uri="http://www.springframework.org/tags" prefix="s"%><%@ taglib
        uri="http://www.springframework.org/tags/form" prefix="form"%><%@ taglib
        uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%@ taglib
        uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  <%@ page
        trimDirectiveWhitespaces="true"%><c:set var="ctx"
                                                value="${pageContext.request.contextPath}" />
<c:set var="path" value="${pageContext.request.contextPath}" />
<html>
<body>
<script src="${ctx }/resources/bower_components/jquery/dist/jquery.min.js"></script>
<script src="${ctx }/resources/others_js/jquery-1.9.1.min.js"></script>
<script src="${ctx }/resources/bower_components/jquery-ui/jquery-ui.min.js"></script>




<h2>Hello World!大个幅啪啪啪度订已试试深Vi单非凡哥</h2>的


<button type="button" class="btn btn-primary" style="margin-right: 30px;" id="edit">测数据</button>
<script>

    $(function (){

    alert("ddd")
            $.post('${ctx}/admin/admi',function (res){
                alert(res)
                ${key.id}
            })


      ;


    })
</script>
</body>
</html>
