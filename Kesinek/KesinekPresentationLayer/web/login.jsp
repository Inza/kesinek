<%-- 
    Document   : login
    Created on : 17.12.2009, 21:25:30
    Author     : Tomas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:subview id="login">
    <rich:panel>

        <h:messages errorStyle="color:red" infoStyle="color:green" />

        <% if (request.getUserPrincipal() == null) { %>
            <f:facet name="header">
                <h:outputText value="Přihlášení" />
            </f:facet>
            <table>
                <tr>
                    <td>
                        <form name="loginForm" action="j_security_check" method="POST">
                            <label for="j_username">Jméno</label> <input type="text" name="j_username" />
                            <label for="j_password">Heslo</label> <input type="password" name="j_password" />
                            <input type="submit" value="Login" class="fortomasbutton" />
                        </form>
                    </td>
                    <td>
                        <h:form>
                            <h:commandLink action="register" value="Registrace" />
                        </h:form>
                    </td>
                </tr>
            </table>
        <% } else { %>
            <f:facet name="header">
                <h:outputText value="Přihlášen" />
            </f:facet>
        <h:form>
            <table>
                <tr>
                    <td>
                        Přihlášen jako <strong>${pageContext.request.userPrincipal.name}</strong>.
                        <h:commandLink action="#{UserBean.logout}" value="Odhlásit se" />
                    </td>
                    <td>
                        <% if (request.isUserInRole("admin")) {%>
                        <h:commandLink action="admin" value="Administrace" />
                        <% }%>
                    </td>
                </tr>
            </table>
        </h:form>
        <% } %>
    </rich:panel>
</f:subview>