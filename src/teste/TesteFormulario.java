package teste;

import java.util.Vector;

import org.junit.Test;

import dominio.BaseDados;
import dominio.Pessoa;

public class TesteFormulario {

	@Test
	public void test() {
		BaseDados dados = new BaseDados();
		
		assert(dados.isEmpty());
		
		Pessoa pessoa = new Pessoa("John", 33);
		dados.cadastrarPessoa(pessoa);
		dados.cadastrarPessoa("Mary", 32);
		
		assert(!dados.isEmpty());

		assert(dados.quantidade() == 2);
		
		Vector<String> registros = dados.getPessoas();
		String john = pessoa.toString();
		String pessoa1 = registros.get(0);
		String pessoa2 = registros.get(1);
		Pessoa mary = new Pessoa("Mary", 32);
		
		assert(pessoa1.equals(john));
		assert(pessoa2.equals(mary.toString()));
	}
}
