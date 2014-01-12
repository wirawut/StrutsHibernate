<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<table border="1">
    <thead>
        <tr>
            <th>name</th>
            <th>author</th>
            <th>page</th>
            <th>price</th>
            <th>edit</th>
            <th>delete</th>
        </tr>
    </thead>
    <tbody>
        <s:iterator var="book" value="bookList">
            <tr>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.page}</td>
                <td>${book.price}</td>
                <td><a href="book_delete?id=${book.id}">ลบ</a></td>
                <td><a href="book_edit?id=${book.id}">แก้ไข</a></td>
            </tr>
        </s:iterator>
    </tbody>
</table>
