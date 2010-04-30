<%-- 
    Document   : navigation
    Created on : 6.1.2010, 19:21:27
    Author     : Tomas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:subview id="navigation">

    <jsp:include page="login.jsp" />

    <h:form>
        <rich:panel>
            <f:facet name="header">
                <h:outputText value="#{navigation.title}" />
            </f:facet>
            <ul>
                <li>
                    <a4j:commandLink action="home" value="#{navigation.home}" />
                </li>
                <li>
                    <a4j:commandLink action="basket" value="#{navigation.basket}" />
                </li>
                <li>
                    <a4j:commandLink action="orders" value="#{navigation.orders}" />
                </li>
                <li>
                    <a4j:commandLink action="wishlist" value="#{navigation.wishlist}" />
                </li>
            </ul>
        </rich:panel>
    </h:form>
</f:subview>
