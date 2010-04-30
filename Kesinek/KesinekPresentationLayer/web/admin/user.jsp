<%-- 
    Document   : user
    Created on : 07.01.2010, 9:04:01
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
            <title>User Managment</title>
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
                <h:form id="userManagment">
                    <rich:panel id="top">
                        <f:facet name="header">
                            <h:outputText value="User Managment" />
                        </f:facet>
                        <h:commandLink action="index" value="Kesinek Administration" />
                        <br />
                    </rich:panel>
                </h:form>

                <rich:spacer height="10" />
                <h:panelGrid id="pnl" style="width:100%">
                    <% //if (request.getParameter("state") == null || request.getParameter("state").equals("new")) {%>
                    <%--                    <h:form id="newUser">
                                            <rich:panel>
                                                <f:facet name="header">
                                                    <h:outputText value="New User" />
                                                </f:facet>
                                                <h:panelGrid columns="2" style="text-align:left">
                                                    <h:outputLabel for="userUsername" value="Username:" />
                                                    <h:inputText id="userUsername" value="#{userBean.user.username}" required="true"/>
                                                    <h:outputLabel for="userPassword" value="Password:" />
                                                    <h:inputSecret id="userPassowrd" value="#{userBean.user.password}" required="true" />
                                                    <h:outputLabel for="userAddress" value="Address:" />
                                                    <h:inputText id="userAddress" value="#{userBean.user.address}" required="true" />
                                                </h:panelGrid>
                                                <rich:spacer width="50"/>
                                                <a4j:commandButton reRender="pnl,userList" action="#{userBean.newUser}" value="Add New User" />
                                                <br />
                                            </rich:panel>
                                        </h:form>--%>
                    <%// } else {
            //if (request.getParameter("state").equals("edit")) {%>
                    <h:form id="editUser">
                        <rich:panel>
                            <f:facet name="header">
                                <h:outputText value="Edit User" />
                            </f:facet>
                            <h:panelGrid columns="2" style="text-align:left">
                                <h:outputLabel for="userUsernameEdit" value="Username:" />
                                <h:inputText id="userNameEdit" value="#{userBean.user.username}" required="true"/>
                                <h:outputLabel for="userPasswordEdit" value="Password:" />
                                <h:inputSecret id="userPasswordEdit" value="#{userBean.user.password}" required="true" />
                                <h:outputLabel for="userAddressEdit" value="Address:" />
                                <h:inputText id="userAddressEdit" value="#{userBean.user.address}" required="true"/>
                                <h:outputLabel for="categoryAttributeCategory" value="Role:" />
                                <h:selectOneMenu id="categoryAttributeCategory" value="#{userBean.roleid}">
                                    <f:selectItems value="#{userBean.roles}" />
                                    <a4j:support event="onchange" reRender="table, ds" />
                                </h:selectOneMenu>
                            </h:panelGrid>
                            <h:inputHidden id="userIDEdit" value="#{userBean.user.userID}" />
                            <rich:spacer width="50"/>
                            <a4j:commandButton reRender="userList,pnl" action="#{userBean.editUser}" value="Edit User">
                                <a4j:actionparam name="state" value="new" />
                            </a4j:commandButton>
                            <br />
                        </rich:panel>
                    </h:form>
                    <% //}
            //    }%>
                </h:panelGrid>
                <rich:spacer height="10" />

                <h:form id="userList">
                    <rich:panel>
                        <f:facet name="header">
                            <h:outputText value="User List" />
                        </f:facet>
                        <rich:dataTable id="table" value="#{userBean.allUser}" var="usr" width="100%" rows="10" columnClasses="col1,col2,col3">
                            <f:facet name="header">
                                <rich:columnGroup>
                                    <h:column>Username</h:column>
                                    <h:column>Password</h:column>
                                    <h:column>Address</h:column>
                                    <h:column>Role</h:column>
                                    <h:column>Actions</h:column>
                                </rich:columnGroup>
                            </f:facet>
                            <rich:column>
                                <%--<f:facet name="header">
                                    <h:inputText value="#{userFilteringBean.filterNameValue}" id="input">
                                        <a4j:support event="onkeyup" reRender="table , ds"
                                                     ignoreDupResponses="true" requestDelay="700"
                                                     oncomplete="setCaretToEnd(event);"
                                                     />
                                    </h:inputText>
                                </f:facet>--%>
                                <h:outputText value="#{usr.username}" />
                            </rich:column>
                            <rich:column>
                                <%--<f:facet name="header">
                                    <h:inputText value="#{userFilteringBean.filterDescriptionValue}" id="input2">
                                        <a4j:support event="onkeyup" reRender="table , ds"
                                                     ignoreDupResponses="true" requestDelay="700"
                                                     oncomplete="setCaretToEnd(event);"
                                                     />
                                    </h:inputText>
                                </f:facet>--%>
                                <h:outputText value="#{usr.password}" />
                            </rich:column>
                            <rich:column>
                                <%--<f:facet name="header">
                                    <h:inputText value="#{userFilteringBean.filterDescriptionValue}" id="input2">
                                        <a4j:support event="onkeyup" reRender="table , ds"
                                                     ignoreDupResponses="true" requestDelay="700"
                                                     oncomplete="setCaretToEnd(event);"
                                                     />
                                    </h:inputText>
                                </f:facet>--%>
                                <h:outputText value="#{usr.address}" />
                            </rich:column>
                            <rich:column>
                                <h:outputText value="asd"/>
                            </rich:column>
                            <h:column>
                                <a4j:commandButton value="Edit" reRender="pnl" action="#{userBean.editUserSetup}">
                                    <a4j:actionparam name="userID" value="#{cat.userID}" assignTo="#{userBean.id}" />
                                    <a4j:actionparam name="state" value="edit" />
                                    <a4j:actionparam name="editId" value="#{cat.userID}" />
                                </a4j:commandButton>
                                <a4j:commandButton reRender="userList" value="Delete" action="#{userBean.deleteUser}">
                                    <a4j:actionparam name="userID" value="#{cat.userID}" assignTo="#{userBean.id}" />
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