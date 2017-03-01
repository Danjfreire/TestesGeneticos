package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class TelaTeste extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
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
		setBounds(100, 100, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPessoa = new JMenu("Pessoa");
		menuBar.add(mnPessoa);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.setBackground(Color.WHITE);
		mnPessoa.add(mntmCadastrar);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 165, 554, 374);
		contentPane.add(scrollPane);

		JTextPane areaResposta = new JTextPane();
		scrollPane.setViewportView(areaResposta);
		
		ButtonGroup grupo = new ButtonGroup();
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Consulta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(199, 21, 133)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(574, 165, 210, 374);
		contentPane.add(panel);
		panel.setLayout(null);
										
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 182, 190, 126);
		panel.add(panel_1);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Selecionar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(199, 21, 133)));
		panel_1.setLayout(null);
										
		JRadioButton rdbtnCalvice = new JRadioButton("Calvice");
		rdbtnCalvice.setBackground(Color.WHITE);
		rdbtnCalvice.setBounds(6, 18, 74, 23);
		panel_1.add(rdbtnCalvice);
		grupo.add(rdbtnCalvice);
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
									
		textField_2 = new JTextField();
		textField_2.setBounds(56, 52, 124, 20);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
									
		textField_1 = new JTextField();
		textField_1.setBounds(56, 21, 124, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
								
		textField = new JTextField();
		textField.setBounds(56, 83, 124, 20);
		panel_2.add(textField);
		textField.setColumns(10);
									
		JLabel lblIndividuo = new JLabel("Pessoa:");
		lblIndividuo.setBounds(10, 24, 68, 14);
		panel_2.add(lblIndividuo);
									
		JLabel lblMe = new JLabel("M\u00E3e:");
		lblMe.setBounds(10, 55, 46, 14);
		panel_2.add(lblMe);
									
		JLabel lblPai = new JLabel("Pai:");
		lblPai.setBounds(10, 86, 46, 14);
		panel_2.add(lblPai);
										
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u00C1rvore", "Descendentes", "Compatibilidade", "Probabilidade"}));
		comboBox.setBounds(10, 26, 190, 20);
		panel.add(comboBox);
										
		JButton btnExecutar = new JButton("Executar");
		btnExecutar.setBackground(new Color(199, 21, 133));
		btnExecutar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExecutar.setBounds(10, 319, 190, 44);
		panel.add(btnExecutar);
										
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaTeste.class.getResource("/imagens/seqcore_slider_img_resized.png")));
		lblNewLabel.setBounds(10, 11, 774, 143);
		contentPane.add(lblNewLabel);
										
	}

	
}
