package formulario;

import java.util.Vector;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import dominio.BaseDados;
import dominio.Pessoa;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * 
 * @author franklin
 *
 */
public class Formulario extends JFrame {
	
	private JPanel panel;
	private JPanel panelMens;
	private JPanel panelForm;
	private JPanel panelList;
	private JLabel labelNome;
	private JLabel labelIdade;
	private JButton buttonCadastrar;
	private JButton buttonListar;
	private JButton buttonFechar;
	private JTextField inputNome;
	private JTextField inputIdade;
	private JLabel mensagem;
	private JList<String> lista;
	private JScrollPane scroll;
	private boolean hasNewPerson;

	private BaseDados basedados;
	
	/**
	 * Construtor da janela do formulário.
	 */
	public Formulario() {
		super();
		
		this.panel = new JPanel();
		this.panelMens = new JPanel();
		this.panelForm = new JPanel();
		this.panelList = new JPanel();
		this.labelNome = new JLabel("Nome");
		this.labelIdade = new JLabel("Idade");
		this.buttonCadastrar = new JButton("Cadastrar");
		this.buttonListar = new JButton("Listar");
		this.buttonFechar = new JButton("Fechar");
		this.inputNome = new JTextField(10);
		this.inputIdade = new JTextField(10);
		this.mensagem = new JLabel("Adicione uma pessoa");
		this.lista = new JList<String>();
		this.scroll = new JScrollPane(lista);
		this.hasNewPerson = false;
		this.basedados = new BaseDados();
	}
	
	/**
	 * Define toda a interface gráfica da janela, incluindo layouts ações de botões e posição dos elementos (labels, botões...).
	 */
	public void fazerJanela() {
		
		setTitle("Cadastro de pessoas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		
		panelForm.setLayout(new GridBagLayout());
		GridBagConstraints grid = new GridBagConstraints();
		grid.fill = GridBagConstraints.HORIZONTAL;
		grid.insets = new Insets(0, 5, 0, 5);
		
		grid.gridx = 0;
		grid.gridy = 0;
		panelForm.add(labelNome, grid);
		grid.gridy = 1;
		panelForm.add(inputNome, grid);
		
		grid.gridx = 1;
		grid.gridy = 0;
		panelForm.add(labelIdade, grid);
		grid.gridy = 1;
		panelForm.add(inputIdade, grid);
		
		grid.insets = new Insets(10, 5, 10, 5);
		
		grid.gridx = 2;
		grid.gridy = 1;
		panelForm.add(buttonCadastrar, grid);
		
		grid.gridx = 2;
		grid.gridy = 2;
		panelForm.add(buttonFechar, grid);
		
		grid.gridx = 2;
		grid.gridy = 3;
		panelForm.add(buttonListar, grid);
		
		grid.weightx = 0;
		grid.gridy = 2;
		panelMens.add(mensagem);
		
		panelList.setLayout(new GridLayout(2, 1));
		panelList.add(scroll);
		panelList.add(panelMens);
		
		buttonCadastrar.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				if((!inputNome.getText().trim().isEmpty()) && (!inputIdade.getText().trim().isEmpty())) {
					try {
						int idade = Integer.parseInt(inputIdade.getText());
						String nome = inputNome.getText();
						Pessoa pessoa = new Pessoa(nome, idade);
						basedados.cadastrarPessoa(pessoa);
						
						mensagem.setText("Pessoa adicionada!");
						mensagem.setForeground(Color.green);
						
						hasNewPerson = true;
					} catch (Exception e) {
						mensagem.setText("Idade inválida!");
						mensagem.setForeground(Color.red);
					}
				} else {
					mensagem.setText("Preencha todos os campos!");
					mensagem.setForeground(Color.red);
				}
			}
		});
		
		buttonListar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(!basedados.isEmpty()) {
					if(hasNewPerson) {
						Vector<String> registros = basedados.getPessoas();
						lista.setListData(registros);
						mensagem.setText("Adicione uma pessoa");
						mensagem.setForeground(Color.black);
					} else {
						mensagem.setText("Lista já está atualizada!");
						mensagem.setForeground(Color.blue);
					}
					hasNewPerson = false;
				} else {
					mensagem.setText("Nenhum dado para listar!");
					mensagem.setForeground(Color.red);
				}	
			}
		});
		
		buttonFechar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		panel.setLayout(new GridLayout(2, 1));
		panel.add(panelForm);
		panel.add(panelList);
		
		add(panel);
	}
}
