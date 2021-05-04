<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Создание PDF-документа</title>

<link rel="stylesheet" href="css/stylepdf.css">

</head>
<body>

<h1 class="headline">Create PDF for course work</h1>
<p>Создается PDF-файл с текстом, изображением и таблицей. Данные в таблицу вносятся с формы ниже по ячейкам. Форматирование можно задать с помощью CSS.</p>

    <form action="${pageContext.request.contextPath}/JavaPDF" method="post">
        <label for="Number">Number:</label>
        <input type="text" name="Number" id="Number" value="${Number}">
        <p></p>
        <label for="Group">Group: </label>
        <input type="text" name="Group" id="Group" value="${Group}">
        <p></p>
        <label for="FIO">FIO:     </label>
        <input type="text" name="FIO" id="FIO" value="${FIO}">
        <p></p>
        <label for="Points">Points: </label>
        <input type="text" name="Points" id="Points" value="${Points}">
        <p></p>     
        <input type="submit" name="sign" value="Create PDF">
    </form>
    </body>
</html>