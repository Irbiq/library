<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
</head>
<jsp:include page="navbar.jsp"></jsp:include>
<body>
<br>
<br>
<div class="container-fluid">
    <div class="panel panel-success">
        <div class="panel-heading" align="center">
            <h4>Add Book</h4>
        </div>
        <div class="panel-body"align="center">
            <div class="container " style=" margin-bottom: 10%;">
                <div class="panel panel-success" style="max-width: 35%;" align="left">
                    <div class="panel-body" >
                        <form name="loginForm" action="/books/add" method="post"  >
                            <div class="form-group">
                                <label >Book Title</label>
                                <input type="text" class="form-control" name="book-title" id="book-title-id"
                                    placeholder="title" required="required">
                            </div>
                            <button type="submit" style="width: 100%;" class="btn btn-large btn btn-success btn-lg btn-block"><b>Add</b></button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
