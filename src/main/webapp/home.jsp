<%--
  Created by IntelliJ IDEA.
  User: 10313
  Date: 07/04/2020
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<frameset rows="98,*,5" frameborder="no">

    <frame src="navigation.jsp" name="topFrame" id="topFrame"/>

    <frameset cols="168,*"  frameborder="no">

        <frame src="left.jsp"id="leftFrame" />

        <frame src="main.jsp" id="mainFrame" scrolling="yes"/>

    </frameset>

    <frame src="down.jsp" name="bottomFrame"id="bottomFrame" />

</frameset>
