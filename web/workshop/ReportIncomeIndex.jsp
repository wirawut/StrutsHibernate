<%@taglib prefix="s" uri="/struts-tags" %>

<section>
    <div class="padding bck dark text bold">Report Income</div>
    <div class="padding bck light">
        <s:form>
            <s:textfield name="year" label="year" />
            <s:textfield name="month" label="month" />
            <s:submit cssClass="button" value="Show Report" />
        </s:form>
        <table>
            <thead>
                <tr>
                    <th>date</th>
                    <th>name</th>
                    <th>money</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="incomeList" var="rowIncome">
                    <tr>
                        <td>${rowIncome.income_date}</td>
                        <td>${rowIncome.name}</td>
                        <td style="text-align: right">${rowIncome.money}</td>
                    </tr>
                </s:iterator>
            </tbody>
            <tfoot>
                <tr>
                    <td>Total</td>
                    <td style="text-align: rigth" colspan="2">
                        <s:textfield name="total" />
                    </td>
                </tr>
            </tfoot>
        </table>
    </div>
</section>
