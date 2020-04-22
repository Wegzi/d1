package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Comentario;
import model.Noticia;

public class ComentartioDAO {

	private Connection conexao;

	public ComentartioDAO() {
		this.conexao = ConnectionFactory.conectar();
	}

	public void cadastrar(Comentario comentario) {
		String inserir = "INSERT INTO comentario (nome, texto, fk_noticia_id) VALUES (?, ?, ?) ";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {

			pst.setString(1, comentario.getNome());
			pst.setString(2, comentario.getTexto());
			pst.setInt(3, comentario.getFkId());
			pst.execute();
		} catch (SQLException ex) {
			System.err.println("Não foi possível manipular a tabela noticia.");
			ex.printStackTrace();
		}
	}

	public ArrayList<Comentario> listarComentarios(int id) {

		String query = "SELECT * FROM comentario where fk_noticia_id = ?";

		try (PreparedStatement pst = conexao.prepareStatement(query)) {
			pst.setInt(1, id);

			ResultSet resultado = pst.executeQuery();

			ArrayList<Comentario> lista = new ArrayList<>();
			while (resultado.next()) {
				Comentario c = new Comentario();
				c.setId(resultado.getInt("id"));
				c.setNome(resultado.getString("nome"));
				c.setTexto(resultado.getString("texto"));
				c.setFkId(resultado.getInt("fk_noticia_id"));
				lista.add(c);
			}
			return lista;

		} catch (SQLException ex) {

			System.err.println("Não foi possível manipular a tabela Professor.");
			ex.printStackTrace();

			return null;
		}
	}

}
