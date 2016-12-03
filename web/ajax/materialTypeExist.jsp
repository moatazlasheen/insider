<%@page import="jpa.MaterialTypeJpaController" %>

<%
    MaterialTypeJpaController controller = new MaterialTypeJpaController();
    out.println(controller.materialTypeExists(request.getParameter("materialTypeDesc")));
%>