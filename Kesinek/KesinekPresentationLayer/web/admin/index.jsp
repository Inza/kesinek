<%-- 
    Document   : index
    Created on : 17.12.2009, 22:26:01
    Author     : Admin

--%>

<%@taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@taglib uri="http://richfaces.org/rich" prefix="rich"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Kesinek Administration</title>
        </head>
        <body>
            <h:form>
                <rich:panel>
                    <f:facet name="header">
                        <h:outputText value="Kesinek Administration" />
                    </f:facet>
                    <h:commandLink action="category" value="Category Managment" />
                    <br />
                    <h:commandLink action="manufacturer" value="Manufacturers Managment" />
                </rich:panel>
            </h:form>
        </body>
    </html>
</f:view>