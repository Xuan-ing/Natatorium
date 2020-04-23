<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>管理所有卡</title>
</head>
<body>
<table>
    <caption>卡管理</caption>
    <tr>
        <th>卡号</th>
        <th>余额</th>
        <th>是否可用</th>
        <th>提交修改</th>


    </tr>

        <s:iterator value="#session.allPrepaidCard" var="card">
            <tr>
                <td><s:textfield disabled="true" value="%{#card.id}"/></td>
                <td><s:textfield disabled="true" value="%{#card.balance}"/></td>
                <td><s:textfield value="%{#card.availability}"/></td>
                <td>
                    <a href="adminEditorCardInfo.action?id=<s:property value="#card.id"/>&availability=false">更新</a>
                </td>
            </tr>
        </s:iterator>


</table>
<br />
<label><a href="<s:url action="adminLogout"/>">退出登录</a> </label>

</body>
</html>