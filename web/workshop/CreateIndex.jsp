
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<section>
    <div class="padding bck dark text bold">Create</div>
    <div class="padding bck light">
        <a class="button icon file" href="CreateForm"> New Record</a>
        <table>
            <thead>
                <tr>
                    <th width="200px" >garden</th>
                    <th width="200px" >vegetable</th>
                    <th>created date</th>
                    <th>get date</th>
                    <th>status</th>
                    <th width="280px" >action</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="createList" var="createRow" >
                    <tr>
                        <td>${createRow.gardenModel.name}</td>
                        <td>${createRow.vegetableModel.name}</td>
                        <td>${createRow.create_date}</td>
                        <td>${createRow.get_date}</td>
                        <td>${createRow.status}</td>
                        <td style="text-align: center">
                            <a class="button icon sign" href="CreateKeep?id=${createRow.id}"> Keep</a>
                            <a class="button icon pencil" href="CreateEdit?id=${createRow.id}"> Edit</a>
                            <a class="button icon alert" href=CreateDelete?id=${createRow.id}"> Delete</a>
                        </td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
    </div>
</section>