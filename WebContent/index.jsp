<html>
	<head>
		<title>Sistema de Teleatendimento</title>
	</head>
	<body>
		Logou com o código : ${cod }<br>
		<form action="sistema" method="post">
			<input type="hidden" name="operacao" value="deslogar"/>
			<input type="hidden" name="cod" value="${cod }"/>
			<input type="submit" value="Deslogar"/>
		</form>
		<hr>
		<iframe width="100%" height="100%" border="0" src="https://10.1.2.52/webrtc?${cod }"></iframe>
	</body>
</html>