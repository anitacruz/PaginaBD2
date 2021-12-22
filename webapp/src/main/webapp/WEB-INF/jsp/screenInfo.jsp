<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta charset="utf-8">
	<title>Hello World!</title>


	<!-- Icons -->
	<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">



	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body class="bg-dark">
	<div class="container bg-dark">
		<div class="bg-white" style="height: 70%; width: 80%;">

			<div class="row">
				<div class="col" style="margin-top: 10%; margin-left: 5%">
					<div class="d-flex justify-content-center">
						<p class="h2 text-primary" style="font-size: 50px">Tentate:</p>
					</div>
					<div class="d-flex justify-content-center">
						<p class="h1 text-warning" style="font-size: 100px"> McDonalds</p>
					</div>
					<div class="d-flex justify-content-center">
						<p class="h2 text-success" style="font-size: 50px">A 300m</p>
					</div>
				</div>

				<div class="col">
					<img src="<c:out value="/image/-34.6112837/-58.4264576/qr"/>"/>
				</div>
			</div>
		</div>
	</div>
</body>

</html>
