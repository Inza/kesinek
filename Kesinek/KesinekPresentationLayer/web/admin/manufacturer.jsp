<%-- 
    Document   : manufacturer
    Created on : 18.12.2009, 7:30:57
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
            <title>Manufacturers Managment</title>
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
                <h:form id="manufacturerManagment">
                    <rich:panel id="top">
                        <f:facet name="header">
                            <h:outputText value="Manufacturers Managment" />
                        </f:facet>
                        <h:commandLink action="index" value="Kesinek Administration" />
                        <br />
                    </rich:panel>
                </h:form>

                <rich:spacer height="10" />
                <h:panelGrid id="pnl" style="width:100%">
                    <% if (request.getParameter("state") == null || request.getParameter("state").equals("new")) {%>
                    <h:form id="newManufacturer">
                        <rich:panel>
                            <f:facet name="header">
                                <h:outputText value="New Manufacturer" />
                            </f:facet>
                            <h:panelGrid columns="2" style="text-align:left">
                                <h:outputLabel for="manufacturerName" value="Name:" />
                                <h:inputText id="manufacturerName" value="#{manufacturerBean.manufacturer.name}" required="true"></h:inputText>
                            </h:panelGrid>
                            <rich:spacer width="50"/>
                            <a4j:commandButton reRender="pnl,table,msg" action="#{manufacturerBean.newManufacturer}" value="Add New Manufacturer" />
                        </rich:panel>
                    </h:form>
                    <% } else {
                            if (request.getParameter("state").equals("edit")) {%>
                    <h:form id="editManufacturer">
                        <rich:panel>
                            <f:facet name="header">
                                <h:outputText value="Edit Manufacturer" />
                            </f:facet>
                            <h:panelGrid columns="2" style="text-align:left">
                                <h:outputLabel for="manufacturerNameEdit" value="Name:" />
                                <h:inputText id="manufacturerNameEdit" value="#{manufacturerBean.manufacturer.name}" required="true" />                            <%--<h:message for="manufacturerNameEdit" style="color: red;" />--%>
                            </h:panelGrid>
                            <h:inputHidden id="manufacturerIDEdit" value="#{manufacturerBean.manufacturer.manufacturerID}" />
                            <rich:spacer width="50"/>
                            <a4j:commandButton reRender="manufacturerList,pnl" action="#{manufacturerBean.editManufacturer}" value="Edit Manufacturer">
                                <a4j:actionparam name="state" value="new" />
                            </a4j:commandButton>
                        </rich:panel>
                    </h:form>
                    <% }
                }%>
                </h:panelGrid>
                <rich:spacer height="10" />

                <h:form id="manufacturerList">
                    <rich:panel>
                        <f:facet name="header">
                            <h:outputText value="Manufacturer List" />
                        </f:facet>
                        <rich:dataTable value="#{manufacturerBean.allManufacturer}" id="table" var="man" width="100%" rows="9" columnClasses="col2,col3">
                            <f:facet name="header">
                                <rich:columnGroup>
                                    <h:column>Name</h:column>
                                    <h:column>Actions</h:column>
                                </rich:columnGroup>
                            </f:facet>
                            <rich:column filterMethod="#{manufacturerFilteringBean.filterNames}">
                                <f:facet name="header">
                                    <h:inputText value="#{manufacturerFilteringBean.filterNameValue}" id="input">
                                        <a4j:support event="onkeyup" reRender="table , ds"
                                                     ignoreDupResponses="true" requestDelay="700"
                                                     oncomplete="setCaretToEnd(event);"
                                                     />
                                    </h:inputText>
                                </f:facet>
                                <h:outputText value="#{man.name}" />
                            </rich:column>
                            <h:column>
                                <a4j:commandButton value="Edit" reRender="pnl" action="#{manufacturerBean.editManufacturerSetup}">
                                    <a4j:actionparam name="manufacturerID" value="#{man.manufacturerID}" assignTo="#{manufacturerBean.id}" />
                                    <a4j:actionparam name="state" value="edit" />
                                    <a4j:actionparam name="editId" value="#{man.manufacturerID}" />
                                </a4j:commandButton>
                                <a4j:commandButton reRender="manufacturerList" value="Delete" action="#{manufacturerBean.deleteManufacturer}">
                                    <a4j:actionparam name="manufacturerID" value="#{man.manufacturerID}" assignTo="#{manufacturerBean.id}" />
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