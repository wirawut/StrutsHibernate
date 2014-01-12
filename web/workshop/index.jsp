
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>โปรแกรมปลูกผัก</title>
        <link rel="stylesheet" href="../css/tuktuk.css"/>
        <link rel="stylesheet" href="../css/tuktuk.icons.css"/>
        <link rel="stylesheet" href="../css/tuktuk.theme.css" />
    </head>
    <body data-tuktuk="boxes">
        <aside class="bck dark column_3 padding">
            <h3><strong class="icon home"> Main Menu</strong></h3>
            <nav data-tuktuk="menu" class="text bold">
                <a href="CreateIndex" class="icon plus-sign"> Create</a>
                <a href="IncomeIndex" class="icon bar-chart"> Income</a>
                <a href="PaymentIndex" class="icon external-link"> Payment</a>
            </nav><br/>
            
            <h3><strong class="icon list-alt"> Report</strong></h3>
            <nav data-tuktuk="menu" class="text bold">
                <a href="ReportIncomeIndex" class="icon credit-card"> Income</a>
                <a href="ReportPaymentIndex" class="icon exchange"> Payment</a>
            </nav><br/>
            
            <h3><strong class="icon wrench"> Configuration</strong></h3>
            <nav data-tuktuk="menu" class="text bold">
                <a href="gardenIndex" class="icon folder-close-alt"> Garden</a>
                <a href="VegetableIndex" class="icon gift"> Vegetable</a>
            </nav>
        </aside>
        <section>
            <header class="bck theme padding">
                <h3> i-Vegetable 1.0</h3>
            </header>
            <article class="padding">
                <s:if test="url!= null">
                    <jsp:include page="${url}" />
                </s:if>
            </article>
        </section>
    </body>
</html>
