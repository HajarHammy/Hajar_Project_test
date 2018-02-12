<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="s" uri="/struts-tags"%>




<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>



<%@ taglib prefix="sjdt" uri="/struts-jquery-datatables-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring and Struts Integration Demo</title>
<sj:head jquerytheme="redmond" />

</head>
<body>
	<div align="center">

		<div>

			<s:if test="hasActionErrors()">
				<div class="errors">
					<s:actionerror />
				</div>
			</s:if>
		</div>

		<div>

			<s:if test="hasActionMessages()">
				<div class="messages">
					<s:actionmessage />
				</div>
			</s:if>
		</div>


		<h2>Ajout d'une destination</h2>

		<s:form action="addDestination" method="post">

			<div class="type-text">
				<s:textfield label="Destination :" name="destination.nomDest" />
			</div>

			<sj:submit value="Enregistrer" />
			
			
		</s:form>
		<s:form action="addFileUpload" method="post" enctype="multipart/form-data">
			<s:file name="upload" label="User Image" />
			<s:submit value="Upload" align="center" />
		</s:form>

	</div>
</body>
</html>