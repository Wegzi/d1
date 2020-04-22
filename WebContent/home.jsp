<%@page import="model.Noticia"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<%@ include file="/layout/header.html"%>
<body>
	<div id="pageheader">
		<%@ include file="/layout/menu.html"%>
	</div>
	<div id="body">
		<div class="container pt-3">
			<div class="d-flex align-items-center justify-content-between mb-3">
				<h3 class="m-0">Notícias</h3>
				<a href="create.jsp" class="btn btn-sm btn-success" role="button"
					aria-pressed="true">Nova notícia</a>
			</div>
			<div>

				<%
					ArrayList<Noticia> list = new ArrayList<Noticia>();
				if (request.getAttribute("noticias") != null) {

					list = (ArrayList<Noticia>) request.getAttribute("noticias");

					for (Noticia noticia : list) {
						if (noticia.getTexto() != null) {

					out.print("<a href='Post?id=" + noticia.getId() + "'>");
					out.print("<li class='list-group-item mb-2'>");
					out.print("<h3 class='title d-block'>" + noticia.getTitulo() + "</h3>");
					out.print("<p>" + noticia.getDescricao() + "</p>");
					out.print("<a href='Delete?id=" + noticia.getId() + "' class='btn btn-sm btn-danger'>Delete</a>");
					out.print("</li></a> ");
						}
					}
				}
				%>

			</div>
		</div>
	</div>
</body>
</html>
