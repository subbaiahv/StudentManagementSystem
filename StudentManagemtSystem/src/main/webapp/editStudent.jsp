<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ page import="com.tap.model.Student" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student</title>

<style>
    body {
        font-family: "Segoe UI", Tahoma, sans-serif;
        background: #f4f6f9;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        background: #fff;
        padding: 35px 40px;
        width: 380px;
        border-radius: 12px;
        box-shadow: 0 5px 18px rgba(0,0,0,0.15);
        animation: fadeIn 0.6s ease-in-out;
    }

    h2 {
        text-align: center;
        margin-bottom: 25px;
        color: #333;
        font-weight: 600;
        letter-spacing: 1px;
    }

    label {
        font-size: 14px;
        font-weight: 600;
        color: #444;
    }

    input[type="text"] {
        width: 100%;
        padding: 10px 12px;
        margin: 8px 0 16px 0;
        border: 1px solid #ccc;
        border-radius: 6px;
        font-size: 14px;
        transition: 0.3s;
    }

    input[type="text"]:focus {
        border-color: #28a745;
        box-shadow: 0 0 6px rgba(40,167,69,0.3);
        outline: none;
    }

    input[type="submit"] {
        width: 100%;
        padding: 12px;
        background: #28a745;
        border: none;
        color: #fff;
        font-size: 15px;
        border-radius: 6px;
        cursor: pointer;
        transition: background 0.3s;
        font-weight: 600;
    }

    input[type="submit"]:hover {
        background: #1e7e34;
    }

    @keyframes fadeIn {
        from { opacity: 0; transform: translateY(10px); }
        to { opacity: 1; transform: translateY(0); }
    }
</style>
</head>

<body>

<%
Student student = (Student)session.getAttribute("student");
%>

<div class="container">
    <h2>Update Student</h2>

    <form action="UpdateStudent">

        <label>Id</label>
        <input type="text" name="id" value="<%=student.getId() %>" >

        <label>Name</label>
        <input type="text" name="name" value="<%=student.getName() %>">

        <label>Email</label>
        <input type="text" name="email" value="<%=student.getEmail() %>">

        <label>Phone</label>
        <input type="text" name="phone" value="<%=student.getPhone() %>">

        <label>City</label>
        <input type="text" name="city" value="<%=student.getCity() %>">

        <input type="submit" value="Update Student">
    </form>
</div>

</body>
</html>

