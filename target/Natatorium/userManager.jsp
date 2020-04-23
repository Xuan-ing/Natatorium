<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>查看所有会员信息</title>
</head>
<body>
<table>
    <caption>会员管理</caption>


    <s:iterator value="#session.vipUserList" var="user">
        <tr>
            id:<td><s:textfield disabled="true" value="%{#user.id}"/></td>
            姓名:<td><s:textfield id="user_name" value="%{#user.name}" name="vipUser.name"/></td>
            电话:<td><s:textfield  disabled="true" value="%{#user.tel}" name="vipUser.no"/></td>
            身份证号码:<td><s:textfield id="user_no" value="%{#user.no}" /></td>
            <td>
                <a href="adminEditorPersonInfo.action?id=<s:property value="#user.id"/>&name=TongHao&no=123">更新</a>
            </td>
        </tr>
    </s:iterator>

</table>
<br />

<label><a href="<s:url action="selectAllCard"/>">管理所有储存卡</a> </label>
<label><a href="<s:url action="adminLogout"/>">退出登录</a> </label>

</body>
</html>
