package service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ComentartioDAO;
import dao.NoticiaDAO;
import model.Comentario;
import model.Noticia;

@WebServlet("/Post")
public class Post extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		NoticiaDAO conn = new NoticiaDAO();
		ComentartioDAO conn2 = new ComentartioDAO();
		Noticia n = new Noticia();
		n = conn.consultar(Integer.parseInt(id));

		ArrayList<Comentario> lista = new ArrayList<>();
		lista = conn2.listarComentarios(Integer.parseInt(id));
		

		request.setAttribute("noticia", n);
		request.setAttribute("comentarios", lista);

		RequestDispatcher rd = request.getRequestDispatcher("/post.jsp");
		rd.forward(request, response);

	}

}
