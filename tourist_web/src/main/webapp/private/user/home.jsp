<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="d"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QCM</title>
<style type="text/css">
.btn-link {
	border: none;
	outline: none;
	background: none;
	cursor: pointer;
	color: #0000EE;
	padding: 0;
	text-decoration: underline;
	font-family: inherit;
	font-size: inherit;
}
</style>
</head>

<body>

	<div style="margin-bottom: 170px; text-align: center">
		<div style="margin-top: 20px;">
			<p class="siteTitle ">
				Ecole Nationale des Sciences Appliquées d'Al-Hoceima <br /> <span
					class="normalText">Application Analyse de sentiments <br /> 
				</span>
			</p>
			<form action="${pageContext.request.contextPath}/logout"
				method="post">
			


				<button type="submit" name="Déconnexion" value="Déconnexion"
					class="btn-link">Déconnexion</button>

			</form>


		</div>
	</div>
<div style="float: right">


	<div style="width: 1200px; margin-top: 50px">
		<h2>Application Analyse de sentiments | Espace utilisateur</h2>

	

	</div>
</div>

</body>
</html>