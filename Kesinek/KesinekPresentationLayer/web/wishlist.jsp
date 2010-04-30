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
            <title>Kesinek - Wishlist</title>
        </head>
        <body>
            <jsp:include page="navigation.jsp" />
            <rich:panel>
                <f:facet name="header">
                    <h:outputText value="Wishlist" />
                </f:facet>

                <h:form>
                    <rich:dataGrid var="product" value="#{WishBean.productDataModel}" columns="3" elements="9">
                        <rich:panel bodyClass="pbody">
                            <f:facet name="header">
                                <h:outputText value="#{product.name}"></h:outputText>
                            </f:facet>
                            <h:panelGrid columns="2">
                                <h:commandLink value="#{product.name}" action="#{CategoryBean.showProduct}">
                                    <f:param name="productID" value="#{product.productItemID}" />
                                </h:commandLink>
                                <h:outputText value="#{product.price}"></h:outputText>
                                <h:commandLink value="Remove from wishlist" action="#{ProductBean.removeFromWishlist}">
                                    <f:param name="productID" value="#{product.productItemID}" />
                                </h:commandLink>
                                <h:commandLink value="Add to basket" action="#{ProductBean.addToBasket}">
                                    <f:param name="productID" value="#{product.productItemID}" />
                                </h:commandLink>
                            </h:panelGrid>
                        </rich:panel>
                        <f:facet name="footer">
                            <rich:datascroller></rich:datascroller>
                        </f:facet>
                    </rich:dataGrid>
                </h:form>
            </rich:panel>
        </body>
    </html>
</f:view>
