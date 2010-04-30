<%-- 
    Document   : 404
    Created on : 17.12.2009, 21:41:21
    Author     : Tomas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c"uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Error</title>
        </head>
        <body>
            <c:url var="url" value="/login.jsf"/>
            <p><a href="${url}">Try again.</a></p>
        </body>
    </html>
</f:view>
