/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package update;

/**
 *
 * @author David Samuel
 */
public class Employee {

    private String cpf;
    private String nome;
    private String orgao;
    private String lotacao;
    private String municipioDeLotacao;
    private String email;
    private String situacao;

    public Employee() {

    }

    public Employee(String cpf, String nome, String orgao, String lotacao, String municipioDeLotacao, String email, String situacao) {
        this.cpf = cpf;
        this.nome = nome;
        this.orgao = orgao;
        this.lotacao = lotacao;
        this.municipioDeLotacao = municipioDeLotacao;
        if (email.equals("")){
            this.email = " ";
        }else{
            this.email = email;
        }
        this.situacao = situacao;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
    
    public String getOrgao() {
        return orgao;
    }

    public String getLotacao() {
        return lotacao;
    }

    public String getMunicipioDeLotacao() {
        return municipioDeLotacao;
    }

    public String getEmail() {
        return email;
    }
    
    public String getSituacao(){
        return situacao;
    }
    
    public boolean valida(){
        return !"".equals(nome) && !"".equals(orgao) && 
                !"".equals(lotacao) && !"".equals(municipioDeLotacao);
    }
    
    public boolean validaCpf(){     
        return cpf.length() == 11 && cpf.matches("[0-9]*");
    }
    
    public boolean validaStatus(){
        return situacao.equals("NORMAL") || situacao.equals("FERIAS") || situacao.equals("CEDIDO") || situacao.equals("DESATIVADO");
    }

    @Override
    public String toString() {
        return cpf + " " + nome + " " + orgao + " " + lotacao + " " + municipioDeLotacao + " " + email + " " + situacao;
    }

}
