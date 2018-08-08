<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<%@ page isELIgnored="false" %>
		<meta charset="utf-8" />
		<title>personal center</title>
		<link rel="stylesheet"  href="user/css/userCenter.css" type="text/css" />
		<link rel="stylesheet"  href="user/css/comment.css" type="text/css" />
		<link rel="stylesheet" href="user/css/this.css" type="text/css" />
        <link rel="stylesheet" href="user/css/index.css" type="text/css"/>
        <script>
            function change_bg(obj) {
                var p = document.getElementById("cententshow").getElementsByClassName("page");
                var a = document.getElementById("function").getElementsByTagName("a");
                for(var i = 0;i < a.length;i++){
                    a[i].className="";
                    p[i].style.display = "none";
                    if(obj.id === a[i].id){
                        p[i].style.display = "block";
                    }
                }
                obj.className="current";
            }
        </script>
	</head>
	<body>
         <%@include file="top.jsp"%>
	<%@include file="top2.jsp"%>
        <hr />
        <div class="center" id="center">
            <div class="center1" id="center1">
                <div class="func_list" id="func_list">
                    <ul id="function" class="function">
                        <li class="title">personal center</li>
                        <li id="info">
                            <a id="1" href="#" onclick="change_bg(this)" class="current"><h2>information</h2></a>
                        </li>
                         <li id="history">
                            <a id="6" href="#" onclick="change_bg(this)"><h2>my applay</h2></a>
                        </li> 
                        <li id="collection">
                            <a id="7" href="#" onclick="change_bg(this)"><h2>my collection</h2></a>
                        </li>
                    </ul>
                </div>
                <div class="content" id="content">
                    <div class="cententshow" id="cententshow">
                        <div class="page info" style="display:block">
                            <h2>my informations</h2>
                            <hr />
                            <div class="userinfo" >
                                <div class="form_line">
                                    <span class="label">usernumber：</span>
                                    <span class="text1">${customer.userId }</span>
                                </div>
                                <div class="form_line">
                                    <span class="label">username：</span>
                                    <span class="text1">${customer.userName}</span>
                                </div>
                                <div class="form_line">
                                    <span class="label">mobilephone：</span>
                                    <span class="text1">${customer.phone}</span>
                                </div>
                                <div class="form_line">
                                    <span class="label">address：</span>
                                    <span class="text1">${customer.address}</span>
                                </div>
                                <div class="form_line">
                                    <span class="label">register time：</span>
                                    <span class="text1"><fmt:formatDate value="${customer.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></span>
                                </div>
                                <div class="form_line">
                                    <span class="label">modified time：</span>
                                    <span class="text1"><fmt:formatDate value="${customer.lastEditTime}" pattern="yyyy-MM-dd HH:mm:ss" /></span>
                                </div>
                                <a href="" class="btn btn-submit">Modify</a>
                            </div>
                        </div>
                       <!--  applay -->
                        <div class="page history" style="display:none;">
                            <table class="order-list-table header">
                                <tr>
                                    <th class="cell cell-img">userName</th>
                                    <th class="cell cell-info">ordersId</th>
                                    <th class="cell cell-number">collectTime</th>
                                    <th class="cell cell-total"><!-- total --></th>
                                    <th class="cell cell-state">applayState</th>
                                </tr>
                            </table>
                             <c:forEach items="${list2}" var="applay">
                            <table class="order-list-table order-item">
                                <tr>
                                    <td class="cell cell-img">
                                        <a href="" target="_blank">${customer.userName}</a>
                                    </td>
                                    <td class="cell cell-info">
                                        <a class="link" href="" target="_blank">${applay.orderDetailId}</a>
                                    </td>
                                    <td class="cell cell-number"><span class="text1"><fmt:formatDate value="${applay.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></span></td>
                                    <td class="cell cell-total"><!-- ￥totalPrice --></td>
                                    <c:choose>
                                    	<c:when test="${applay.returnStatus == 1}">
                                    		<td class="cell cell-state">appliedRefund</td>
                                    	</c:when>
                                    	<c:when test="${applay.returnStatus == 2}">
                                    		<td class="cell cell-state">refundSuccess</td>
                                    	</c:when>
                                    	<c:when test="${applay.returnStatus == -1}">
                                    		<td class="cell cell-state">refundFail</td>
                                    	</c:when>
                                    	<c:otherwise>
                                    		<td class="cell cell-state">userful</td>
                                    	</c:otherwise>
                                    </c:choose>
                                   <!--  <td class="cell cell-state">userful</td> -->
                                </tr>
                            </table>
                            </c:forEach>
                        </div>
                       <!-- 	 收藏店铺 -->
                        <div class="page collection" style="display:none">
                            <table class="order-list-table header">
                                <tr>
                                    <th class="cell cell-img">&nbsp;</th>
                                    <th class="cell cell-info">shopName</th>
                                    <th class="cell cell-number">collectTime</th>
                                    <th class="cell cell-total"><!-- total --></th>
                                    <th class="cell cell-state">shopState</th>
                                    <th class="cell cell-operation">operation</th>
                                </tr>
                            </table>
                             <c:forEach items="${collectList}" var="collect">
                            <table class="order-list-table order-item">
                                <tr>
                                    <td colspan="6" class="order-info">
                                        <span class="order-text"></span>
                                        <span class="order-text">userName:</span>
                                        <span class="order-text">${customer.userName}</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="cell cell-img">
                                        <a href="" target="_blank"></a>
                                    </td>
                                    <td class="cell cell-info">
                                        <a class="link" href="" target="_blank">${collect.shop.shopName}</a>
                                    </td>
                                    <td class="cell cell-number"><span class="text1"><fmt:formatDate value="${collect.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></span></td>
                                    <td class="cell cell-total"><!-- ￥totalPrice --></td>
                                    <td class="cell cell-state">userful</td>
                                    <td class="cell cell-operation">
                                        <a href="deleteCollect?collectId=${collect.collectId}" class="btn btn-change">remove</a>
                                    </td>
                                </tr>
                            </table>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <!-- 底部信息栏 -->
        <footer class="footer">
            <ul>
                <li>About Us</li>
                <li>Contact Us</li>
                <li>Terms of Service</li>
                <li>Privacy Agreement</li>
                <li>Help</li>
            </ul>
            <div class="companyName">
                <p>Group 3 of Project Management</p>
            </div>
        </footer>
        <!-- 底部信息栏结束 -->

	</body>
</html>
