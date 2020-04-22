<%@page import="model.Comentario"%>
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

			<div
				class="row justify-content-center bg-white rounded shadow-sm no-gutters">
				<div class="col-lg-6 col-xl-6 col-md-12 col-xs-12 p-3 py-5">
					<div class="">

						<%
							if (request.getAttribute("noticia") != null) {

							Noticia noticia = (Noticia) request.getAttribute("noticia");

							out.print("<h1 class='title'>" + noticia.getTitulo() + "</h1>");
							out.print("<p>" + noticia.getTexto() + "</p>");
							out.print("<a href='Create?id=" + noticia.getId()
							+ "' class='btn btn-sm btn-success mt-3' role='button' aria-pressed='true'>Editar</a>");
						}
						%>

					</div>
				</div>
			</div>

			<div class='bg-white rounded shadow-sm p-3 mt-3'>
				<h3 class="title">Comentários</h3>

				<%
					ArrayList<Comentario> list = new ArrayList<Comentario>();
				if (request.getAttribute("comentarios") != null) {

					list = (ArrayList<Comentario>) request.getAttribute("comentarios");

					for (Comentario comentario : list) {
						if (comentario.getTexto() != null) {

					out.print("<div class='p-3 bg-light mb-2'>");
					out.print("<footer class='blockquote-footer'>");
					out.print(comentario.getNome());
					out.print("</footer>");
					out.print("<p>" + comentario.getTexto() + "</p>");
					out.print("</div>");

						}
					}
				}
				%>

				<div class="p-3 bg-light mb-2 mt-5">

					<form action="Comentar" method="post">
						<h5>Adicionar</h5>
						<div class="form-row">
							<input type='hidden' name='id' value='${noticia.getId()}' />
							<div class="form-group col-md-6">
								<label for="ome">Nome</label> <input type="text"
									class="form-control" id="nome" name="nome" required>
							</div>
							<div class="form-group col-md-12">
								<label for="texto">Comentário</label>
								<textarea class="form-control " id="texto" name="texto" required></textarea>
							</div>
						</div>
						<button type="submit" class="btn btn-primary">Comentar</button>
					</form>


				</div>

			</div>
		</div>
	</div>
</body>
</html>