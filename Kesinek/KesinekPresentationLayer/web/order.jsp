<%--
    Document   : wishlist
    Created on : 6.1.2010, 19:22:17
    Author     : Tomas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Kesinek - Order</title>
        </head>
        <body>
            <jsp:include page="navigation.jsp" />
            <rich:panel>
                <f:facet name="header">
                    <h:outputText value="Order" />
                </f:facet>

                <h:outputText value="#{OrderBean.order.ostate}" />
            </rich:panel>
        </body>
    </html>
</f:view>
