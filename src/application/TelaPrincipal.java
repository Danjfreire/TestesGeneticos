package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Toolkit;
import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;
import org.jpl7.Util;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField tfPai;
	private JTextField tfPessoa;
	private JTextField tfMae;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		File temp = new File("");
		String tempCaminho = temp.getAbsolutePath();
		String caminho = tempCaminho.replace("\\", "\\\\");
		String caminhoPL = caminho + "\\\\analise_genetica";
		
		Query q1 = new Query( "consult", new Term[] {new Atom(caminhoPL)} );
		
		System.out.println( "consulta " + (q1.hasSolution() ? "completada" : "falhou"));
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/imagens/dna-helix-16.png")));
		setTitle("An\u00E1lise Gen\u00E9tica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()) , (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight())-30);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPessoa = new JMenu("Pessoa");
		menuBar.add(mnPessoa);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.setBackground(Color.WHITE);
		mnPessoa.add(mntmCadastrar);
		mntmCadastrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				TelaIndividuo tela = new TelaIndividuo();
				tela.setVisible(true);
			}
		});
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1120, 667);
		contentPane.add(scrollPane);
		

		JTextArea areaResposta = new JTextArea();
		areaResposta.setForeground(new Color(199, 21, 133));
		areaResposta.setFont(new Font("Courier New", Font.BOLD, 13));
		scrollPane.setViewportView(areaResposta);
		
		ButtonGroup grupo = new ButtonGroup();
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Consulta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(199, 21, 133)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(1140, 14, 210, 653);
		contentPane.add(panel);
		panel.setLayout(null);
										
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 182, 190, 126);
		panel.add(panel_1);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Selecionar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(199, 21, 133)));
		panel_1.setLayout(null);
										
		JRadioButton rdbtnCalvicie = new JRadioButton("Calv\u00EDcie");
		rdbtnCalvicie.setBackground(Color.WHITE);
		rdbtnCalvicie.setBounds(6, 18, 74, 23);
		panel_1.add(rdbtnCalvicie);
		grupo.add(rdbtnCalvicie);
		JRadioButton rdbtnSangue = new JRadioButton("Sangue");
		rdbtnSangue.setBackground(Color.WHITE);
		rdbtnSangue.setBounds(6, 44, 74, 23);
		panel_1.add(rdbtnSangue);
		grupo.add(rdbtnSangue);
								
		JRadioButton rdbtnPele = new JRadioButton("Pele\r\n");
		rdbtnPele.setBackground(Color.WHITE);
		rdbtnPele.setBounds(6, 70, 74, 23);
		panel_1.add(rdbtnPele);
		grupo.add(rdbtnPele);
									
		JRadioButton rdbtnOlhos = new JRadioButton("Olhos\r\n");
		rdbtnOlhos.setBackground(Color.WHITE);
		rdbtnOlhos.setBounds(6, 96, 74, 23);
		panel_1.add(rdbtnOlhos);
		grupo.add(rdbtnOlhos);
									
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Nomes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(199, 21, 133)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 57, 190, 114);
		panel.add(panel_2);
		panel_2.setLayout(null);
									
		tfMae = new JTextField();
		tfMae.setBounds(56, 52, 124, 20);
		panel_2.add(tfMae);
		tfMae.setColumns(10);
									
		tfPessoa = new JTextField();
		tfPessoa.setBounds(56, 21, 124, 20);
		panel_2.add(tfPessoa);
		tfPessoa.setColumns(10);
								
		tfPai = new JTextField();
		tfPai.setBounds(56, 83, 124, 20);
		panel_2.add(tfPai);
		tfPai.setColumns(10);
									
		JLabel lblIndividuo = new JLabel("Pessoa:");
		lblIndividuo.setBounds(10, 24, 68, 14);
		panel_2.add(lblIndividuo);
									
		JLabel lblMe = new JLabel("M\u00E3e:");
		lblMe.setBounds(10, 55, 46, 14);
		panel_2.add(lblMe);
									
		JLabel lblPai = new JLabel("Pai:");
		lblPai.setBounds(10, 86, 46, 14);
		panel_2.add(lblPai);
		
		rdbtnCalvicie.setEnabled(false);
		rdbtnOlhos.setEnabled(false);
		rdbtnPele.setEnabled(false);
		rdbtnSangue.setEnabled(false);
		tfPai.setEditable(false);
		tfMae.setEditable(false);
										
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u00C1rvore", "Descendentes", "Compatibilidade", "Probabilidade"}));
		comboBox.setBounds(10, 26, 190, 20);
		panel.add(comboBox);
		comboBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(comboBox.getSelectedItem().equals("Compatibilidade")){
					tfPai.setEditable(true);
					tfMae.setEditable(true);
					tfPessoa.setEditable(true);
					rdbtnCalvicie.setEnabled(false);
					rdbtnOlhos.setEnabled(false);
					rdbtnPele.setEnabled(false);
					rdbtnSangue.setEnabled(false);
				}
				if(comboBox.getSelectedItem().equals("Descendentes")){
					tfPai.setEditable(true);
					tfMae.setEditable(true);
					tfPessoa.setEditable(false);
					rdbtnCalvicie.setEnabled(false);
					rdbtnOlhos.setEnabled(false);
					rdbtnPele.setEnabled(false);
					rdbtnSangue.setEnabled(false);
				}
				if(comboBox.getSelectedItem().equals("\u00C1rvore")){
					tfPai.setEditable(false);
					tfMae.setEditable(false);
					tfPessoa.setEditable(true);
					rdbtnCalvicie.setEnabled(false);
					rdbtnOlhos.setEnabled(false);
					rdbtnPele.setEnabled(false);
					rdbtnSangue.setEnabled(false);
				}
				if(comboBox.getSelectedItem().equals("Probabilidade")){
					tfPai.setEditable(true);
					tfMae.setEditable(true);
					tfPessoa.setEditable(false);
					rdbtnCalvicie.setEnabled(true);
					rdbtnOlhos.setEnabled(true);
					rdbtnPele.setEnabled(true);
					rdbtnSangue.setEnabled(true);
				}
			}
		});
										
		JButton btnExecutar = new JButton("Executar");
		btnExecutar.setForeground(Color.WHITE);
		btnExecutar.setBackground(new Color(199, 21, 133));
		btnExecutar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExecutar.setBounds(10, 598, 190, 44);
		panel.add(btnExecutar);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "N\u00EDvel \u00E1rvore geneal\u00F3gica", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(199, 21, 133)));
		panel_3.setBounds(10, 319, 190, 90);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(10, 36, 170, 20);
		panel_3.add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "N\u00EDvel \u00E1rvore descendentes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(199, 21, 133)));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(10, 434, 190, 90);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"}));
		comboBox_2.setBounds(10, 34, 170, 20);
		panel_4.add(comboBox_2);
		btnExecutar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				StringBuffer resposta = new StringBuffer();
				if(comboBox.getSelectedItem().toString().equals("\u00C1rvore")){
					//usar tfPessoa.getText()
					if(tfPessoa.getText().isEmpty())
						JOptionPane.showMessageDialog(null, "Preencha o campo 'Pessoa'");
					else{
						Arvore a = new Arvore();
						resposta = a.gerarArvoreProlog(tfPessoa, comboBox_1.getSelectedItem().toString());
						areaResposta.setText(resposta.toString());
						
						//areaResposta.
					}
						
				} else if(comboBox.getSelectedItem().toString().equals("Descendentes")){
					//usar tfMae.getText() e tfPai.getText()
					if(tfMae.getText().isEmpty() || tfPai.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Preencha os campos 'Pai' e 'Mãe'");
					}//resposta.append(Query.oneSolution("").get("X"));
					else{
						Arvore a = new Arvore();
						resposta = a.gerarArvoreDescendencia(tfPai, tfMae, comboBox_2.getSelectedItem().toString());
						areaResposta.setText(resposta.toString());
					}
					
				} else if(comboBox.getSelectedItem().toString().equals("Compatibilidade")){
					//usar tfMae.getText() e tfPai.getText()
					if(tfMae.getText().isEmpty() || tfPai.getText().isEmpty() || tfPessoa.getText().isEmpty())
						JOptionPane.showMessageDialog(null, "Preencha todos os campos'");
					else{
						resposta.append("RESULTADO\n\n");
						Query q = new Query("compatibilidade('"+tfPai.getText()+"', '"+tfMae.getText()+ "', '"+tfPessoa.getText()+
								"', Resposta, Id).");
						Term respostaQ = q.oneSolution().get("Resposta");
						Term id = q.oneSolution().get("Id");
						if((id.toString().equals("1"))){
							tfMae.setText("");
							tfPai.setText("");
							tfPessoa.setText("");
							resposta.append(respostaQ);
						}else{
							if(id.toString().equals("2") || id.toString().equals("5")){
								tfPai.setText("");
								resposta.append(respostaQ);
							}else if(id.toString().equals("3") || id.toString().equals("4")){
								tfMae.setText("");
								resposta.append(respostaQ);
							}else if(id.toString().equals("6")){
								tfPessoa.setText("");
								resposta.append(respostaQ);
							}else if(id.toString().equals("7") || id.toString().equals("11") ){
								tfMae.setText("");
								tfPai.setText("");
								tfPessoa.setText("");
								resposta.append(respostaQ);
							}else if(id.toString().equals("8")){
								tfMae.setText("");
								tfPai.setText("");
								resposta.append(respostaQ);
							}else if(id.toString().equals("9")){
								tfPai.setText("");
								tfPessoa.setText("");
								resposta.append(respostaQ);
							}else if(id.toString().equals("10")){
								tfMae.setText("");
								tfPessoa.setText("");
								resposta.append(respostaQ);
							}
						}
						areaResposta.setText(resposta.toString());
					}
					
				} else if(comboBox.getSelectedItem().toString().equals("Probabilidade")){
					//usar tfMae.getText() e tfPai.getText()
					if(tfMae.getText().isEmpty() || tfPai.getText().isEmpty())
						JOptionPane.showMessageDialog(null, "Preencha os campos 'Pai' e 'Mãe'");
					
					if(rdbtnCalvicie.isSelected()){
						Query q = new Query("probabilidadeCalvicieNome('"+tfPai.getText() +"','"+ tfMae.getText()+"','sim'"+",X, Resposta, Id).");
						Term r = q.oneSolution().get("Resposta");
						Term id = q.oneSolution().get("Id");
						if(r.isVariable()){
							resposta.append("calvo: ");
							resposta.append(Query.oneSolution("probabilidadeCalvicieNome('"+tfPai.getText() +"','"+ tfMae.getText()+"','sim'"+",X, Resposta, Id).").get("X"));
							resposta.append("%\n");
							resposta.append("não calvo: ");
							resposta.append(Query.oneSolution("probabilidadeCalvicieNome('"+tfPai.getText()+"','"+tfMae.getText()+"','não',X, Resposta, Id).").get("X"));
							resposta.append("%\n");
							tfPai.setText("");
							tfMae.setText("");
						}else{
							if(id.toString().equals("2") || id.toString().equals("5")){
								tfPai.setText("");
								resposta.append(r);
							}else if(id.toString().equals("3") || id.toString().equals("4")){
								tfMae.setText("");
								resposta.append(r);
							}
						}
						areaResposta.setText(resposta.toString());
						
					} else if(rdbtnSangue.isSelected()){
						Query q = new Query("probabilidadeSangueNome('"+tfPai.getText() +"','"+ tfMae.getText()+"','A'"+",X, Resposta, Id).");
						Term r = q.oneSolution().get("Resposta");
						Term id = q.oneSolution().get("Id");
						if(r.isVariable()){
							resposta.append("A: ");
							resposta.append(Query.oneSolution("probabilidadeSangueNome('"+tfPai.getText() +"','"+ tfMae.getText()+"','A'"+",X, Resposta, Id).").get("X"));
							resposta.append("%\n");
							resposta.append("B: ");
							resposta.append(Query.oneSolution("probabilidadeSangueNome('"+tfPai.getText()+"','"+tfMae.getText()+"','B',X, Resposta, Id).").get("X"));
							resposta.append("%\n");
							resposta.append("AB: ");
							resposta.append(Query.oneSolution("probabilidadeSangueNome('"+tfPai.getText()+"','"+tfMae.getText()+"','AB',X, Resposta, Id).").get("X"));
							resposta.append("%\n");
							resposta.append("O: ");
							resposta.append(Query.oneSolution("probabilidadeSangueNome('"+tfPai.getText()+"','"+tfMae.getText()+"','O',X, Resposta, Id).").get("X"));
							resposta.append("%\n");
							tfPai.setText("");
							tfMae.setText("");
						}else{
							if(id.toString().equals("2") || id.toString().equals("5")){
								tfPai.setText("");
								resposta.append(r);
							}else if(id.toString().equals("3") || id.toString().equals("4")){
								tfMae.setText("");
								resposta.append(r);
							}
						}
						areaResposta.setText(resposta.toString());
						
					} else if(rdbtnPele.isSelected()){
						Query q = new Query("probabilidadePeleNome('"+tfPai.getText() +"','"+ tfMae.getText()+"',branco"+",X, Resposta, Id).");
						Term r = q.oneSolution().get("Resposta");
						Term id = q.oneSolution().get("Id");
						if(r.isVariable()){
							resposta.append("Branco: ");
						
							//ajeitar essas query => Estudar C:\Program Files\swipl\doc\packages\jpl\java_api
							resposta.append(Query.oneSolution("probabilidadePeleNome('"+tfPai.getText() +"','"+ tfMae.getText()+"',branco"+",X, Resposta,Id).").get("X"));
							resposta.append("%\n");
							resposta.append("Moreno Claro: ");
							resposta.append(Query.oneSolution("probabilidadePeleNome('"+tfPai.getText()+"','"+tfMae.getText()+"','moreno-claro',X, Resposta, Id).").get("X"));
							resposta.append("%\n");
							resposta.append("Moreno: ");
							resposta.append(Query.oneSolution("probabilidadePeleNome('"+tfPai.getText()+"','"+tfMae.getText()+"','moreno',X, Resposta, Id).").get("X"));
							resposta.append("%\n");
							resposta.append("Moreno Escuro: ");
							resposta.append(Query.oneSolution("probabilidadePeleNome('"+tfPai.getText()+"','"+tfMae.getText()+"','moreno-escuro',X, Resposta, Id).").get("X"));
							resposta.append("%\n");
							resposta.append("Negro: ");
							resposta.append(Query.oneSolution("probabilidadePeleNome('"+tfPai.getText()+"','"+tfMae.getText()+"',preto"+",X, Resposta, Id).").get("X"));
							resposta.append("%\n");
							//resposta.append(Query.oneSolution("probabilidadePeleTodos("+tfPai.getText()+","+tfMae.getText()+",X).").get("X"));
							tfPai.setText("");
							tfMae.setText("");
						}else{
							if(id.toString().equals("2") || id.toString().equals("5")){
								tfPai.setText("");
								resposta.append(r);
							}else if(id.toString().equals("3") || id.toString().equals("4")){
								tfMae.setText("");
								resposta.append(r);
							}
						}
						//resposta.append(Query.oneSolution("teste(X).").get("X"));
						areaResposta.setText(resposta.toString());
					} else if(rdbtnOlhos.isSelected()){
						Query q = new Query("probabilidadeOlhoNome('"+tfPai.getText() +"','"+ tfMae.getText()+"','castanho'"+",X, Resposta, Id).");
						Term r = q.oneSolution().get("Resposta");
						Term id = q.oneSolution().get("Id");
						if(r.isVariable()){
							
							resposta.append("castanho: ");
							resposta.append(Query.oneSolution("probabilidadeOlhoNome('"+tfPai.getText() +"','"+ tfMae.getText()+"','castanho'"+",X, Resposta, Id).").get("X"));
							resposta.append("%\n");
							resposta.append("verde: ");
							resposta.append(Query.oneSolution("probabilidadeOlhoNome('"+tfPai.getText()+"','"+tfMae.getText()+"','verde',X,Resposta, Id).").get("X"));
							resposta.append("%\n");
							resposta.append("azul: ");
							resposta.append(Query.oneSolution("probabilidadeOlhoNome('"+tfPai.getText()+"','"+tfMae.getText()+"','azul',X, Resposta, Id).").get("X"));
							resposta.append("%\n");
							tfPai.setText("");
							tfMae.setText("");
						}else{
							if(id.toString().equals("2") || id.toString().equals("5")){
								tfPai.setText("");
								resposta.append(r);
							}else if(id.toString().equals("3") || id.toString().equals("4")){
								tfMae.setText("");
								resposta.append(r);
							}
						}
						areaResposta.setText(resposta.toString());
					} else {
						JOptionPane.showMessageDialog(null, "Selecione uma opção");
					}
				}
				
				//teste
				//resposta.append("RESULTADO\n\n");
				//resposta.append(Query.oneSolution("teste2(X).").get("X"));
				
				
			}
		});
										
	}
}
