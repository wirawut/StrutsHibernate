
<%@taglib prefix="s" uri="/struts-tags" %>
<section>
    <div class="padding bck dark text bold">Pay</div>
    <div class="padding bck light">
        <s:form action="PaySave">
            <s:textfield name="payModel.name" label="Name" />
            <s:textfield name="payModel.money" label="Price" />
            <s:submit cssClass="button" value="Save" />
            <s:hidden name="id"/>
        </s:form>
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th width="100px">Price</th>
                    <th width="200px">action</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="payList" var="payRow">
                    <tr>
                        <td>${payRow.name}</td>
                        <td style="text-align: right">${payRow.money}</td>
                        <td style="text-align: center">
                            <a href="PayEdit?id=${payRow.id}" class="button icon edit"> Edit</a>
                            <a href="PayDelete?id=${payRow.id}" class="button icon edit"> Delete</a>
                        </td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
    </div>
</section>