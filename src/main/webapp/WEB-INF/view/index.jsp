<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>PDF Download ButtonTest</title>
</head>
<body>
	<h1>PDF Download ButtonTest</h1>
	<s:form method="POST">
		<html:multibox styleId="multiBox1" property="multiBox" value="健康保険証"></html:multibox>
			<label for="multiBox1">健康保険証</label>
		<html:multibox styleId="multiBox2" property="multiBox" value="運転免許証"></html:multibox>
			<label for="multiBox2">運転免許証</label>
		<html:multibox styleId="multiBox3" property="multiBox" value="マイナンバー通知書"></html:multibox>
			<label for="multiBox3">マイナンバー通知書</label>
		<s:submit property="print" value="印刷"></s:submit>
	</s:form>
	${f:h(requiredDocument.multiBox)}
</body>
</html>