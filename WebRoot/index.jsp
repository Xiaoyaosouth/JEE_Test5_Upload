<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文件上传</title>
</head>
<body>
  <h2>文件上传</h2>
	<form method="post" action="upload" enctype="multipart/form-data" >
	  <table>
	    <tr>
	      <td>请选择文件：</td>
	      <td><input type="file" name="file"></td>
	    </tr>
	    <tr>
	      <td><input type="submit" value="上传"></td>
	    </tr>
	  </table>
	</form>
</body>
</html>