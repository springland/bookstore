<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <title>Bookstore Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
<body>

<c:import url="navbar.jsp"/>

<div class="container">
  <div>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Author</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
   </div>


   <div class="bs-example">
       <nav>
           <ul class="pagination">
               <li class="page-item disabled"><a href="#" class="page-link" tabindex="-1">Previous</a></li>
               <li class="page-item active"><a href="#" class="page-link">1</a></li>
               <li class="page-item"><a href="#" class="page-link">2</a></li>
               <li class="page-item"><a href="#" class="page-link">3</a></li>
               <li class="page-item"><a href="#" class="page-link">4</a></li>
               <li class="page-item"><a href="#" class="page-link">5</a></li>
               <li class="page-item"><a href="#" class="page-link">Next</a></li>
           </ul>
       </nav>
   </div>

   </div>
</div>

</body>
</html>
