<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<table border="1">
    <thead>
        <tr>
            <th>name</th>
            <th>author</th>
            <th>page</th>
            <th>price</th>
        </tr>
    </thead>
    <tbody>
        <s:iterator var="book" value="bookList">
            <tr>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.page}</td>
                <td>${book.price}</td>
            </tr>
        </s:iterator>
    </tbody>
</table>
