<%@ tag language="java" pageEncoding="ISO-8859-1"%>

<%@ attribute name="title1"%>
<%@ attribute name="title2"%>
<%@ attribute name="title3"%>
<%@ attribute name="title4"%>
<%@ attribute name="title5"%>
<%@ attribute name="title6"%>
<%@ attribute name="thickness"%>
<%@ attribute name="kind"%>
<%@ attribute name="color"%>

<table border="${thickness} ${kind}  ${color}">
	<tr>
		<th><b>${title1}</b></th>
		<th><b>${title2}</b></th>
		<th><b>${title3}</b></th>
	<tr>
	<tr>
		<td><b>${title4}</b></td>
		<td><b>${title5}</b></td>
		<td><b>${title6}</b></td>
	</tr>
</table>