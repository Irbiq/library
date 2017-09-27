<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
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
            <h4>Login</h4>
        </div>
        <div class="panel-body"align="center">
            <div class="container " style=" margin-bottom: 10%;">
                <div class="panel panel-success" style="max-width: 35%;" align="left">
                    <div class="panel-body" ><%--/login--%>
                        <form name="loginForm" action="/spring_security_login" method="post"  >
                            <div class="form-group">
                                <label >User Name</label><%--user-name--%>
                                <input type="text" class="form-control" name="username" id="user-name-id"
                                    placeholder="Name" required="required">
                            </div>
                            <div class="form-group">
                                <label >Password</label><%--user-password--%>
                                <input type="password" class="form-control" name="password" id="user-password-id"
                                    placeholder="Password" required="required">
                            </div>
                            <button type="submit" style="width: 100%;" class="btn btn-large btn btn-success btn-lg btn-block"><b>Login</b></button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>