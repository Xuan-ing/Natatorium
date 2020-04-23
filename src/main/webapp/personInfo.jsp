<%@ page import="entity.VipUser" %>
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>个人信息</title>
</head>
<body>
<%  VipUser vipUser = (VipUser) session.getAttribute("curVipUser");
    if (vipUser == null) {%>
<div style="text-align: center;">请先登录再使用本系统！</div>
<% } else {%>

<script>
    let btn = document.getElementById("btn");
    let flag = true;
    function editable() {
        if (flag) {
            flag = false;
            document.getElementById("name").disabled = false;
            document.getElementById("no").disabled = false;
        } else {
            flag = true;
            document.getElementById("name").disabled = true;
            document.getElementById("no").disabled = true;
        }
    }
    function hint()
    {
        alert("密码修改成功，请记住自己的新密码！");
    }
</script>

<s:form method="POST" action="updatePersonInfo">
   <s:iterator var="curUser" value="#session.curVipUser">
        电话号码：<s:textfield id="tel" name="tel" disabled="true" value="%{#curUser.tel}"/>
       <br/>
         姓名：<s:textfield id="name" name="name" disabled="true" value="%{#curUser.name}" />
        <br/>
        身份证号码：<s:textfield id="no" name="no" disabled="true" value="%{#curUser.no}"/>
        <br/>
    <input type="button" id="btn" onclick="editable()" value="编辑"/> &nbsp;
   </s:iterator>
    <s:submit value="提交"/>
</s:form>
<br/>
<br/>
<br/>
<s:form method="POST" action="updatePasswprd">
    <s:iterator var="curUser" value="#session.curVipUser">
        新密码：<s:password  name="password"/>
    </s:iterator>
    <s:submit value="修改密码" onclick="hint()"/>
</s:form>

<%}%>
</body>
</html>
