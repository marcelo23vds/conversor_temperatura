package br.dev.marcelo.conversor_temperatura.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.dev.marcelo.conversor_temperatura.model.Temperatura;

public class TelaConversor {

	private JLabel lblEntrada;
	private JTextField txtEntrada;
	private JButton buttonKelvin;
	private JButton buttonFahreinheit;
	private JLabel lblSaida;
	private JLabel lblErro;
	private String resultado;
	
	public void criarTela() {
		
		JFrame tela = new JFrame();
		tela.setSize(500, 500);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Conversor de Temperatura");
		tela.setLocationRelativeTo(null);
		tela.setLayout(null);
		tela.setResizable(false);
		
		lblEntrada = new JLabel();
		lblEntrada.setText("Digite a temperatura em Graus Celsius:");
		lblEntrada.setBounds(20, 10, 250, 30);
		
		txtEntrada = new JTextField();
		txtEntrada.setBounds(20, 40, 200, 30);
		
		buttonKelvin = new JButton();
		buttonKelvin.setText("Kelvin");
		buttonKelvin.setBounds(20, 80, 200, 30);
		
		buttonFahreinheit = new JButton();
		buttonFahreinheit.setText("Fahreinheit");
		buttonFahreinheit.setBounds(20, 120, 200, 30);
		
		lblSaida = new JLabel();
		lblSaida.setBounds(20, 160, 200, 30);
		
		lblErro = new JLabel();
		lblErro.setBounds(20, 200, 200, 30);
		
		tela.getContentPane().add(lblEntrada);
		tela.getContentPane().add(txtEntrada);
		tela.getContentPane().add(buttonKelvin);
		tela.getContentPane().add(buttonFahreinheit);
		tela.getContentPane().add(lblSaida);
		tela.getContentPane().add(lblErro);
		
//		para finalizar falta apenas verificar se o conteudo digitado na entrada é numero, 
//		caso nao seja, fazer um jeito de aparecer a mensagem de erro na tela,
//		falta também fazer um design melhor para a tela, após isso testar e entregar
		
		buttonKelvin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String entrada = txtEntrada.getText();
				
				//casting -> conversão de um tipo para outro
				double entradaDouble = Double.parseDouble(entrada);
				
				Temperatura temperatura = new Temperatura();
				temperatura.setCelsius(entradaDouble);
				resultado = Double.toString(temperatura.converterParaKelvin());
				lblSaida.setText(resultado + " KELVIN");
				
			}
		});
		
		buttonFahreinheit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String entrada = txtEntrada.getText();
				
				//casting -> conversão de um tipo para outro
				double entradaDouble = Double.parseDouble(entrada);
				
				Temperatura temperatura = new Temperatura();
				temperatura.setCelsius(entradaDouble);
				resultado = Double.toString(temperatura.converterParaFahreinheit());
				lblSaida.setText(resultado + " FAHREINHEIT");
				
			}
		});
		
		tela.setVisible(true);
	}
}
