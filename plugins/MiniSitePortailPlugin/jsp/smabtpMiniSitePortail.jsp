<%@ include file='/jcore/doInitPage.jspf'%>
<%@ include file='/jcore/portal/doPortletParams.jspf'%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
  PortalJspCollection box = (PortalJspCollection) portlet;
  ServletUtil.backupAttribute(pageContext, "ShowChildPortalElement");
%>
<%@ include file='/types/AbstractCollection/doIncludePortletCollection.jspf'%>
<%
  ServletUtil.restoreAttribute(pageContext , "ShowChildPortalElement");
%>

<div class="container-fluid">
       <%= getPortlet(bufferMap,"header") %>
    
</div>