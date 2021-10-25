package br.com.fateczl.ProjetoSpring.model;

public class Reserva {
	private int codigo;
	private String dtReserva;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDtReserva() {
		return dtReserva;
	}

	public void setDtReserva(String dtReserva) {
		this.dtReserva = dtReserva;
	}

	@Override
	public String toString() {
		return "Reserva [codigo=" + codigo + ", dtReserva=" + dtReserva + "]";
	}
}
