package com.emersondantas.cursomc.domain.enums;

public enum TipoCliente {
	PESSOAFISICA(1,"Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private Integer cod;
	private String descricao;
	
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(TipoCliente xCliente : TipoCliente.values()) {
			if(cod.equals(xCliente.getCod())) {
				return xCliente;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
