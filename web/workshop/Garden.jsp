
<%@taglib  prefix="s" uri="/struts-tags" %>
<section>
    <div class="padding bck dark text bold">Garden</div>
    <div class="padding bck light">
        <s:form action="gardenSave">
            <s:textfield name="gardenModel.name" label="Name"/>
            <s:submit cssClass="button" value="Save"/>
            <s:hidden name="id" />
        </s:form>

        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th width="200px">action</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="gardenList" var="gardenRow">
                    <tr>
                        <td>${gardenRow.name}</td>
                        <td style="text-align: center">  
                            <a href="gardenEdit?id=${gardenRow.id}" class="button icon edit"> Edit</a>
                            <a href="gardenDelete?id=${gardenRow.id}" class="button icon trash"> Delete</a>
                        </td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
    </div>
</section>
