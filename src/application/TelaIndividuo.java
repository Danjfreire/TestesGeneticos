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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class TelaIndividuo extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNome = new JTextField();
		textNome.setBounds(10, 67, 160, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(10, 42, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblSangue = new JLabel("Sangue");
		lblSangue.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSangue.setBounds(10, 119, 46, 14);
		contentPane.add(lblSangue);
		ButtonGroup grupoSangue = new ButtonGroup();
		
		JRadioButton rdbtnA1 = new JRadioButton("A(IA,IA)");
		rdbtnA1.setBounds(10, 140, 81, 23);
		contentPane.add(rdbtnA1);
		grupoSangue.add(rdbtnA1);
		
		JRadioButton rdbtnA2 = new JRadioButton("A(IA,i)");
		rdbtnA2.setBounds(10, 166, 81, 23);
		contentPane.add(rdbtnA2);
		grupoSangue.add(rdbtnA2);
		
		JRadioButton rdbtnB1 = new JRadioButton("B(IB,IB)");
		rdbtnB1.setBounds(187, 140, 71, 23);
		contentPane.add(rdbtnB1);
		grupoSangue.add(rdbtnB1);
		
		JRadioButton rdbtnB2 = new JRadioButton("B(IB,i)");
		rdbtnB2.setBounds(187, 166, 81, 23);
		contentPane.add(rdbtnB2);
		grupoSangue.add(rdbtnB2);
		
		JRadioButton rdbtnAB1 = new JRadioButton("AB(IA,IB)");
		rdbtnAB1.setBounds(93, 140, 71, 23);
		contentPane.add(rdbtnAB1);
		grupoSangue.add(rdbtnAB1);
		
		JRadioButton rdbtnAB2 = new JRadioButton("AB(IB,IA)");
		rdbtnAB2.setBounds(93, 166, 71, 23);
		contentPane.add(rdbtnAB2);
		grupoSangue.add(rdbtnAB2);
		
		JRadioButton rdbtnO = new JRadioButton("O(i,i)");
		rdbtnO.setBounds(277, 140, 109, 23);
		contentPane.add(rdbtnO);
		grupoSangue.add(rdbtnO);
		
		JLabel lblCalvice = new JLabel("Calvice");
		lblCalvice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCalvice.setBounds(10, 196, 46, 14);
		contentPane.add(lblCalvice);
		
		JComboBox comboCalvice = new JComboBox();
		comboCalvice.setModel(new DefaultComboBoxModel(new String[] {"calvo(C,C,masculino)\t", "calva(C,C,feminino)", "calvo(C,c,masculino)", "calvo(c,C,masculino)", "n\u00E3o calva(C,c,feminino)", "n\u00E3o calva(c,C,feminino)", "n\u00E3o calvo(c,c,masculino)", "n\u00E3o calva(c,c,feminino)"}));
		comboCalvice.setBounds(10, 221, 160, 20);
		contentPane.add(comboCalvice);
		
		JLabel lblNewLabel = new JLabel("Olhos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 261, 46, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox comboOlhos = new JComboBox();
		comboOlhos.setModel(new DefaultComboBoxModel(new String[] {"castanho(BM,_,_,_)", "castanho(_,BM,_,_)", "verde(BA,BA,GV,_)", "verde(BA,BA,_,GV)", "azul(BA,BA,GA,GA)"}));
		comboOlhos.setBounds(10, 286, 160, 20);
		contentPane.add(comboOlhos);
		
		JComboBox comboPele = new JComboBox();
		comboPele.setModel(new DefaultComboBoxModel(new String[] {"negra(A,A,B,B)", "morena escura(A,A,B,b)", "morena escura(A,A,b,B)", "morena escura(A,a,B,B)", "morena escura(a,A,B,B)", "morena(A,A,b,b)", "morena(A,a,B,b)", "morena(A,a,b,B)", "morena(a,A,b,B)", "morena(a,A,B,b)", "morena(a,a,B,B)", "morena clara(A,a,b,b)", "morena clara(a,A,b,b)", "morena clara(a,a,B,b)", "morena clara(a,a,b,B)", "branca(a,a,b,b)", ""}));
		comboPele.setBounds(10, 346, 160, 20);
		contentPane.add(comboPele);
		
		JLabel lblPele = new JLabel("Pele");
		lblPele.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPele.setBounds(10, 321, 46, 14);
		contentPane.add(lblPele);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(243, 404, 143, 42);
		contentPane.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//código de cadastro
				dispose();
				
			}
		});
		
		JLabel lblNovoIndivduo = new JLabel("Novo indiv\u00EDduo");
		lblNovoIndivduo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNovoIndivduo.setBounds(10, 11, 109, 20);
		contentPane.add(lblNovoIndivduo);
		
	}
}
