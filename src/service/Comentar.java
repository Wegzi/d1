package service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ComentartioDAO;
import model.Comentario;

@WebServlet("/Comentar")
public class Comentar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String texto = request.getParameter("texto");
		String fkId = request.getParameter("id");
		Comentario c = new Comentario();

		c.setNome(nome);
		c.setTexto(texto);
		c.setFkId(Integer.parseInt(fkId));

		ComentartioDAO conn = new ComentartioDAO();
		conn.cadastrar(c);
		response.sendRedirect("Post?id=" + fkId);

	}

}
