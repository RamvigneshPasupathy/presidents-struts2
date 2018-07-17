<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Presidents - Home</title>
<style>
.button {
	width: 100%;
	padding: 5px;
	background-color: #f0f0f0;
}

.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}

.capitalCase {
	text-transform: capitalize;
}
</style>
</head>
<body>
	<h1>President Form</h1>

	<s:form action="addcountry.action" method="post">
		<s:textfield label="Country" name="country.name" required="true" />
		<s:textfield label="President" name="country.president" required="true" />
		<s:submit cssClass="button" value="Add Country" />
	</s:form>
	<h2>Presidents List</h2>
	<div style="margin-top: 40px;">
		<s:if test="noData==true">
			<table class="tg">
				<thead>
					<tr style="background-color: #E0E0E1;">
						<th>Country ID</th>
						<th>Country Name</th>
						<th>President Name</th>
						<th>Update</th>
						<th>Delete</th>
					</tr>
				</thead>
				<s:iterator value="countryList">
					<tr>
						<td><s:property value="id" /></td>
						<td class="capitalCase"><s:property value="name" /></td>
						<td class="capitalCase"><s:property value="president" /></td>
						<td>
							<a href="setupedit.action?name=<s:property value="name"/>">
								Update
							</a>
						</td>
						<td>
							<a href="deletecountry.action?name=<s:property value="name"/>">
								Delete
							</a>
						</td>
					</tr>
				</s:iterator>
			</table>
		</s:if>
		<s:else>
			<div style="color: red;">No Data Found.</div>
		</s:else>
	</div>
</body>
</html>