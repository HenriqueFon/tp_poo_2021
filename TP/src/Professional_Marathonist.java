
public class Professional_Marathonist extends Marathonist implements Printar {
	private String ranking;

	// Construtor
	public Professional_Marathonist(String nome, String tipo,String estado, String pais, String numero, String conclusaoProva,String ranking) {
		
		super(nome, tipo, estado, pais, numero, conclusaoProva);
		
		this.ranking = ranking;
	}
	
	// getters and setters
	// ranking
	public String getRanking() {
		return ranking;
	}

	public void setRanking(String ranking) {
		this.ranking = ranking;
	}
	
	// Imprimir
	public String toString() {
		return (super.toString() + " " + "Ranking:" + ranking);

	}
}
