package br.dev.marcelo.conversor_temperatura.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

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
		
		buttonKelvin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String entrada = txtEntrada.getText();
				
				if (entrada.matches(".*[^0-9].*")) {
				    System.out.println("Digite um valor válido!");
				    lblErro.setText("DIGITE UM VALOR VÁLIDO!");
				    lblSaida.setText("");
				    
				} else {
					
					//casting -> conversão de um tipo para outro
					double entradaDouble = Double.parseDouble(entrada);
					
					Temperatura temperatura = new Temperatura();
					temperatura.setCelsius(entradaDouble);
					resultado = Double.toString(temperatura.converterParaKelvin());
					lblSaida.setText(resultado + " KELVIN");
					lblErro.setText("");
					
				}
				
			}
		});
		
		buttonFahreinheit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String entrada = txtEntrada.getText();
				
				if (entrada.matches(".*[^0-9].*")) {
				    System.out.println("Digite um valor válido!");
				    
				} else {
					
					//casting -> conversão de um tipo para outro
					double entradaDouble = Double.parseDouble(entrada);
					
					Temperatura temperatura = new Temperatura();
					temperatura.setCelsius(entradaDouble);
					resultado = Double.toString(temperatura.converterParaFahreinheit());
					lblSaida.setText(resultado + " FAHREINHEIT");
				}
					
			}
		});
		
		tela.setVisible(true);
	}
}
