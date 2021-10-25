package br.com.fateczl.ProjetoSpring.model;

public class Prato {

	private int id;
	private String prato;
	private float valor;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrato() {
		return prato;
	}
	public void setPrato(String prato) {
		this.prato = prato;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return "Prato [id=" + id + ", prato=" + prato + ", valor=" + valor + "]";
	}
	
	
}
