<%-- 
    Document   : register
    Created on : 6.1.2010, 23:24:48
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
            <title>Kesinek - Register</title>
        </head>
        <body>
            <h:form>
                <rich:panel>
                    <f:facet name="header">
                        <h:outputText value="Registrace" />
                    </f:facet>

                    <h:messages errorStyle="color:red" infoStyle="color:green" />

                    <h:panelGrid columns="2">
                        <h:outputLabel for="username" value="Username:" />
                        <h:inputText id="username" value="#{UserBean.user.username}" required="true">
                            <f:validator validatorId="usernameValidator" />
                        </h:inputText>
                        <h:outputLabel for="password" value="Password:" />
                        <h:inputSecret id="password" value="#{UserBean.user.password}" required="true">
                            <f:validator validatorId="passwordValidator" />
                        </h:inputSecret>
                        <h:outputLabel for="address" value="Address:" />
                        <h:inputText id="address" value="#{UserBean.user.address}" />
                    </h:panelGrid>
                    <rich:spacer width="50"/>
                    <h:commandButton action="#{UserBean.register}" value="Registrovat" />
                </rich:panel>
            </h:form>
        </body>
    </html>
</f:view>
