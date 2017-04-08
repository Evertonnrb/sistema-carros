package br.com.nrbsistemas.util;

import br.com.nrbsistemas.exception.ErroSistemas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

    private static Connection conexao;
    private static final String URL = "jdbc:mysql://localhost/sistema-carros";
    private static final String USER ="root";
    private static final String SENHA = "";
    
    /**
     * Criando a conexão
     * conexao recebe a isntancia de conexao com o banco
     * @return 
     */
    public static Connection getConexao() throws ErroSistemas{
        if (conexao == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexao = DriverManager.getConnection(URL,USER,SENHA);
            } catch (ClassNotFoundException ex) {
              throw new ErroSistemas("Erro de driver de conexão",ex);
            } catch (SQLException ex) {
                throw new ErroSistemas("Não foi possivel conctar ao banco", ex);
            }
        }
        return conexao;
    }
    /**
     * método para  fechar a conexao
     */
    public static void fecharConexao()throws ErroSistemas{
        if(conexao!=null){
            try {
                conexao.close();
            } catch (SQLException ex) {
                throw new ErroSistemas("Erro ao fechar a conexão com BD",ex);
            }
            conexao = null;
        }
    }

  
}
