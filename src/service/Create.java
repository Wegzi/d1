
package service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticiaDAO;
import model.Noticia;

@WebServlet("/Create")
public class Create extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		Noticia noticia = new Noticia();
		NoticiaDAO conn = new NoticiaDAO();

		noticia = conn.consultar(Integer.parseInt(id));

		request.setAttribute("noticia", noticia);

		RequestDispatcher rd = request.getRequestDispatcher("/create.jsp");

		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		String texto = request.getParameter("texto");
		Noticia noticia = new Noticia();

		noticia.setDescricao(descricao);
		noticia.setTitulo(titulo);
		noticia.setTexto(texto);
		NoticiaDAO conn = new NoticiaDAO();
		if (id != null) {
			noticia.setId(Integer.parseInt(id));
			conn.alterar(noticia);
		} else {
			conn.cadastrar(noticia);
		}

		response.sendRedirect("Home");

	}
}
