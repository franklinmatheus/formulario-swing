package dominio;

import java.util.ArrayList;
import java.util.Vector;

/**
 * 
 * @author franklin
 *
 */
public class BaseDados {
	
	private ArrayList<Pessoa> pessoas;
	
	/**
	 * Construtor da base de dados.
	 */
	public BaseDados() {
		this.pessoas = new ArrayList<Pessoa>();
	}
	
	/**
	 * Faz o cadastro de uma pessoa.
	 * @param pessoa Objeto do tipo pessoa que será cadastrado.
	 */
	public void cadastrarPessoa(Pessoa pessoa) {
		pessoas.add(pessoa);
	}
	
	/**
	 * Faz o cadastro de uma pessoa.
	 * @param nome Nome da pessoa a ser cadastrada.
	 * @param idade Idade da pessoa a ser cadastrada.
	 */
	public void cadastrarPessoa(String nome, int idade) {
		Pessoa pessoa = new Pessoa(nome, idade);
		pessoas.add(pessoa);
	}
	
	/**
	 * Retorna um vector com representações textuais das pessoas cadastradas.
	 * @return Vector com todas pessoas cadastradas.
	 */
	public Vector<String> getPessoas() {
		Vector<String> registrosPessoas = new Vector<String>();
		
		if(!isEmpty()) {
			for(Pessoa pessoa : pessoas) {
				String pessoaToString = pessoa.toString();
				registrosPessoas.add(pessoaToString);
			}
		}
		
		return registrosPessoas;
	}

	/**
	 * Informa quantas pessoas estão cadastradas.
	 */
	public int quantidade() {
		return pessoas.size();
	}
	
	/**
	 * Diz se a base de dados está vazia.
	 */
	public boolean isEmpty() {
		return pessoas.isEmpty();
	}
}
