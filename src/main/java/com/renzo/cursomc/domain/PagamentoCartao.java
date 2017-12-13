package com.renzo.cursomc.domain;

import javax.persistence.Entity;

import com.renzo.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoCartao extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private Integer nroParcelas;
	
	public PagamentoCartao() {
		
	}

	public PagamentoCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer nroParcelas) {
		super(id, estado, pedido);
		this.nroParcelas = nroParcelas;
	}

	public Integer getNroParcelas() {
		return nroParcelas;
	}

	public void setNroParcelas(Integer nroParcelas) {
		this.nroParcelas = nroParcelas;
	}

}
