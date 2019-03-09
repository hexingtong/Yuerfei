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
<%--<c:set var="path" value="${pageContext.request.contextPath}" />--%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>测试页面4</title>
    <script type="text/javascript">

        function iframeCallback(form, callback) {
            YUNM.debug("带文件上传处理");

            var $form = $(form), $iframe = $("#callbackframe");

            // 富文本编辑器
            $("div.editor", $form).each(
                function() {
                    var $this = $(this);
                    var editor = "<input type='hidden' name='" + $this.attr("name") + "' value='"
                        + $.base64.btoa($this.html()) + "' />";
                    $form.append(editor);
                });

            var data = $form.data('bootstrapValidator');
            if (data) {
                if (!data.isValid()) {
                    return false;
                }
            }

            if ($iframe.size() == 0) {
                $iframe = $("<iframe id='callbackframe' name='callbackframe' src='about:blank' style='display:none'></iframe>")
                    .appendTo("body");
            }
            if (!form.ajax) {
                $form.append('<input type="hidden" name="ajax" value="1" />');
            }
            form.target = "callbackframe";

            _iframeResponse($iframe[0], callback || YUNM.ajaxDone);
        }
        function _iframeResponse(iframe, callback) {
            var $iframe = $(iframe), $document = $(document);

            $document.trigger("ajaxStart");

            $iframe.bind("load", function(event) {
                $iframe.unbind("load");
                $document.trigger("ajaxStop");

                if (iframe.src == "javascript:'%3Chtml%3E%3C/html%3E';" || // For
                    // Safari
                    iframe.src == "javascript:'<html></html>';") { // For FF, IE
                    return;
                }

                var doc = iframe.contentDocument || iframe.document;

                // fixing Opera 9.26,10.00
                if (doc.readyState && doc.readyState != 'complete')
                    return;
                // fixing Opera 9.64
                if (doc.body && doc.body.innerHTML == "false")
                    return;

                var response;

                if (doc.XMLDocument) {
                    // response is a xml document Internet Explorer property
                    response = doc.XMLDocument;
                } else if (doc.body) {
                    try {
                        response = $iframe.contents().find("body").text();
                        response = jQuery.parseJSON(response);
                    } catch (e) { // response is html document or plain text
                        response = doc.body.innerHTML;
                    }
                } else {
                    // response is a xml document
                    response = doc;
                }

                callback(response);
            });
        }
    </script>
</head>
<body>

<form class="form-horizontal" action="${ctx}/merchant/addUserInfo"
      enctype="multipart/form-data" method="post" onsubmit="return iframeCallback(this, dialogAjaxDone)">

    <input type="file" name="image" class="required" accept="image/gif, image/jpeg, image.png">
    <input type="submit" 提交>
    </form>




</body>
</html>

