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

public class TelaTeste extends JFrame {

	private JPanel contentPane;
	private JTextField tfPai;
	private JTextField tfPessoa;
	private JTextField tfMae;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaTeste frame = new TelaTeste();
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
	public TelaTeste() {
		setResizable(false);
		setTitle("Projeto G\u00EAneses");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 809)/2), (int)((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 600)/2), 800, 600);
		
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
		scrollPane.setBounds(10, 165, 554, 374);
		contentPane.add(scrollPane);
		

		JTextArea areaResposta = new JTextArea();
		areaResposta.setFont(new Font("Courier New", Font.BOLD, 13));
		scrollPane.setViewportView(areaResposta);
		
		ButtonGroup grupo = new ButtonGroup();
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Consulta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(199, 21, 133)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(574, 165, 210, 374);
		contentPane.add(panel);
		panel.setLayout(null);
										
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 182, 90, 126);
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
		btnExecutar.setBounds(10, 319, 190, 44);
		panel.add(btnExecutar);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new TitledBorder(null, "N\u00EDveis", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(199, 21, 133)));
		panel_3.setBounds(110, 182, 90, 126);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(10, 21, 74, 20);
		panel_3.add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		btnExecutar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				StringBuffer resposta = new StringBuffer();
				if(comboBox.getSelectedItem().toString().equals("\u00C1rvore")){
					//usar tfPessoa.getText()
					String r;
					if(tfPessoa.getText().isEmpty())
						JOptionPane.showMessageDialog(null, "Preencha o campo 'Pessoa'");
					else{
						resposta = gerarArvoreProlog("arvoreGenealogica('"+ tfPessoa.getText() +"', Arvore,"+ comboBox_1.getSelectedItem() +")");
						areaResposta.setText(resposta.toString());
						
						//areaResposta.
					}
						
				} else if(comboBox.getSelectedItem().toString().equals("Descendentes")){
					//usar tfMae.getText() e tfPai.getText()
					if(tfMae.getText().isEmpty() || tfPai.getText().isEmpty())
						JOptionPane.showMessageDialog(null, "Preencha os campos 'Pai' e 'Mãe'");
					//resposta.append(Query.oneSolution("").get("X"));
					
				} else if(comboBox.getSelectedItem().toString().equals("Compatibilidade")){
					//usar tfMae.getText() e tfPai.getText()
					if(tfMae.getText().isEmpty() || tfPai.getText().isEmpty()/* || tfPessoa.getText().isEmpty()*/)
						JOptionPane.showMessageDialog(null, "Preencha todos os campos'");
					else{
						resposta.append("RESULTADO\n\n");
						if((Query.hasSolution("compatibilidade('"+tfPai.getText()+"', '"+tfMae.getText()+
								"', '"+tfPessoa.getText()+"')."))){
							resposta.append("Compativel");
						}else
							resposta.append("Incompatível");
						areaResposta.setText(resposta.toString());
					}
					
				} else if(comboBox.getSelectedItem().toString().equals("Probabilidade")){
					//usar tfMae.getText() e tfPai.getText()
					if(tfMae.getText().isEmpty() || tfPai.getText().isEmpty())
						JOptionPane.showMessageDialog(null, "Preencha os campos 'Pai' e 'Mãe'");
					
					if(rdbtnCalvicie.isSelected()){
						resposta.append("calvo: ");
						Query q = new Query("probabilidadeCalvicieNome('"+tfPai.getText() +"','"+ tfMae.getText()+"','sim'"+",X).");
						resposta.append(Query.oneSolution("probabilidadeCalvicieNome('"+tfPai.getText() +"','"+ tfMae.getText()+"','sim'"+",X).").get("X"));
						resposta.append("%\n");
						resposta.append("não calvo: ");
						resposta.append(Query.oneSolution("probabilidadeCalvicieNome('"+tfPai.getText()+"','"+tfMae.getText()+"','não',X).").get("X"));
						resposta.append("%\n");
						
						areaResposta.setText(resposta.toString());
						
					} else if(rdbtnSangue.isSelected()){
						resposta.append("A: ");
						resposta.append(Query.oneSolution("probabilidadeSangueNome('"+tfPai.getText() +"','"+ tfMae.getText()+"','A'"+",X).").get("X"));
						resposta.append("%\n");
						resposta.append("B: ");
						resposta.append(Query.oneSolution("probabilidadeSangueNome('"+tfPai.getText()+"','"+tfMae.getText()+"','B',X).").get("X"));
						resposta.append("%\n");
						resposta.append("AB: ");
						resposta.append(Query.oneSolution("probabilidadeSangueNome('"+tfPai.getText()+"','"+tfMae.getText()+"','AB',X).").get("X"));
						resposta.append("%\n");
						resposta.append("O: ");
						resposta.append(Query.oneSolution("probabilidadeSangueNome('"+tfPai.getText()+"','"+tfMae.getText()+"','O',X).").get("X"));
						resposta.append("%\n");
						
						areaResposta.setText(resposta.toString());
						
					} else if(rdbtnPele.isSelected()){
						resposta.append("Branco: ");
					
						//ajeitar essas query => Estudar C:\Program Files\swipl\doc\packages\jpl\java_api
						resposta.append(Query.oneSolution("probabilidadePeleNome('"+tfPai.getText() +"','"+ tfMae.getText()+"',branco"+",X).").get("X"));
						resposta.append("%\n");
						resposta.append("Moreno Claro: ");
						resposta.append(Query.oneSolution("probabilidadePeleNome('"+tfPai.getText()+"','"+tfMae.getText()+"','moreno-claro',X).").get("X"));
						resposta.append("%\n");
						resposta.append("Moreno: ");
						resposta.append(Query.oneSolution("probabilidadePeleNome('"+tfPai.getText()+"','"+tfMae.getText()+"','moreno',X).").get("X"));
						resposta.append("%\n");
						resposta.append("Moreno Escuro: ");
						resposta.append(Query.oneSolution("probabilidadePeleNome('"+tfPai.getText()+"','"+tfMae.getText()+"','moreno-escuro',X).").get("X"));
						resposta.append("%\n");
						resposta.append("Negro: ");
						resposta.append(Query.oneSolution("probabilidadePeleNome('"+tfPai.getText()+"','"+tfMae.getText()+"',preto"+",X).").get("X"));
						resposta.append("%\n");
						//resposta.append(Query.oneSolution("probabilidadePeleTodos("+tfPai.getText()+","+tfMae.getText()+",X).").get("X"));
						
						//resposta.append(Query.oneSolution("teste(X).").get("X"));
						areaResposta.setText(resposta.toString());
					} else if(rdbtnOlhos.isSelected()){
						resposta.append("castanho: ");
						resposta.append(Query.oneSolution("probabilidadeOlhoNome('"+tfPai.getText() +"','"+ tfMae.getText()+"','castanho'"+",X).").get("X"));
						resposta.append("%\n");
						resposta.append("verde: ");
						resposta.append(Query.oneSolution("probabilidadeOlhoNome('"+tfPai.getText()+"','"+tfMae.getText()+"','verde',X).").get("X"));
						resposta.append("%\n");
						resposta.append("azul: ");
						resposta.append(Query.oneSolution("probabilidadeOlhoNome('"+tfPai.getText()+"','"+tfMae.getText()+"','azul',X).").get("X"));
						resposta.append("%\n");
						
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
										
		JLabel lblNewLabel = new JLabel("lul");
		lblNewLabel.setIcon(new ImageIcon(TelaTeste.class.getResource("/imagens/seqcore_slider_img_resized.png")));
		lblNewLabel.setBounds(10, 11, 774, 143);
		contentPane.add(lblNewLabel);
										
	}
	
	private StringBuffer gerarArvoreProlog(String consulta){
		System.out.println(consulta);
		StringBuffer resposta = new StringBuffer();
		Query q = new Query(consulta);
		Term t = q.oneSolution().get("Arvore");
	
		System.out.println(t);
		String[] elementos = Util.atomListToStringArray(t);
		
		int totalElem = elementos.length;
		int fator = (totalElem + 11)/12;
		
		int nivelMax = (int)(Math.log(fator)/Math.log(2)+1e-10);
		
		int i = 1;
		int numLinha = (elementos.length + 11) / 2;
		int temp = numLinha / 2;
		int j = 0;
		
		int espacos = 0;
		int tabulacao = 0;
		int espacoEntre =2;
		int espacoPM =1;
		int tm;
		int pm;
		int em;
		int inicio = 0;
		int numeroCasal = ((int)(Math.pow(2, nivelMax)) - 2)/2;
		int f;
		int contl;
		
		while(i < nivelMax){
			tm = 0;
			while(tm < (tabulacao + 6)){
				resposta.append(" ");
				tm++;
			}
			f = 0;
			contl = (int)(Math.pow(2, (nivelMax - 1 - i)));
			while(f < contl){
				resposta.append("pai " + String.format("%02d", numeroCasal));
				pm = 0;
				while(pm < espacoPM + 12){
					resposta.append(" ");
					pm++;
				}
				resposta.append("mãe " + String.format("%02d", numeroCasal));
				em = 0;
				while(em < espacoEntre + 12){
					resposta.append(" ");
					em++;
				}
				numeroCasal--;
				f++;
			}
			resposta.append("\n");
			tm =0;
			while(tm < tabulacao){
				resposta.append(" ");
				tm++;
			}
			while(j < numLinha){
				if((j % 24 == 0) && (j != inicio)){
					em = 0;
					while(em < espacoEntre){
						resposta.append(" ");
						em++;
					}
				}
				else if((j % 12 == 0) && (j != inicio)){
					pm = 0;
					while(pm < espacoPM){
						resposta.append(" ");
						pm++;
					}
				}
				resposta.append(elementos[j]);
				j++;
			}
			inicio = j;
			
			espacos = ((int)(Math.pow(2, (nivelMax-1)))*1)/2 + (((int)(Math.pow(2, (nivelMax-1)))/2)-1)*2 + 
					(int)(Math.pow(2, (nivelMax-1))) * 18 - (((int)(Math.pow(2, (nivelMax -1)))/(int)(Math.pow(2,i))) * 18);
			
			resposta.append("\n");
			tabulacao = tabulacao + (18 + espacoPM)/2;
			espacoPM = espacoEntre + 18 + espacoPM;
			if(i < (nivelMax -1))
				espacoEntre = (espacos - 2*tabulacao) / (((int)(Math.pow(2, (nivelMax -1)))/(int)(Math.pow(2,i))) - 1);
			
			
			resposta.append("\n");
			numLinha = temp + numLinha;
			temp = temp / 2;
			i++;
		}
		tm = 0;
		i = elementos.length - 1;
		while(tm < (tabulacao - (elementos[i].length() - 18)/2)){
			resposta.append(" ");
			tm++;
		}
		resposta.append(elementos[i]);
		resposta.append("\n");
		tm = 0;
		while(tm < tabulacao){
			resposta.append(" ");
			tm++;
		}
		while(j < numLinha){
			resposta.append(elementos[j]);
			j++;
		}
		resposta.append("\n");
		resposta.append("\n");
		
		return resposta;
	}
}
