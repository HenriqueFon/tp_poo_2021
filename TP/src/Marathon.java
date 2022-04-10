
public abstract class Marathon {

	private String nome;
	private String local;
	private String data;
	private String vencedor;

	// construtor
	public Marathon(String nome, String local, String data) {
		this.nome = nome;
		this.local = local;
		this.data = data;

	}

	// getters and setters
	// nome
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// local
	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	// data
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	// vencedor
	public String getVencedor() {
		return vencedor;
	}

	public void setVencedor(String vencedor) {
		this.vencedor = vencedor;
	}
}
