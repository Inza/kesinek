<%-- 
    Document   : warehouse
    Created on : 07.01.2010, 0:50:14
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
                <h:form id="warehouseManagment">
                    <rich:panel id="top">
                        <f:facet name="header">
                            <h:outputText value="Warehouse Managment" />
                        </f:facet>
                        <h:commandLink action="index" value="Kesinek Administration" />
                        <br />
                    </rich:panel>
                </h:form>

                <rich:spacer height="10" />
                <h:panelGrid id="pnl" style="width:100%">
                    <% if (request.getParameter("state") == null || request.getParameter("state").equals("new")) {%>
                    <h:form id="newWarehouse">
                        <rich:panel>
                            <f:facet name="header">
                                <h:outputText value="New Warehouse" />
                            </f:facet>
                            <h:panelGrid columns="2" style="text-align:left">
                                <h:outputLabel for="warehouseDescription" value="Description:" />
                                <h:inputText id="warehouseDescription" value="#{warehouseBean.warehouse.description}" required="true" />
                            </h:panelGrid>
                            <rich:spacer width="50"/>
                            <a4j:commandButton reRender="pnl,warehouseList" action="#{warehouseBean.newWarehouse}" value="Add New Warehouse" />
                            <br />
                        </rich:panel>
                    </h:form>
                    <% } else {
     if (request.getParameter("state").equals("edit")) {%>
                    <h:form id="editWarehouse">
                        <rich:panel>
                            <f:facet name="header">
                                <h:outputText value="Edit Warehouse" />
                            </f:facet>
                            <h:panelGrid columns="2" style="text-align:left">
                                <h:outputLabel for="warehouseDescriptionEdit" value="Description:" />
                                <h:inputText id="warehouseDescriptionEdit" value="#{warehouseBean.warehouse.description}" required="true" />
                            </h:panelGrid>
                            <h:inputHidden id="warehouseIDEdit" value="#{warehouseBean.warehouse.warehouseID}" />
                            <rich:spacer width="50"/>
                            <a4j:commandButton reRender="warehouseList,pnl" action="#{warehouseBean.editWarehouse}" value="Edit Warehouse">
                                <a4j:actionparam name="state" value="new" />
                            </a4j:commandButton>

                            <br />
                        </rich:panel>
                    </h:form>
                    <% }
            }%>
                </h:panelGrid>
                <rich:spacer height="10" />

                <h:form id="warehouseList">
                    <rich:panel>
                        <f:facet name="header">
                            <h:outputText value="Warehouse List" />
                        </f:facet>
                        <rich:dataTable id="table" value="#{warehouseBean.allWarehouse}" var="war" width="100%" rows="10" columnClasses="col2,col3">
                            <f:facet name="header">
                                <rich:columnGroup>
                                    <h:column>Description</h:column>
                                    <h:column>Actions</h:column>
                                </rich:columnGroup>
                            </f:facet>
                                <rich:column filterMethod="#{warehouseFilteringBean.filterDescriptions}">
                                <f:facet name="header">
                                    <h:inputText value="#{warehouseFilteringBean.filterDescriptionValue}" id="input2">
                                        <a4j:support event="onkeyup" reRender="table , ds"
                                                     ignoreDupResponses="true" requestDelay="700"
                                                     oncomplete="setCaretToEnd(event);"
                                                     />
                                    </h:inputText>
                                </f:facet>
                                <h:outputText value="#{war.description}" />
                            </rich:column>
                            <h:column>
                                <a4j:commandButton value="Edit" reRender="pnl" action="#{warehouseBean.editWarehouseSetup}">
                                    <a4j:actionparam name="warehouseID" value="#{war.warehouseID}" assignTo="#{warehouseBean.id}" />
                                    <a4j:actionparam name="state" value="edit" />
                                    <a4j:actionparam name="editId" value="#{war.warehouseID}" />
                                </a4j:commandButton>
                                <a4j:commandButton reRender="warehouseList" value="Delete" action="#{warehouseBean.deleteWarehouse}">
                                    <a4j:actionparam name="warehouseID" value="#{war.warehouseID}" assignTo="#{warehouseBean.id}" />
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