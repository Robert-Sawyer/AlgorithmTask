<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Sprawdź liczbę</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
          rel="stylesheet">
    <link rel="stylesheet" href="../../media/css/style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
          integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>
<body>

<div class="pageContainer">
    <div class="registerPageTitle">
        <h2>SPRAWDZENIE POPRAWNOŚCI LICZBY WEDŁUG ALGORYTMU LUHNA</h2>
    </div>
    <div class="formContainer" >
        <form:form method="post" modelAttribute="checkNumber">
            <form:errors path="*"/><br>
            Sprawdź liczbę: <form:input path="number"/><br>
            <input id="execute" type="submit" value="Sprawdź">
        </form:form>
    </div>
    <div>
        <p id="checkedNumber"><strong></strong></p>
    </div>
</div>

</body>
</html>