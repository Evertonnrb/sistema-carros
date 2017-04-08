package br.com.nrbsistemas.dao;

import br.com.nrbsistemas.entidade.Carro;
import br.com.nrbsistemas.util.FabricaConexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarroDao {

    public void salvar(Carro carro) {
        Connection conexao = FabricaConexao.getConexao();
        try {
            PreparedStatement pst;
            if (carro.getId() == null) {
                pst = conexao.prepareCall("insert into carro (modelo,fabricante,cor,ano) values(?,?,?,?)");
            } else {
                pst = conexao.prepareCall("update carro set modelo=?,fabricante=?,cor=?,ano=? where id=?");
                pst.setInt(5, carro.getId());
            }
            pst.setString(1, carro.getModelo());
            pst.setString(2, carro.getFabricante());
            pst.setString(3, carro.getCor());
            //conversao do data.sql date do java
            pst.setDate(4, new Date(carro.getAno()));
            pst.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(CarroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Carro> listar() throws SQLException {
        try {

            String sql = "SELECT*FROM carro";
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement pst = conexao.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            List<Carro> carros = new ArrayList<>();
            while (rs.next()) {
                Carro c = new Carro();
                c.setId(rs.getInt("id"));
                c.setModelo(rs.getString("modelo"));
                c.setFabricante(rs.getString("fabricante"));
                c.setCor(rs.getString("cor"));
                c.setAno(rs.getInt("ano"));
                carros.add(c);
            }
            return carros;

        } catch (Exception e) {
        }
        return null;
    }
}
