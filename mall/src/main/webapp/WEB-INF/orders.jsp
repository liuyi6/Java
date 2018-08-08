<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<%@ page isELIgnored="false" %>
		<meta charset="utf-8" />
		<title>orders center</title>
		<link rel="stylesheet"  href="user/css/userCenter.css" type="text/css" />
		<link rel="stylesheet"  href="user/css/comment.css" type="text/css" />
		<link rel="stylesheet" href="user/css/this.css" type="text/css" />
        <link rel="stylesheet" href="user/css/index.css" type="text/css"/>
	</head>
	<body>
    <%@include file="top.jsp"%>
	<div class="whitebg">
		<div class="normal top2">
			<div class="logo"><a href=""><img src="user/images/index/shop_red_64px.png"><h2>PARKnSHOP</h2><p>welcome to PARKnSHOP !</p></a></div>
			<div class="search">
			  <select id="select">
			    <option>ordersId</option>
			  </select>
			  <input type="text" name="productName" class="text" id="text" placeholder="Please enter the ordersId">
			  <input type="button" value="search" class="search_btn" id="serach" onclick="serach()">
			</div>
		</div>
	</div>
        <hr />
        <div class="center" id="center">
            <div class="center1" id="center1">
                <div class="func_list" id="func_list">
                    <ul id="function" class="function">
                        <li class="title">order center</li>
                        <li id="history" class="history">
                            <a class="fi current" id="his" href="queryorders?pageId=1&state=5" onclick="changecolor(this)"><h2>my history order</h2></a>
                            <ul id="list2" style="display:block">
                                <li>
                                    <a href="queryDateOrders?pageId=1&day=30" onclick="change_bg1(this)"><h3>monthly</h3></a>
                                </li>
                                <li>
                                    <a href="queryDateOrders?pageId=1&day=7" onclick="change_bg1(this)"><h3>weekly</h3></a>
                                </li>
                                <li>
                                    <a href="queryDateOrders?pageId=1&day=1" onclick="change_bg1(this)"><h3>dayly</h3></a>
                                </li>
                            </ul>
                        </li>
                        <li id="paid">
                            <a class="fi" id="li2" href="queryorders?pageId=1&state=0" onclick="changecolor(this)"><h2>unpaid</h2></a>
                        </li>
                        <li id="delivered">
                            <a class="fi" id="li3" href="queryorders?pageId=1&state=1" onclick="changecolor(this)"><h2>to be delivered</h2></a>
                        </li>
                        <li id="received">
                            <a class="fi" id="li4" href="queryorders?pageId=1&state=2" onclick="changecolor(this)"><h2>to be received</h2></a>
                        </li>
                        <li id="evaluated">
                            <a class="fi" id="li5" href="queryorders?pageId=1&state=3" onclick="changecolor(this)"><h2>To be evaluated</h2></a>
                        </li>
                    </ul>
                </div>
                <div class="content" id="content">
                    <div class="cententshow" id="cententshow">
                        <div class="page history" style="display:block;">
                            <table class="order-list-table header">
                                    <tr>
                                        <th class="cell cell-img">goods</th>
                                        <th class="cell cell-info">&nbsp;</th>
                                        <th class="cell cell-price">price</th>
                                        <th class="cell cell-number">quantity</th>
                                        <th class="cell cell-total">total</th>
                                        <th class="cell cell-state">state</th>
                                        <th class="cell cell-operation">operation</th>
                                        <th class="cell cell-return">After-sale</th>
                                    </tr>
                              </table>
                              <c:forEach items="${list}" var="item">
                              <table class="order-list-table order-item">
                                    <tr>
                                        <td colspan="8" class="order-info">
                                            <span class="order-text"><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd" /></span>
                                            <span class="order-text">orderID：${item.ordersId}</span>
                                            <span class="order-text">shop:${item.shop.shopName}</span>
                                            <a class="link order-detail" href=""></a>
                                        </td>
                                    </tr>
                                    <tr class="ordercell">
                                        <td class="cell cell-img">
                                            <a href="" target="_blank"><div class="show"><img src="${item.product.imgAddr}" class="img1"/></div></a>
                                        </td>
                                        <td class="cell cell-info">
                                            <a class="link" href="" target="_blank" style="color: #333333;">${item.product.productName}</a>
                                        </td>
                                        <td class="cell cell-price">￥${item.product.productPrice}</td>
                                        <td class="cell cell-number">${item.ordersDetail.amount}</td>
                                        <td class="cell cell-total">￥${item.product.productPrice*item.ordersDetail.amount}</td>
                                        <c:choose>
                                    	<c:when test="${item.ordersDetail.enableStatus == 0}">
                                    		<td class="cell cell-state"><a class="link" href="" target="_blank" style="color: #333333;">unpay</a></td>
                                    		<td class="cell cell-operation"><a href="#" class="btn btn-change">pay</a></td>
                                    	</c:when>
                                    	<c:when test="${item.ordersDetail.enableStatus == 1}">
                                    		<td class="cell cell-state"><a class="link" href="" target="_blank" style="color: #333333;">undeliver</a></td>
                                    		<td class="cell cell-operation"><a href="#" class="btn btn-change">expediting</a></td>
                                    	</c:when>
                                    	<c:when test="${item.ordersDetail.enableStatus == 2}">
                                    		<td class="cell cell-state"><a class="link" href="" target="_blank" style="color: #333333;">unreceive</a></td>
                                    		<td class="cell cell-operation"><a href="#" class="btn btn-change">receive</a></td>
                                    	</c:when>
                                    	<c:when test="${item.ordersDetail.enableStatus == 3}">
                                    		<td class="cell cell-state"><a class="link" href="" target="_blank" style="color: #333333;">unevalute</a></td>
                                    		<td class="cell cell-operation">
                                        		<a class="btn btn-change"  onClick="document.getElementById('light').style.display='block'">confirm</a>
                                        	</td>
                                        	<!-- 评论 -->
                                        <div id="light" class="white_content">
  										<a href = "javascript:void(0)" style="color:red;line-height:20px;margin-left:5px;"onclick = "document.getElementById('light').style.display='none'">close</a>
											<div style="width:100%;height:400px;">
												<form action="addcomment"  method="post">
													<div style="height:80px;width:100%;text-align:center;font-size:20px;line-height:80px;">product comment</div>
													<div style="height:320px;width:96%;margin-left:1%;">
													<input type="hidden" name="ordersid" value="${item.ordersDetail.orderDetailId}">
													<textarea style="height:220px;width:100%;text-indent:10px;line-height:25px;border:1px solid black;" name="content"></textarea>
													<input style="height:35px;font-size:17px;width:300px;margin-left:150px;margin-top:20px;background-color:#1979CA;border:1px solid #1979CA;cursor:pointer;"type="submit" value="submit"></input>
													</div>
												</form>
											</div>
  									</div>
                                    	</c:when>
                                    	<c:otherwise>
                                    		<td class="cell cell-state"><a class="link" href="" target="_blank" style="color: #333333;">fnished</a></td>
                                    		<td class="cell cell-operation">
                                            <a href="#"><div class="delete"><img src="user/images/delect.JPG" class="img2"/></div></a>
                                        </td>
                                    	</c:otherwise>
                                    </c:choose>
                                    
                                    <c:choose>
                                    	<c:when test="${item.ordersDetail.returnStatus == 1}">
                                    		<td class="cell cell-return">appliedRefund</td>
                                    	</c:when>
                                    	<c:when test="${item.ordersDetail.returnStatus == 2}">
                                    		<td class="cell cell-return">refundSuccess</td>
                                    	</c:when>
                                    	<c:when test="${item.ordersDetail.returnStatus == -1}">
                                    		<td class="cell cell-return">refundFail</td>
                                    	</c:when>
                                    	<c:otherwise>
                                    		<td class="cell cell-return"><a href="#" class="btn btn-change" onClick="document.getElementById('reason').style.display='block'">applayRefund<s/a></td>
  									<!-- 申请退款 -->
  									<div id="reason" class="white_content">
  										<a href = "javascript:void(0)" style="color:red;line-height:20px;margin-left:5px;"onclick = "document.getElementById('reason').style.display='none'">close</a>
											<div style="width:100%;height:400px;">
												<form action="applayReturn"  method="post">
													<div style="height:80px;width:100%;text-align:center;font-size:20px;line-height:80px;">applay refund reason</div>
													<div style="height:320px;width:96%;margin-left:1%;">
													<input type="hidden" name="id" value="${item.ordersDetail.orderDetailId}">
													<textarea style="height:220px;width:100%;text-indent:10px;line-height:25px;border:1px solid black;" name="reason"></textarea>
													<input style="height:35px;font-size:17px;width:300px;margin-left:150px;margin-top:20px;background-color:#1979CA;border:1px solid #1979CA;cursor:pointer;"type="submit" value="submit"></input>
													</div>
												</form>
											</div>
  									</div>
                                    	</c:otherwise>
                                    </c:choose>
                                    </tr>
                                </table>
                                </c:forEach>
                                <%@include file="page.jsp"%>
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
