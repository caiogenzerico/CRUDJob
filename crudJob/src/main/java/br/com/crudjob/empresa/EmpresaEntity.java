package br.com.crudjob.empresa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EmpresaEntity {
	
	@Id
	@GeneratedValue
	private long id;
	private String razao_social;
	private String cnpj;
	
	public EmpresaEntity() {
		super();
	}
	
	public EmpresaEntity(long id, String razao_social, String cnpj) {
		super();
		this.id = id;
		this.razao_social = razao_social;
		this.cnpj = cnpj;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRazao_social() {
		return razao_social;
	}

	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
