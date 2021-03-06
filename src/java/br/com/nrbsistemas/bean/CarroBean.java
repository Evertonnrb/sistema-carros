package br.com.nrbsistemas.bean;

import br.com.nrbsistemas.dao.CarroDao;
import br.com.nrbsistemas.entidade.Carro;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CarroBean {

    private Carro carro = new Carro();
    private List<Carro> carros = new ArrayList<>();
    private CarroDao dao = new CarroDao();
    
    public void adicionar() {
        carros.add(carro);
        dao.salvar(carro);
        carro = new Carro();
    }

    public void listar() throws SQLException{
        carros = dao.listar();
    }
    
    public void editar(Carro c){
        carro = c;
    }
    
    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
    
    
}
