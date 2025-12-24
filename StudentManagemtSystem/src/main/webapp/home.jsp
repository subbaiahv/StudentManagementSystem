<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tap.model.Student" %> 
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Cards</title>

<style>

    /* ---------- GLOBAL BODY ---------- */
    body {
        font-family: "Segoe UI", Tahoma, sans-serif;
        background: linear-gradient(135deg, #eef2f3, #dfe9f3);
        margin: 0;
        padding: 0;
    }

    /* ---------- HEADER ---------- */
    .header {
        background: linear-gradient(135deg, #4e73df, #224abe);
        padding: 25px 0;
        text-align: center;
        color: white;
        box-shadow: 0 4px 20px rgba(0,0,0,0.15);
        margin-bottom: 40px;
    }

    .header h2 {
        margin: 0;
        font-size: 30px;
        font-weight: 700;
        letter-spacing: 1px;
    }

    /* ---------- ADD BUTTON ---------- */
    .top-btn {
        display: flex;
        justify-content: center;
        margin-bottom: 25px;
    }

    .main-btn {
        padding: 12px 22px;
        background: linear-gradient(135deg, #28a745, #20c997);
        color: white;
        border: none;
        border-radius: 50px;
        cursor: pointer;
        font-size: 16px;
        font-weight: 700;
        box-shadow: 0 6px 12px rgba(0,0,0,0.15);
        transition: transform 0.3s ease, box-shadow 0.3s ease;
    }

    .main-btn:hover {
        transform: translateY(-3px);
        box-shadow: 0 10px 20px rgba(0,0,0,0.20);
    }

    /* ---------- CARD CONTAINER ---------- */
    .card-container {
        display: flex;
        flex-wrap: wrap;
        gap: 35px;
        justify-content: center;
        padding: 20px;
    }

    /* ---------- CARD DESIGN ---------- */
    .card {
        width: 320px;
        background: rgba(255, 255, 255, 0.85);
        backdrop-filter: blur(7px);
        border-radius: 16px;
        border: 1px solid rgba(0,0,0,0.1);
        padding: 25px;
        box-shadow: 0 8px 25px rgba(0,0,0,0.15);
        transition: transform 0.3s ease, box-shadow 0.4s ease;
        position: relative;
        overflow: hidden;
    }

    .card::before {
        content: "";
        position: absolute;
        top: -50px;
        right: -50px;
        width: 120px;
        height: 120px;
        background: rgba(78,115,223,0.15);
        border-radius: 50%;
    }

    .card:hover {
        transform: translateY(-7px);
        box-shadow: 0 14px 35px rgba(0,0,0,0.22);
    }

    /* ---------- CARD HEADER ---------- */
    .card h3 {
        margin: 0;
        font-size: 24px;
        font-weight: 700;
        text-align: center;
        color: #1f1f1f;
        margin-bottom: 15px;
    }

    /* ---------- INFO TEXT ---------- */
    .info {
        font-size: 16px;
        margin: 10px 0;
        padding: 8px 12px;
        background: #f7f9fc;
        border-left: 4px solid #4e73df;
        border-radius: 5px;
        color: #444;
        box-shadow: inset 0 0 4px rgba(0,0,0,0.05);
    }

    /* ---------- BUTTON GROUP ---------- */
    .btn-box {
        margin-top: 20px;
        display: flex;
        justify-content: space-between;
    }

    .btn {
        flex: 1;
        padding: 10px 12px;
        border: none;
        border-radius: 8px;
        cursor: pointer;
        color: white;
        font-size: 15px;
        font-weight: 600;
        transition: transform 0.3s ease, box-shadow 0.3s ease;
    }

    .edit-btn {
        background: linear-gradient(135deg, #3498db, #2980b9);
        margin-right: 8px;
    }

    .edit-btn:hover {
        transform: translateY(-3px);
        box-shadow: 0 8px 20px rgba(41, 128, 185, 0.4);
    }

    .delete-btn {
        background: linear-gradient(135deg, #e74c3c, #c0392b);
        margin-left: 8px;
    }

    .delete-btn:hover {
        transform: translateY(-3px);
        box-shadow: 0 8px 20px rgba(192, 57, 43, 0.4);
    }

</style>

</head>
<body>

<!-- HEADER -->
<div class="header">
    <h2>Student Management Dashboard</h2>
</div>

<!-- ADD BUTTON -->
<div class="top-btn">
    <a href="addStudent.jsp">
        <button class="main-btn">➕ Add Student</button>
    </a>
</div>

<%
    List<Student> studentList = (List<Student>) session.getAttribute("studentList");
%>

<!-- CARD LIST -->
<div class="card-container">

<%
    if (studentList != null) {
        for (Student s : studentList) {
%>

    <div class="card">
        <h3><%= s.getName() %></h3>

        <div class="info">🆔 <b>Name:</b> <%= s.getName() %></div>
        <div class="info">📧 <b>Email:</b> <%= s.getEmail() %></div>
        <div class="info">📞 <b>Phone:</b> <%= s.getPhone() %></div>
        <div class="info">🏙️ <b>City:</b> <%= s.getCity() %></div>

        <div class="btn-box">
            <a href="FetchOne?id=<%= s.getId() %>">
                <button class="btn edit-btn">✏ Edit</button>
            </a>

            <a href="Delete?sid=<%= s.getId() %>">
                <button class="btn delete-btn">🗑 Delete</button>
            </a>
        </div>
    </div>

<%
        }
    }
%>

</div>

</body>
</html>

