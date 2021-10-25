package br.com.fateczl.ProjetoSpring.model;

public class PratoReserva {
	private Reserva reserva;
	private Prato prato;
	private int quantidade;
	
	public Reserva getReserva() {
		return reserva;
	}
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	public Prato getPrato() {
		return prato;
	}
	public void setPrato(Prato prato) {
		this.prato = prato;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override
	public String toString() {
		return "PratoReserva [reserva=" + reserva + ", prato=" + prato + ", quantidade=" + quantidade + "]";
	}
}
