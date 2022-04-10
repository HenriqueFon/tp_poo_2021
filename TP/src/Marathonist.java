
public abstract class Marathonist implements Printar{
	protected String nome;
	protected String tipo;
	protected String estado;
	protected String pais;
	protected String numero;
	protected String conclusaoProva;
	

	// Construtor
	public Marathonist(String nome,String tipo, String estado, String pais, String numero, String conclusaoProva) {
		this.nome = nome;
		this.tipo=tipo;
		this.estado = estado;
		this.pais = pais;
		this.numero = numero;
		this.conclusaoProva = conclusaoProva;
		
	}

	// Getters and Setters
	// nome
	public String getNome() {
		return nome;
	}
	//tipo
	public String getTipo() {
		return tipo;
	}

	// cidade
	public String getEstado() {
		return estado;
	}

	// pais
	public String getPais() {
		return pais;
	}

	// numero
	public String getNumero() {
		return numero;
	}

	// Horario Terminio
	public String getConclusaoProva() {
		return conclusaoProva;
	}

	// Imprimir
	public String toString() {
		return "Nome:"+ nome + " Tipo:"+tipo + " Estado:"+estado + " País:"+pais + " Número:"+numero
				+ " Conclusão da prova:"+ conclusaoProva;

}
}
