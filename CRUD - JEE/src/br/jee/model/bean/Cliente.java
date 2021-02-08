package br.jee.model.bean;

import java.io.Serializable;

public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer cliCodigo;
	private String cliNome;
	
	public Integer getCliCodigo() {
		return cliCodigo;
	}
	public void setCliCodigo(Integer cliCodigo) {
		this.cliCodigo = cliCodigo;
	}
	public String getCliNome() {
		return cliNome;
	}
	public void setCliNome(String cliNome) {
		this.cliNome = cliNome;
	}
}
