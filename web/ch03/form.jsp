<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<s:form>
    <s:textfield name="book.name" label="Name" />
    <s:textfield name="book.author" label="Author"/>
    <s:textfield name="book.price" label="Price" />
    <s:textfield name="book.page" label="Page"/>
    <s:hidden name="id"/>
    <s:submit/>
</s:form>