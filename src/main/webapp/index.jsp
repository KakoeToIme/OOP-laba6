<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Калькулятор объемов тела</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <script>
        function showFields() {
            var selectedShape = document.getElementById("function").value;
            var form = document.getElementById("inputForm");
            var fieldsContainer = document.getElementById("fieldsContainer");
            fieldsContainer.innerHTML = "";

            if (selectedShape === "Параллелепипед") {
                fieldsContainer.innerHTML += '<label for="AreaOfOsnovaniya">Площадь основания:</label> <input type="text" name="AreaOfOsnovaniya"><br><br>';
                fieldsContainer.innerHTML += '<label for="height">Высота:</label> <input type="text" name="height"><br><br>';
            } else if (selectedShape === "Куб") {
                fieldsContainer.innerHTML += '<label for="side">Сторона:</label> <input type="text" name="side"><br><br>';
            } else if (selectedShape === "Шар") {
                fieldsContainer.innerHTML += '<label for="radius">Радиус:</label> <input type="text" name="radius"><br><br>';
            } else if (selectedShape === "Тетраэдр") {
                fieldsContainer.innerHTML += '<label for="AreaOfOsnovaniya">Площадь основания:</label> <input type="text" name="AreaOfOsnovaniya"><br><br>';
                fieldsContainer.innerHTML += '<label for="height">Высота:</label> <input type="text" name="height"><br><br>';
            } else if (selectedShape === "Элипсоид") {
                fieldsContainer.innerHTML += '<label for="a">Полуось a:</label> <input type="text" name="a"><br><br>';
                fieldsContainer.innerHTML += '<label for="b">Полуось b:</label> <input type="text" name="b"><br><br>';
                fieldsContainer.innerHTML += '<label for="c">Полуось c:</label> <input type="text" name="c"><br><br>';
            }
        }

        window.onload = showFields;
    </script>
</head>
<body>
<h2>Вычисление объема тела</h2>
<form id="inputForm" action="volume-servlet" method="post">
    <label for="function">Выберите фигуру:</label>
    <select name="function" id="function" onchange="showFields()">
        <option value="Параллелепипед">Параллелепипед</option>
        <option value="Куб">Куб</option>
        <option value="Шар">Шар</option>
        <option value="Тетраэдр">Тетраэдр</option>
        <option value="Элипсоид">Элипсоид</option>
    </select><br><br>
    <div id="fieldsContainer"></div><br>
    <input type="submit" value="Вычислить объем">
</form>
</body>
</html>
