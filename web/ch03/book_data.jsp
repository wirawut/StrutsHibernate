<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<table>
    <thead>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>author</th>
            <th>price</th>
            <th>page</th>
        </tr>
    </thead>
    <tbody>
        <s:iterator value="bookList" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.price}</td>
                <td>${book.page}</td>
            </tr>
        </s:iterator>
    </tbody>
</table>