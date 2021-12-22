<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta charset="utf-8">
	<title>Hello World!</title>

	<!-- Icons -->
	<%--    <link href="/assets/vendor/nucleo/css/nucleo-icons.css" rel="stylesheet">--%>
	<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">

	<!-- Bootstrap -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
		  integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>
<div>
	<p class="h2"> Hello ${vehicle.vehicleId}!</p>
	<p class="h3">Position: ${vehicle.position}</p>
	<div style="margin-left: 10%">
		<c:forEach items="${vehicle.near}" var="location">
			<hr>
			<div class="row">
				<div class="col">
					<img src="<c:out value="/image/${location.position[0]},${location.position[1]}"/>"/>
				</div>
				<div class="col" style="margin-top: 5px">
					<p>Name: ${location.name}</p>
					<p>Amenity: ${location.amenity}</p>
					<c:if test="${location.website}">
						<p>Website: ${location.website}</p>
					</c:if>
					<p>Distance: ${location.distance}</p>
					<p>Position: [${location.position[0]},${location.position[1]}]</p>
				</div>
				<div class="col">

				</div>
			</div>
		</c:forEach>
	</div>
</div>


</body>
</html>
