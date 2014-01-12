<%@taglib prefix="s" uri="/struts-tags" %>

<section>
    <div class="padding bck dark text bold">Report Pay</div>
    <div class="padding bck light">
        <s:form>
            <s:textfield name="year" label="Year" />
            <s:textfield name="month" label="Month" />
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
                <s:iterator value="payList" var="rowPay">
                    <tr>
                        <td>${rowPay.created_date}</td>
                        <td>${rowPay.name}</td>
                        <td style="text-align: right">${rowPay.money}</td>
                    </tr>
                </s:iterator>
            </tbody>
            <tfoot>
                <tr>
                    <td>Total</td>
                    <td style="text-align: rigth" colspan="2">
                        <s:property name="total" />
                    </td>
                </tr>
            </tfoot>
        </table>
    </div>
</section>
