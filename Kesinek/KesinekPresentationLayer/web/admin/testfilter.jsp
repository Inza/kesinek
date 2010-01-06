<%-- 
    Document   : testfilter
    Created on : 19.12.2009, 21:23:19
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
            <title>JSP Page</title>
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
            <h:form>
                <rich:dataTable value="#{manufacturerBean.allManufacturer}" var="man" rows="20" reRender="ds" id="table">
                    <f:facet name="header">
                        <rich:columnGroup>
                            <rich:column colspan="2" >
                                <h:outputText value="Filtering Example"/>
                            </rich:column>
                            <rich:column breakBefore="true">
                                <h:outputText value="Manufacturer Name"/>
                            </rich:column>
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
                    <f:facet name="footer">
                        <rich:datascroller id="ds" renderIfSinglePage="false"></rich:datascroller>
                    </f:facet>
                </rich:dataTable>
                <a4j:commandButton action="#{manufacturerBean.resetFilter}" value="Reset Current Filtering" reRender="simpletable" ajaxSingle="true" limitToList="true"/>
            </h:form>
        </body>
    </html>
</f:view>