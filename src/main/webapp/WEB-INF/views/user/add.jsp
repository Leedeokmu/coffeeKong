<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>COFFEE KONG.</title>
</head>
<body>
<div class="a_title text-center"><h2><span>ADD USER</span></h2></div><br />
<div class="container">
    <form id="addUserForm" class="form-horizontal">
        <div>
            <div class="form-group ver_center">
                <label  class="control-label col-md-3">EMAIL</label>
                <div class="col-md-9"><span><input type="text" name="email" class="form-control"/></span></div>
            </div>
            <div class="form-group ver_center">
                <label class="control-label col-md-3">FIRST NAME</label>&nbsp;
                <div class="col-md-9"><input type="text" name="fname" class="form-control"/></div>
            </div>
            <div class="form-group ver_center">
                <label class="control-label col-md-3">LAST NAME</label>&nbsp;
                <div class="col-md-9"><input type="text" name="lname" class="form-control"/></div>
            </div>
            <div class="form-group ver_center">
                <label class="control-label col-md-3">PASSWORD</label>&nbsp;
                <div class="col-md-9"><input type="password" name="pwd" class="form-control"/></div>
            </div>
            <div class="form-group ver_center">
                <label class="control-label col-md-3">PASSWORD CONFIRM</label>&nbsp;
                <div class="col-md-9"><input type="password" name="pwdConfirm" class="form-control"/></div>
            </div>
            <div class="hor_center">
                <div class="btn-group">
                    <button class="btn btn-default" onclick="addUser()">ACCEPT</button>&nbsp;
                    <a href="/users" class="btn btn-default" >TO LIST</a>
                </div>
            </div>
        </div>
    </form>
</div>
<script>
    const addUser = () => {
        event.preventDefault();
        if(confirm('are you sure to add user?')){
            let uri = '/users';
            let response = httpCall('post', uri, $('#addUserForm').serialize());
            response.done((res) => {
                console.log(res);
                alert('add user succeeded!');
                move('/users');
            }).fail((e) => {
                console.log(e);
                console.log(e.error)
                alert('failed to add user');
            })
        }
    }
</script>
</body>
</html>
