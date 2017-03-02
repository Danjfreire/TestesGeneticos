package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;

import java.awt.Color;
import javax.swing.JMenuBar;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class TelaIndividuo extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaIndividuo frame = new TelaIndividuo();
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
	public TelaIndividuo() {
		setTitle("Novo Indiv\u00EDduo");
		setBackground(Color.WHITE);
		setBounds((int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 460)/2), (int)((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 521)/2), 460, 521);

		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnSangue = new JMenu("Sangue");
		menuBar.add(mnSangue);
		
		JMenu mnTipoA = new JMenu("Tipo A");
		mnSangue.add(mnTipoA);
		
		JMenuItem mntmiaia = new JMenuItem("['IA','IA']");
		mntmiaia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setEditable(true);
				textField.setText(mntmiaia.getText());
				textField.setEditable(false);
			}
		});
		mnTipoA.add(mntmiaia);
		
		JMenuItem mntmiai = new JMenuItem("['IA','i']");
		mntmiai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setEditable(true);
				textField.setText(mntmiai.getText());
				textField.setEditable(false);
			}
		});
		mnTipoA.add(mntmiai);
		
		JMenu mnTipoB = new JMenu("Tipo B");
		mnSangue.add(mnTipoB);
		
		JMenuItem mntmibib = new JMenuItem("['IB','IB']");
		mntmibib.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setEditable(true);
				textField.setText(mntmibib.getText());
				textField.setEditable(false);
			}
		});
		mnTipoB.add(mntmibib);
		
		JMenuItem mntmibi = new JMenuItem("['IB','i']");
		mntmibi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setEditable(true);
				textField.setText(mntmibi.getText());
				textField.setEditable(false);
			}
		});
		mnTipoB.add(mntmibi);
		
		JMenu mnTipoAb = new JMenu("Tipo AB");
		mnSangue.add(mnTipoAb);
		
		JMenuItem mntmiaib = new JMenuItem("['IA','IB']");
		mntmiaib.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setEditable(true);
				textField.setText(mntmiaib.getText());
				textField.setEditable(false);
			}
		});
		mnTipoAb.add(mntmiaib);
		
		JMenu mnTipoO = new JMenu("Tipo O");
		mnSangue.add(mnTipoO);
		
		JMenuItem mntmii = new JMenuItem("['i','i']");
		mntmii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setEditable(true);
				textField.setText(mntmii.getText());
				textField.setEditable(false);
			}
		});
		mnTipoO.add(mntmii);
		
		JMenu mnCalvicie = new JMenu("Calv\u00EDcie");
		menuBar.add(mnCalvicie);
		
		JMenu mnSim = new JMenu("Sim");
		JMenu mnNao = new JMenu("Não");
		mnCalvicie.add(mnSim);
		mnCalvicie.add(mnNao);
		
		JMenu mnMasculino_1 = new JMenu("masculino");
		JMenu mnMasculino_2 = new JMenu("masculino");
		mnSim.add(mnMasculino_1);
		mnNao.add(mnMasculino_2);
		
		JMenuItem mntmcc_8 = new JMenuItem("'C','C'");
		mntmcc_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setEditable(true);
				textField_1.setText("["+ mntmcc_8.getText() + ",masculino]");
				textField_1.setEditable(false);
			}
		});
		mnMasculino_1.add(mntmcc_8);
		
		JMenuItem mntmcc_9 = new JMenuItem("'C','c'");
		mntmcc_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setEditable(true);
				textField_1.setText("["+ mntmcc_9.getText() + ",masculino]");
				textField_1.setEditable(false);
			}
		});
		mnMasculino_1.add(mntmcc_9);
		
		JMenuItem mntmcc_11 = new JMenuItem("'c','c'");
		mntmcc_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setEditable(true);
				textField_1.setText("["+ mntmcc_11.getText() + ",masculino]");
				textField_1.setEditable(false);
			}
		});
		mnMasculino_2.add(mntmcc_11);
		
		JMenu mnFeminino_1 = new JMenu("feminino");
		JMenu mnFeminino_2 = new JMenu("feminino");
		mnSim.add(mnFeminino_1);
		mnNao.add(mnFeminino_2);
		
		JMenuItem mntmcc_12 = new JMenuItem("'C','C'");
		mntmcc_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setEditable(true);
				textField_1.setText("["+ mntmcc_12.getText() + ",feminino]");
				textField_1.setEditable(false);
			}
		});
		mnFeminino_1.add(mntmcc_12);
		
		JMenuItem mntmcc_13 = new JMenuItem("'C','c'");
		mntmcc_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setEditable(true);
				textField_1.setText("["+ mntmcc_13.getText() + ",feminino]");
				textField_1.setEditable(false);
			}
		});
		mnFeminino_2.add(mntmcc_13);
		
		JMenuItem mntmcc_14 = new JMenuItem("'c','c'");
		mntmcc_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setEditable(true);
				textField_1.setText("["+ mntmcc_14.getText() + ",feminino]");
				textField_1.setEditable(false);
			}
		});
		mnFeminino_2.add(mntmcc_14);
		
		JMenu mnOlho = new JMenu("Olho");
		menuBar.add(mnOlho);
		
		JMenu mnCastanho = new JMenu("Castanho");
		mnOlho.add(mnCastanho);
		
		JMenuItem mntmbmbmgvgv = new JMenuItem("['BM','BM','GV','GV']");
		mntmbmbmgvgv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setEditable(true);
				textField_2.setText(mntmbmbmgvgv.getText());
				textField_2.setEditable(false);
			}
		});
		mnCastanho.add(mntmbmbmgvgv);
		
		JMenuItem mntmbmbmgvga = new JMenuItem("['BM','BM','GV','GA']");
		mntmbmbmgvga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setEditable(true);
				textField_2.setText(mntmbmbmgvga.getText());
				textField_2.setEditable(false);
			}
		});
		mnCastanho.add(mntmbmbmgvga);
		
		JMenuItem mntmbmbmgaga = new JMenuItem("['BM','BM','GA','GA']");
		mntmbmbmgaga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setEditable(true);
				textField_2.setText(mntmbmbmgaga.getText());
				textField_2.setEditable(false);
			}
		});
		mnCastanho.add(mntmbmbmgaga);
		
		JMenuItem mntmbmbagvgv = new JMenuItem("['BM','BA','GV','GV']");
		mntmbmbagvgv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setEditable(true);
				textField_2.setText(mntmbmbagvgv.getText());
				textField_2.setEditable(false);
			}
		});
		mnCastanho.add(mntmbmbagvgv);
		
		JMenuItem mntmbmbagvga = new JMenuItem("['BM','BA','GV','GA']");
		mntmbmbagvga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setEditable(true);
				textField_2.setText(mntmbmbagvga.getText());
				textField_2.setEditable(false);
			}
		});
		mnCastanho.add(mntmbmbagvga);
		
		JMenuItem mntmbmbagaga = new JMenuItem("['BM','BA','GA','GA']");
		mntmbmbagaga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setEditable(true);
				textField_2.setText(mntmbmbagaga.getText());
				textField_2.setEditable(false);
			}
		});
		mnCastanho.add(mntmbmbagaga);
		
		JMenu mnVerde = new JMenu("Verde");
		mnOlho.add(mnVerde);
		
		JMenuItem mntmbabagvgv = new JMenuItem("['BA','BA','GV','GV']");
		mntmbabagvgv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setEditable(true);
				textField_2.setText(mntmbabagvgv.getText());
				textField_2.setEditable(false);
			}
		});
		mnVerde.add(mntmbabagvgv);
		
		JMenuItem mntmbabagvga = new JMenuItem("['BA','BA','GV','GA']");
		mntmbabagvga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setEditable(true);
				textField_2.setText(mntmbabagvga.getText());
				textField_2.setEditable(false);
			}
		});
		mnVerde.add(mntmbabagvga);
		
		JMenu mnAzul = new JMenu("Azul");
		mnOlho.add(mnAzul);
		
		JMenuItem mntmbabagaga = new JMenuItem("['BA','BA','GA','GA']");
		mntmbabagaga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setEditable(true);
				textField_2.setText(mntmbabagaga.getText());
				textField_2.setEditable(false);
			}
		});
		mnAzul.add(mntmbabagaga);
		
		JMenu mnPele = new JMenu("Pele");
		menuBar.add(mnPele);
		
		JMenu mnPreto = new JMenu("Preto");
		mnPele.add(mnPreto);
		
		JMenuItem mntmaabb = new JMenuItem("['A','A','B','B']");
		mntmaabb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_3.setEditable(true);
				textField_3.setText(mntmaabb.getText());
				textField_3.setEditable(false);
			}
		});
		mnPreto.add(mntmaabb);
		
		JMenu mnMorenoEscuro = new JMenu("Moreno escuro");
		mnPele.add(mnMorenoEscuro);
		
		JMenuItem mntmaabb_1 = new JMenuItem("['A','A','B','b']");
		mntmaabb_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_3.setEditable(true);
				textField_3.setText(mntmaabb_1.getText());
				textField_3.setEditable(false);
			}
		});
		mnMorenoEscuro.add(mntmaabb_1);
		
		JMenuItem mntmaabb_2 = new JMenuItem("['A','a','B','B']");
		mntmaabb_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_3.setEditable(true);
				textField_3.setText(mntmaabb_2.getText());
				textField_3.setEditable(false);
			}
		});
		mnMorenoEscuro.add(mntmaabb_2);
		
		JMenu mnMoreno = new JMenu("Moreno");
		mnPele.add(mnMoreno);
		
		JMenuItem mntmaabb_3 = new JMenuItem("['A','A','b','b']");
		mntmaabb_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_3.setEditable(true);
				textField_3.setText(mntmaabb_3.getText());
				textField_3.setEditable(false);
			}
		});
		mnMoreno.add(mntmaabb_3);
		
		JMenuItem mntmaabb_4 = new JMenuItem("['A','a','B','b']");
		mntmaabb_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_3.setEditable(true);
				textField_3.setText(mntmaabb_4.getText());
				textField_3.setEditable(false);
			}
		});
		mnMoreno.add(mntmaabb_4);
		
		JMenuItem mntmaabb_5 = new JMenuItem("['a','a','B','B']");
		mntmaabb_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_3.setEditable(true);
				textField_3.setText(mntmaabb_5.getText());
				textField_3.setEditable(false);
			}
		});
		mnMoreno.add(mntmaabb_5);
		
		JMenu mnMorenoClaro = new JMenu("Moreno claro");
		mnPele.add(mnMorenoClaro);
		
		JMenuItem mntmaabb_6 = new JMenuItem("['A','a','b','b']");
		mntmaabb_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_3.setEditable(true);
				textField_3.setText(mntmaabb_6.getText());
				textField_3.setEditable(false);
			}
		});
		mnMorenoClaro.add(mntmaabb_6);
		
		JMenuItem mntmaabb_7 = new JMenuItem("['a','a','B','b']");
		mntmaabb_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_3.setEditable(true);
				textField_3.setText(mntmaabb_7.getText());
				textField_3.setEditable(false);
			}
		});
		mnMorenoClaro.add(mntmaabb_7);
		
		JMenu mnBranco = new JMenu("Branco");
		mnPele.add(mnBranco);
		
		JMenuItem mntmaabb_8 = new JMenuItem("['a','a','b','b']");
		mntmaabb_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_3.setEditable(true);
				textField_3.setText(mntmaabb_8.getText());
				textField_3.setEditable(false);
			}
		});
		
		mnBranco.add(mntmaabb_8);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCadastrar.setBounds(153, 384, 143, 42);
		contentPane.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textNome.getText().isEmpty() || textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_2.getText().isEmpty() || textField_3.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				else{
				inserirPessoaProlog();
				dispose();
				}
			}
		});
		
		JLabel lblNovoIndivduo = new JLabel("Novo indiv\u00EDduo");
		lblNovoIndivduo.setForeground(new Color(199, 21, 133));
		lblNovoIndivduo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNovoIndivduo.setBounds(10, 11, 109, 20);
		contentPane.add(lblNovoIndivduo);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Nome", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(199, 21, 133)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 46, 424, 75);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textNome = new JTextField();
		textNome.setBounds(21, 31, 383, 20);
		panel.add(textNome);
		textNome.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "Genes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(199, 21, 133)));
		panel_1.setBounds(10, 132, 424, 241);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sangue:");
		lblNewLabel.setBounds(10, 34, 46, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Olho");
		lblNewLabel_1.setBounds(10, 136, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblCalvcie = new JLabel("Calv\u00EDcie:");
		lblCalvcie.setBounds(10, 84, 56, 14);
		panel_1.add(lblCalvcie);
		
		JLabel lblNewLabel_2 = new JLabel("Pele");
		lblNewLabel_2.setBounds(10, 191, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(66, 31, 116, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(66, 81, 116, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(66, 133, 116, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(66, 188, 116, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
	}
	
	private void inserirPessoaProlog(){
		File temp = new File("");
		String caminho =  temp.getAbsolutePath();
		String definitivo = caminho.replace("\\", "\\\\");
		String caminhoTXT = definitivo + "\\\\pessoas.txt";
		String genes = "[" + textField.getText() + "," + textField_1.getText() + "," + textField_2.getText() + "," + textField_3.getText() + "]";
		String proposicao = "pessoa('" + textNome.getText() + "'," + genes + ")";
		String inserirPessoa = "inserirPessoa(" + proposicao + ",'" + caminhoTXT + "')";
		System.out.println(inserirPessoa);		
		Query q1 = new Query(inserirPessoa);
		System.out.println( "consult " + (q1.hasSolution() ? "succeeded" : "failed"));
	}
}
