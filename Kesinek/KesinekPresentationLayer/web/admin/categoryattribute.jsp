<%-- 
    Document   : categoryattribute
    Created on : 07.01.2010, 3:06:00
    Author     : Admin

--%>

<%@taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@taglib uri="http://richfaces.org/rich" prefix="rich"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
                    width:35%;
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
                <h:form id="categoryAttributeManagment">
                    <rich:panel id="top">
                        <f:facet name="header">
                            <h:outputText value="Category Attribute Managment" />
                        </f:facet>
                        <h:commandLink action="index" value="Kesinek Administration" />
                        <br />
                    </rich:panel>
                </h:form>

                <rich:spacer height="10" />
                <h:panelGrid id="pnl" style="width:100%">
                    <% if (request.getParameter("state") == null || request.getParameter("state").equals("new")) {%>
                    <h:form id="newCategoryAttribute">
                        <rich:panel>
                            <f:facet name="header">
                                <h:outputText value="New Category Attribute" />
                            </f:facet>
                            <h:panelGrid columns="2" style="text-align:left">
                                <h:outputLabel for="categoryAttributeName" value="Name:" />
                                <h:inputText id="categoryAttributeName" value="#{categoryAttributeBean.categoryAttribute.name}" required="true" />
                                <h:outputLabel for="categoryAttributeDescription" value="Description:" />
                                <h:inputText id="categoryAttributeDescription" value="#{categoryAttributeBean.categoryAttribute.description}" required="true" />
                                <h:outputLabel for="categoryAttributeCategory" value="Category:" />
                                <h:selectOneMenu id="categoryAttributeCategory" value="#{categoryAttributeBean.categoryid}">
                                    <f:selectItems value="#{categoryAttributeBean.categories}" />
                                    <a4j:support event="onchange" reRender="table, ds" />
                                </h:selectOneMenu>
                            </h:panelGrid>
                            <rich:spacer width="50"/>
                            <a4j:commandButton reRender="pnl,categoryAttributeList" action="#{categoryAttributeBean.newCategoryAttribute}" value="Add New Category Attribute" />
                            <br />
                        </rich:panel>
                    </h:form>
                    <% } else {
     if (request.getParameter("state").equals("edit")) {%>
                    <h:form id="editCategoryAttribute">
                        <rich:panel>
                            <f:facet name="header">
                                <h:outputText value="Edit Category Attribute" />
                            </f:facet>
                            <h:panelGrid columns="2" style="text-align:left">
                                <h:outputLabel for="categoryAttributeNameEdit" value="Name:" />
                                <h:inputText id="categoryAttributeNameEdit" value="#{categoryAttributeBean.categoryAttribute.name}" required="true" />
                                <h:outputLabel for="categoryAttributeDescriptionEdit" value="Description:" />
                                <h:inputText id="categoryAttributeDescriptionEdit" value="#{categoryAttributeBean.categoryAttribute.description}" required="true" />
                                <h:outputLabel for="categoryAttributeCategory" value="Category:" />
                                <h:selectOneMenu id="categoryAttributeCategory" value="#{categoryAttributeBean.categoryid}">
                                    <f:selectItems value="#{categoryAttributeBean.categories}" />
                                    <a4j:support event="onchange" reRender="table, ds" />
                                </h:selectOneMenu>
                            </h:panelGrid>
                            <h:inputHidden id="categoryAttributeIDEdit" value="#{categoryAttributeBean.categoryAttribute.categoryAttributeID}" />
                            <rich:spacer width="50"/>
                            <a4j:commandButton reRender="categoryAttributeList,pnl" action="#{categoryAttributeBean.editCategoryAttribute}" value="Edit Category Attribute">
                                <a4j:actionparam name="state" value="new" />
                            </a4j:commandButton>

                            <br />
                        </rich:panel>
                    </h:form>
                    <% }
            }%>
                </h:panelGrid>
                <rich:spacer height="10" />

                <h:form id="categoryAttributeList">
                    <rich:panel>
                        <f:facet name="header">
                            <h:outputText value="Category Attribute List" />
                        </f:facet>
                        <rich:dataTable id="table" value="#{categoryAttributeBean.allCategoryAttribute}" var="cat" width="100%" rows="10" columnClasses="col1,col2,col2,col3">
                            <f:facet name="header">
                                <rich:columnGroup>
                                    <h:column>Name</h:column>
                                    <h:column>Description</h:column>
                                    <h:column>Category</h:column>
                                    <h:column>Actions</h:column>
                                </rich:columnGroup>
                            </f:facet>
                            <rich:column filterMethod="#{categoryAttributeFilteringBean.filterNames}">
                                <f:facet name="header">
                                    <h:inputText value="#{categoryAttributeFilteringBean.filterNameValue}" id="input">
                                        <a4j:support event="onkeyup" reRender="table , ds"
                                                     ignoreDupResponses="true" requestDelay="700"
                                                     oncomplete="setCaretToEnd(event);"
                                                     />
                                    </h:inputText>
                                </f:facet>
                                <h:outputText value="#{cat.name}" />
                            </rich:column>
                            <rich:column filterMethod="#{categoryAttributeFilteringBean.filterDescriptions}">
                                <f:facet name="header">
                                    <h:inputText value="#{categoryAttributeFilteringBean.filterDescriptionValue}" id="input2">
                                        <a4j:support event="onkeyup" reRender="table , ds"
                                                     ignoreDupResponses="true" requestDelay="700"
                                                     oncomplete="setCaretToEnd(event);"
                                                     />
                                    </h:inputText>
                                </f:facet>
                                <h:outputText value="#{cat.description}" />
                            </rich:column>
                            <rich:column filterMethod="#{categoryAttributeFilteringBean.filterCategories}">
                                <f:facet name="header">
                                    <h:selectOneMenu value="#{categoryAttributeFilteringBean.filterCategoryValue}">
                                        <f:selectItems value="#{categoryAttributeFilteringBean.categories}" />
                                        <a4j:support event="onchange" reRender="table, ds" />
                                    </h:selectOneMenu>
                                </f:facet>
                                <h:outputText value="#{cat.categoryID.name}" />
                            </rich:column>
                            <h:column>
                                <a4j:commandButton value="Edit" reRender="pnl" action="#{categoryAttributeBean.editCategoryAttributeSetup}">
                                    <a4j:actionparam name="categoryAttributeID" value="#{cat.categoryAttributeID}" assignTo="#{categoryAttributeBean.id}" />
                                    <a4j:actionparam name="state" value="edit" />
                                    <a4j:actionparam name="editId" value="#{cat.categoryAttributeID}" />
                                </a4j:commandButton>
                                <a4j:commandButton reRender="categoryAttributeList" value="Delete" action="#{categoryAttributeBean.deleteCategoryAttribute}">
                                    <a4j:actionparam name="categoryAttributeID" value="#{cat.categoryAttributeID}" assignTo="#{categoryAttributeBean.id}" />
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