
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<section>
    <div class="padding bck dark text bold">Create : New Record</div>
    <div class="padding bck light">
        <s:form action="CreateSave" >
            <s:select name="gardenModel.id" list="gardenList" listKey="id" listValue="name" label="Garden" />
            <s:select name="vegetableModel.id" list="vegetableList" listKey="id" listValue="name" label="Vegetable" />
            <s:submit value="Save"  cssClass="button icon save" />
            <s:hidden name="id" />
        </s:form>
    </div>
</section>
