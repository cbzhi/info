<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>用户信息管理系统</title>
<%@ include file="/common/head.jspf"%>
<script>
	$(function(){
		document.ondblclick=function(){
			$(".layout_left_menu").toggle();
			if(flag == 1) {
				$("#flow-right").css("margin-left",20+"px");
				$("#layout_right_content").css("margin-left",30+"px");
				flag = 0 ;		
			} else if(flag == 0){
				$("#flow-right").css("margin-left",width+20+"px");
				$("#layout_right_content").css("margin-left",width+30+"px");
				flag = 1 ;
			}
		};
	});
</script>
</head>
<body>
<%-- 	<%@ include file="/common/top.jsp"%> --%>
	<%@ include file="/common/left.jspf"%>
	<%@ include file="/common/right.jspf"%>
<%-- 	<%@ include file="/common/foot.jspf"%> --%>

</body>
</html>