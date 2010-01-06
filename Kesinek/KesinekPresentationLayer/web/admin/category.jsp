<%-- 
    Document   : category
    Created on : 17.12.2009, 22:25:26
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
            <title>Category Managment</title>
            <style>
                .col1 {
                    width:20%;
                }
                .col2 {
                    width:70%;
                }
                .col3 {
                    width:10%;
                    text-align:center;
                }
                .panel {
                }
            </style>
            <script type="text/javascript">
                function setCaretToEnd (e) {
                    var control = $((e.target ? e.target : e.srcElement).id);
                    if (control.createTextRange) {
                        var range = control.createTextRange();
                        range.collapse(false);
                        range.select();
                    }
                    else if (control.setSelectionRange) {
                        control.focus();
                        var length = control.value.length;
                        control.setSelectionRange(length, length);
                    }
                    control.selectionStart = control.selectionEnd = control.value.length;
                }

            </script>
        </head>
        <body>
            <rich:panel>
                <h:form id="categoryManagment">
                    <rich:panel id="top">
                        <f:facet name="header">
                            <h:outputText value="Category Managment" />
                        </f:facet>
                        <h:commandLink action="index" value="Kesinek Administration" />
                        <br />
                    </rich:panel>
                </h:form>

                <rich:spacer height="10" />
                <h:panelGrid id="pnl" style="width:100%">
                    <% if (pageContext.getRequest().getParameter("state") == null || pageContext.getRequest().getParameter("state").equals("new")) {%>
                    <h:form id="newCategory">
                        <rich:panel>
                            <f:facet name="header">
                                <h:outputText value="New Category" />
                            </f:facet>
                            <h:panelGrid columns="2" style="text-align:left">
                                <h:outputLabel for="categoryName" value="Name:" />
                                <h:inputText id="categoryName" value="#{categoryBean.category.name}" required="true">
                                    <f:validator validatorId="categoryValidator" />
                                </h:inputText>
                                <h:outputLabel for="categoryDescription" value="Description:" />
                                <h:inputText id="categoryDescription" value="#{categoryBean.category.description}" required="true" />
                            </h:panelGrid>
                            <rich:spacer width="50"/>
                            <a4j:commandButton reRender="pnl,categoryList" action="#{categoryBean.newCategory}" value="Add New Category" />
                            <br />
                        </rich:panel>
                    </h:form>
                    <% } else {
     if (pageContext.getRequest().getParameter("state").equals("edit")) {%>
                    <h:form id="editCategory">
                        <rich:panel>
                            <f:facet name="header">
                                <h:outputText value="Edit Category" />
                            </f:facet>
                            <h:panelGrid columns="2" style="text-align:left">
                                <h:outputLabel for="categoryNameEdit" value="Name:" />
                                <h:inputText id="categoryNameEdit" value="#{categoryBean.category.name}" required="true">
                                    <f:validator validatorId="categoryValidator" />
                                </h:inputText>
                                <%--<h:message for="categoryNameEdit" style="color: red;" />--%>
                                <h:outputLabel for="categoryDescriptionEdit" value="Description:" />
                                <h:inputText id="categoryDescriptionEdit" value="#{categoryBean.category.description}" required="true" />
                                <%--<h:message for="categoryDescriptionEdit" style="color: red;" />--%>
                            </h:panelGrid>
                            <h:inputHidden id="categoryIDEdit" value="#{categoryBean.category.categoryID}" />
                            <rich:spacer width="50"/>
                            <a4j:commandButton reRender="categoryList,pnl" action="#{categoryBean.editCategory}" value="Edit Category">
                                <a4j:actionparam name="state" value="new" />
                            </a4j:commandButton>

                            <br />
                        </rich:panel>
                    </h:form>
                    <% }
            }%>
                </h:panelGrid>
                <rich:spacer height="10" />

                <h:form id="categoryList">
                    <rich:panel>
                        <f:facet name="header">
                            <h:outputText value="Category List" />
                        </f:facet>
                        <rich:dataTable id="table" value="#{categoryBean.allCategory}" var="cat" width="100%" rows="10" columnClasses="col1,col2,col3">
                            <f:facet name="header">
                                <rich:columnGroup>
                                    <h:column>Name</h:column>
                                    <h:column>Description</h:column>
                                    <h:column>Actions</h:column>
                                </rich:columnGroup>
                            </f:facet>
                            <rich:column filterMethod="#{categoryFilteringBean.filterNames}">
                                <f:facet name="header">
                                    <h:inputText value="#{categoryFilteringBean.filterNameValue}" id="input">
                                        <a4j:support event="onkeyup" reRender="table , ds"
                                                     ignoreDupResponses="true" requestDelay="700"
                                                     oncomplete="setCaretToEnd(event);"
                                                     />
                                    </h:inputText>
                                </f:facet>
                                <h:outputText value="#{cat.name}" />
                            </rich:column>
                            <rich:column filterMethod="#{categoryFilteringBean.filterDescriptions}">
                                <f:facet name="header">
                                    <h:inputText value="#{categoryFilteringBean.filterDescriptionValue}" id="input2">
                                        <a4j:support event="onkeyup" reRender="table , ds"
                                                     ignoreDupResponses="true" requestDelay="700"
                                                     oncomplete="setCaretToEnd(event);"
                                                     />
                                    </h:inputText>
                                </f:facet>
                                <h:outputText value="#{cat.description}" />
                            </rich:column>
                            <h:column>
                                <a4j:commandButton value="Edit" reRender="pnl" action="#{categoryBean.editCategorySetup}">
                                    <a4j:actionparam name="categoryID" value="#{cat.categoryID}" assignTo="#{categoryBean.id}" />
                                    <a4j:actionparam name="state" value="edit" />
                                    <a4j:actionparam name="editId" value="#{cat.categoryID}" />
                                </a4j:commandButton>
                                <a4j:commandButton reRender="categoryList" value="Delete" action="#{categoryBean.deleteCategory}">
                                    <a4j:actionparam name="categoryID" value="#{cat.categoryID}" assignTo="#{categoryBean.id}" />
                                </a4j:commandButton>
                            </h:column>
                            <f:facet name="footer">
                                <rich:datascroller id="ds" renderIfSinglePage="false"></rich:datascroller>
                            </f:facet>
                        </rich:dataTable>
                        <rich:panel id="msg">
                            <h:messages errorStyle="color:red" infoStyle="color:green"></h:messages>
                        </rich:panel>
                    </rich:panel>
                </h:form>
            </rich:panel>
        </body>
    </html>
</f:view>