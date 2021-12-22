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
    <script>
        function refresh(timeoutSeconds){
             setTimeout( "document.location.reload(true);", timeoutSeconds );
             return false;
        }
        window.onload = refresh(${period}) ;
    </script>
</head>
<body>

<div>
    <p class="h2"> Hello ${vehicle.vehicleId}!</p>
    <p class="h3">Position: ${vehicle.position}</p>
    <div style="margin-left: 10%">
    </div>
</div>


<div class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-inner">

        <c:forEach items="${vehicle.near}" var="location">
            <div class="carousel-item active">
                <div class="d-flex flex-column justify-content-center w-100 h-100">

                    <div class="row">
                        <div class="col">
                            <div class="d-flex flex-column justify-content-center align-items-center mt-3 ml-3">
                                <h2 class="font-weight-bolder text-white m-0" style="font-size: 6em">${location.amenity}:</h2>
                                <h1 class="font-weight-bolder text-white m-0" style="font-size: 8em">${location.name}</h1>
                                <h2 class="font-weight-bolder text-white m-0" style="font-size: 6em">A ${location.distance.intValue()}m</h2>
                            </div>
                        </div>

                        <div class="col">
                            <div class="d-flex flex-column justify-content-center align-items-center">
                                <h2 class="font-weight-bolder text-white m-0 mb-3" style="font-size: 3em">Como llegar:</h2>
                                <img src="<c:out value="/image/${location.position[0]}/${location.position[1]}/qr"/>"/>

                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </c:forEach>

    </div>
</div>




</body>
</html>
