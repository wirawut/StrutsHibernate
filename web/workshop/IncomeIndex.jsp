<%@taglib prefix="s" uri="/struts-tags" %>
<section>
    <div class="padding bck dark text bold">Income</div>
    <div class="padding bck light">
        <s:form action="IncomeSave">
            <s:textfield name="incomeModel.name" label="Name" />
            <s:textfield name="incomeModel.money" label="Price"/>
            <s:submit cssClass="button" value="Save" />
            <s:hidden name="id" />
        </s:form>
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th width="100px">Price</th>
                    <th width="150px">Date</th>
                    <th width="200px">action</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="incomeList" var="incomeRow">
                    <tr>
                        <td>${incomeRow.name}</td>
                        <td style="text-align:right">${incomeRow.money}</td>
                        <td style="text-align: center">${incomeRow.income_date}</td>
                        <td style="text-align: center">
                            <a href="IncomeEdit?id=${incomeRow.id}" class="button icon edit"> Edit</a>
                             <a href="IncomeDelete?id=${incomeRow.id}" class="button icon trash"> Delete</a>
                        </td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
    </div>
</section>
