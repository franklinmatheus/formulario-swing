package formulario;

/**
 * 
 * @author franklin
 *
 */
public class Pessoa {
	
	private String nome;
	private int idade;
	
	/**
	 * Construtor da classe Pessoa.
	 * @param nome
	 * @param idade
	 */
	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}

	/**
	 * Retorna uma representação textual do objeto.
	 */
	public String toString() {
		return nome + " - " + idade + " anos";
	}	
}
