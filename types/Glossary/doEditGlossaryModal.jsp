<%-- This file has been automatically generated. --%>
<%--
  @Summary: Glossary modal content editor
  @Category: Generated
  @Author: JCMS Type Processor 
  @Customizable: True
  @Requestable: False 
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file='/jcore/doInitPage.jspf' %>
<% 
  EditGlossaryHandler formHandler = (EditGlossaryHandler)request.getAttribute("formHandler");
  ServletUtil.backupAttribute(pageContext, "classBeingProcessed");
  request.setAttribute("classBeingProcessed", generated.Glossary.class);
%>
<%-- Description ------------------------------------------------------------ --%>
<jalios:field name="description" formHandler="<%= formHandler %>">
  <jalios:control />
</jalios:field>
<jalios:include target="EDIT_PUB_MAINTAB" targetContext="div" />
<jalios:include jsp="/jcore/doEditExtraData.jsp" />
<% ServletUtil.restoreAttribute(pageContext , "classBeingProcessed"); %><%-- **********4A616C696F73204A434D53 *** SIGNATURE BOUNDARY * DO NOT EDIT ANYTHING BELOW THIS LINE *** --%><%
%><%-- wvj73KQPkDmKS0YKq1uqtg== --%>