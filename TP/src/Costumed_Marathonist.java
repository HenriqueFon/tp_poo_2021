
public class Costumed_Marathonist extends Amateur_Marathonist implements Printar {
	
	
	
private String fantasia;
	

	// Construtor
	public Costumed_Marathonist(String nome, String tipo,String estado, String pais, String numero, String conclusaoProva,
			String fantasia,String valor) {
		super(nome,tipo, estado, pais, numero, conclusaoProva,valor);
		this.fantasia = fantasia;
		
	}

	// Getters and Setters
	// Fantasia
	public String getFantasia() {
		return fantasia;
	}

	// Imprimir
	public String toString() {
		return (super.toString() + " " + "Fantasia:" + fantasia);

	}
}

