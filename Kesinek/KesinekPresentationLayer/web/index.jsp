<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!-- RichFaces tag library declaration -->

<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title></title>
        </head>
        <body>
            <jsp:include page="navigation.jsp" />

            <h:form>
                <rich:panel>
                    <f:facet name="header">
                        <h:outputText value="#{home.categories}" />
                    </f:facet>
                    <rich:dataList var="cat" value="#{CategoryBean.categoryDataModel}">
                        <rich:panelMenu>
                            <strong>
                                <a4j:commandLink value="#{cat.name}" action="#{CategoryBean.showCategory}">
                                    <f:param name="categoryID" value="#{cat.categoryID}" />
                                </a4j:commandLink>
                            </strong>
                            <p>
                                <h:outputText value="#{cat.description}" />
                            </p>
                        </rich:panelMenu>
                    </rich:dataList>
                </rich:panel>
            </h:form>

            <h:form>
                <rich:panel>
                    <f:facet name="header">
                        <h:outputText value="#{home.products}" />
                    </f:facet>
                    <rich:dataGrid var="product" value="#{CategoryBean.productDataModel}" columns="3" elements="9">
                        <rich:panel bodyClass="pbody">
                            <f:facet name="header">
                                <h:outputText value="#{product.name}"></h:outputText>
                            </f:facet>
                            <h:panelGrid columns="2">
                                <h:commandLink value="#{product.name}" action="#{CategoryBean.showProduct}">
                                    <f:param name="productID" value="#{product.productItemID}" />
                                </h:commandLink>
                                <h:outputText value="#{product.price}"></h:outputText>
                                <h:commandLink value="Add to wishlist" action="#{ProductBean.addToWishlist}">
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
                </rich:panel>
            </h:form>
        </body>
    </html>
</f:view>
