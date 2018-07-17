<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Presidents - Edit</title>
<style>
.button {
	width: 100%;
	padding: 5px;
	background-color: #f0f0f0;
}
.errorMessage {
    color: red;
}
</style>
</head>
<body>
	<h2>President Update Form</h2>
	<s:form action="updatepresident.action" method="post">
		<s:textfield label="ID" name="country.id" />
		<s:textfield label="Country" name="country.name" />
		<s:textfield label="President" name="country.president" />
		<s:submit cssClass="button" value="Update President" />
	</s:form>
</body>
</html>