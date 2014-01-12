<%@taglib prefix="s" uri="/struts-tags" %>
<section>
    <div class="padding bck dark text bold">Vegetable</div>
    <div class="padding bck light">
        <s:form action="vegetableSave">
            <s:textfield name="VegetableModel.name" label="Name" />
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
                <s:iterator value="vegetableList" var="vegetableRow">
                    <tr>
                        <td>${vegetableRow.name}</td>
                        <td style="text-align: center">
                            <a href="vegetableEdit?id=${vegetableRow.id}" class="button icon edit"> Edit</a>
                            <a href="vegetableDelete?id=${vegetableRow.id}" class="button alert icon trash"> Delete</a>
                        </td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
    </div>
</section>
