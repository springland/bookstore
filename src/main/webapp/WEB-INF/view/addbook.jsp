<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Bootstrap 4 Height Sizing of Form Controls</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
    .bs-example{
        margin: 20px;
    }
</style>
</head>
<body>

<div class="container">

  <h3>Add a new book</h3>

</div>
<div class="container">
    <div class="row">
        <div class="col-sm-2">
        </div>
        <div class="col-sm-8">
            <div class="bs-example">
                <form:form action="createbook"  method="POST" modelAttribute="book">
                      <div class="form-group">
                        <label for="Title">Title:</label>
                        <form:input type="string" class="form-control" placeholder="Enter Book Title" id="title" path="title"/>
                      </div>
                      <div class="form-group">
                        <label for="pwd">Author:</label>
                        <form:input type="string" class="form-control" placeholder="Enter Author" id="author" path="author"/>
                      </div>

                      <button type="submit" class="btn btn-primary">Submit</button>
                 </form:form>
            </div>

        </div>
        <div class="col-sm-4">
        </div>
    </div>
</div>


</body>
</html>