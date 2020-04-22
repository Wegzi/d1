package service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticiaDAO;
import model.Noticia;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		System.out.println(id);
		Noticia n = new Noticia();
		n.setId(Integer.parseInt(id));
		NoticiaDAO conn = new NoticiaDAO();

		conn.excluir(n);
		response.sendRedirect("Home");
	}

}
