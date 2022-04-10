

	public class Donate {
		private double valor = 0;
		private String nome = "";
		

		public Donate(double valor, String nome) {
			this.nome = nome;
			this.valor = valor;

		}

		

		// getter
		// valor
		public double getValor() {
			return valor;
		}

		public void setValor(double valor) {
			this.valor = valor;
		}

		

		// getter
		// Nome
		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		// toString
		public void imprimeNome() {
			System.out.printf("o corredor %s ", getNome());
		}

		public void imprimeValor() {
			System.out.printf("realizou a doação de %2f ", getValor());
		}

		public void imprimeValorTotal() {
			System.out.printf("o valora total das doações é de: %2f ",getValor());
			
		}

	}


