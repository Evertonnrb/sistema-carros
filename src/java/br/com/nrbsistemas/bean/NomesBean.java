package br.com.nrbsistemas.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped      //define o tempo que a classe fica em memória (sessão)
@ManagedBean//(name = "nomeManagedBean")
public class NomesBean {
    private String nome;
    private String sobrenome;

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    
    public void dizerHola(){
       msg = "Hello "+nome+" "+sobrenome;
    }
    
    public NomesBean(){
        
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
    
}
