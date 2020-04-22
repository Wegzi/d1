
<!DOCTYPE html>
<%@page import="model.Noticia"%>
<html lang="en" dir="ltr">
<%@ include file="/layout/header.html"%>
<body>
	<div id="pageheader">
		<%@ include file="/layout/menu.html"%>
	</div>
	<div id="body">
		<div class="container pt-3">
			<h3 class="">Criar Notí­cia</h3>
			<div>
				<div
					class="row justify-content-center bg-white rounded shadow-sm no-gutters">
					<div class="col-lg-6 col-xl-6 col-md-12 col-xs-12 p-3 py-5">

						<form action="Create" method="post">
							<div class="form-row">
								<%
									if (request.getAttribute("noticia") != null) {
									Noticia noticia = (Noticia) request.getAttribute("noticia");
									out.print("<input type='hidden' name='id' value='" + noticia.getId() + "' />");
								}
								%>
								<div class="form-group col-md-12">
									<label for="ome">Tútulo</label> <input type="text"
										class="form-control" id="titulo" name="titulo"
										value="${noticia.getTitulo()}" required>
								</div>
								<div class="form-group col-md-12">
									<label for="texto">Descrição</label>
									<textarea class="form-control " id="descricao" name="descricao"
										required>${noticia.getDescricao()}</textarea>
								</div>
								<div class="form-group col-md-12">
									<label for="texto">Texto</label>
									<textarea class="form-control " id="texto" name="texto"
										required>${noticia.getTexto()}</textarea>
								</div>
							</div>
							<button type="submit" class="btn btn-primary">Enviar</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
