
public class Amateur_Marathonist extends Marathonist implements Printar{
	protected String valor;
	// Construtor
		public Amateur_Marathonist(String nome, String tipo,String estado, String pais, String numero, String conclusaoProva,String valor) {
			super(nome,tipo, estado, pais, numero, conclusaoProva);
			this.valor=valor;
			
		}

		public String getValor() {
			return valor;
		}

		public void setValor(String valor) {
			this.valor = valor;
		}

		// Imprimir
		public String toString() {
			return (super.toString());

		}
}
