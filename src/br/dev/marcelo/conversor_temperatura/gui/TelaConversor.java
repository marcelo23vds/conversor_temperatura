package br.dev.marcelo.conversor_temperatura.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.dev.marcelo.conversor_temperatura.model.Temperatura;

public class TelaConversor {

//	defifindo os atributos da classe tela
	private JLabel lblEntrada;
	private JTextField txtEntrada;
	private JButton buttonKelvin;
	private JButton buttonFahreinheit;
	private JLabel lblSaida;
	private JLabel lblErro;
	private String resultado;
	
// metodo para criar a tela
	public void criarTela() {
		
//		utilizando o JFrame para gerar uma tela e definindo as caracteristicas
		JFrame tela = new JFrame();
		tela.setSize(390, 305);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Conversor de Temperatura");
		tela.setLocationRelativeTo(null);
		tela.setLayout(null);
		tela.setResizable(false);
		
//		definindo funcionalidades que a tela precisa ter, com posição e tamanho
		lblEntrada = new JLabel();
		lblEntrada.setText("DIGITE ABAIXO A TEMPERATURA EM GRAUS CELSIUS (°C)");
		lblEntrada.setBounds(25, 20, 352, 30);
		
		txtEntrada = new JTextField();
		txtEntrada.setBounds(160, 70, 52, 30);
		
		buttonKelvin = new JButton();
		buttonKelvin.setText("CONVERTER PARA KELVIN (K)");
		buttonKelvin.setBounds(60, 120, 242, 30);
		
		buttonFahreinheit = new JButton();
		buttonFahreinheit.setText("CONVERTER PARA FAHREINHEIT (°F)");
		buttonFahreinheit.setBounds(60, 160, 242, 30);
		
		lblSaida = new JLabel();
		lblSaida.setBounds(158, 210, 102, 30);
		
		lblErro = new JLabel();
		lblErro.setBounds(107, 210, 202, 30);
		
//		adicionando na tela as funcionalidades criadas
		tela.getContentPane().add(lblEntrada);
		tela.getContentPane().add(txtEntrada);
		tela.getContentPane().add(buttonKelvin);
		tela.getContentPane().add(buttonFahreinheit);
		tela.getContentPane().add(lblSaida);
		tela.getContentPane().add(lblErro);
		
//		ao clicar no botao para converter em KELVIN é chamado este listener
		buttonKelvin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
//				capturando a entrada do usuario no textfield e adicionando na variavel -> entrada
				String entrada = txtEntrada.getText();
				
//				verificando com -> entrada.matches(".*[^0-9].*") <- se na variavel entrada (String) possui no minimo 1 caractere que não seja numero OU -> entrada.matches("") <- que verifica se o textfield está vazio, caso um dos dois seja verdadeiro aparece a mensagem de erro quando o usuario clicar em algum botão
				if (entrada.matches(".*[^0-9].*") || entrada.matches("")) {
				    lblErro.setText("DIGITE UM VALOR VÁLIDO!");
				    lblSaida.setText(""); //após a mensagem de erro adicionei uma String vazia na label de saída para limpar a tela caso anteriormente tenha tido algum resultado válido
				    
				} else {
					
//					após a validação ter sido feita e o valor digitado pelo usuario ser valido:
//					casting, conversão da variavel entrada que tem armazenado o digito do usuario (String) para um tipo double para poder ser realizado os calculos de conversão de temperatura
					double entradaDouble = Double.parseDouble(entrada);
					
//					criando o objeto temperatura e enviando como parametro via set a variavel -> entradaDouble <- (que tem o mesmo conteudo da -> entrada <- mas que foi convertida para double)
					Temperatura temperatura = new Temperatura();
					temperatura.setCelsius(entradaDouble);
					
//					(casting novamente) para o valor (double) que o metodo de calculo de conversão retorna ser apresentado na tela via JLabel é necessário converter para String
					resultado = Double.toString(temperatura.converterParaKelvin());
					lblSaida.setText(resultado + "  K"); //resultado que deve aparecer na tela
					lblErro.setText(""); //como o resultado foi válido neste caso, adicionei "" na label de erro para limpar a tela caso tenha tido uma mensagem de erro anteriormente
					
				}
				
			}
		});
		
//		parecido com o clicar no botão anterior, alterando apenas o metodo que é chamado na classe Temperatura, pois é um método para cada tipo de calculo de conversão de temperatura, neste caso é o FAHREINHEIT
		buttonFahreinheit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String entrada = txtEntrada.getText();
				
				if (entrada.matches(".*[^0-9].*") || entrada.matches("")) {
				    lblErro.setText("DIGITE UM VALOR VÁLIDO!");
				    lblSaida.setText("");
				    
				} else {
					
					double entradaDouble = Double.parseDouble(entrada);
					
					Temperatura temperatura = new Temperatura();
					temperatura.setCelsius(entradaDouble);
					resultado = Double.toString(temperatura.converterParaFahreinheit());
					lblSaida.setText(resultado + " °F");
					lblErro.setText("");
				}
					
			}
		});
		
//		tornar a tela visivel
		tela.setVisible(true);
	}
}
