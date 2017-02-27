package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ugos.jiprolog.engine.JIPEngine;
import com.ugos.jiprolog.engine.JIPQuery;
import com.ugos.jiprolog.engine.JIPSyntaxErrorException;
import com.ugos.jiprolog.engine.JIPTerm;
import com.ugos.jiprolog.engine.JIPVariable;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.DropMode;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

public class TelaTeste extends JFrame {

	private JPanel contentPane;
	JIPEngine pg = new JIPEngine();

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

		pg.consultFile("analise_genetica.pl");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 11, 533, 439);
		contentPane.add(scrollPane);

		JTextPane areaResposta = new JTextPane();
		scrollPane.setViewportView(areaResposta);

		JTextArea areaBusca = new JTextArea();
		areaBusca.setLineWrap(true);
		areaBusca.setBounds(587, 11, 171, 81);
		contentPane.add(areaBusca);


		JButton btnArvore = new JButton("Arvore");
		btnArvore.setBounds(609, 137, 127, 23);
		contentPane.add(btnArvore);
		btnArvore.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {

				String busca = "arvoreGenealogica("+areaBusca.getText()+").";
				areaResposta.setText(consultar(busca));
			}	
		});

		JButton btnDescendentes = new JButton("Descendentes");
		btnDescendentes.setBounds(609, 171, 127, 23);
		contentPane.add(btnDescendentes);
		btnDescendentes.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {

				String busca = "descendentes("+areaBusca.getText()+").";
				areaResposta.setText(consultar(busca));
			}	
		});

		JButton btnCompatibilidade = new JButton("Compatibilidade");
		btnCompatibilidade.setBounds(609, 103, 127, 23);
		contentPane.add(btnCompatibilidade);
		btnCompatibilidade.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {

				String busca = ""; //falta
				areaResposta.setText(consultar(busca));
			}			
		});

	
		JButton btnNovoindividuo = new JButton("Novo individuo");
		btnNovoindividuo.setBounds(609, 403, 149, 32);
		contentPane.add(btnNovoindividuo);
		btnNovoindividuo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaIndividuo tela = new TelaIndividuo();
				tela.setVisible(true);
				
			}
		});
		
		ButtonGroup grupo = new ButtonGroup();
		JRadioButton rdbtnSangue = new JRadioButton("Sangue");
		rdbtnSangue.setBounds(609, 265, 109, 23);
		contentPane.add(rdbtnSangue);
		grupo.add(rdbtnSangue);
		
		JRadioButton rdbtnPele = new JRadioButton("Pele\r\n");
		rdbtnPele.setBounds(609, 291, 109, 23);
		contentPane.add(rdbtnPele);
		grupo.add(rdbtnPele);
		
		JRadioButton rdbtnCalvice = new JRadioButton("Calvice");
		rdbtnCalvice.setBounds(609, 239, 109, 23);
		contentPane.add(rdbtnCalvice);
		grupo.add(rdbtnCalvice);
		
		JRadioButton rdbtnOlhos = new JRadioButton("Olhos\r\n");
		rdbtnOlhos.setBounds(609, 317, 109, 23);
		contentPane.add(rdbtnOlhos);
		grupo.add(rdbtnOlhos);
		
		JLabel lblProbabilidade = new JLabel("Probabilidade");
		lblProbabilidade.setBounds(609, 205, 94, 27);
		contentPane.add(lblProbabilidade);
		
		JButton btnProbabilidade = new JButton("Probabilidade");
		btnProbabilidade.setBounds(609, 347, 127, 23);
		contentPane.add(btnProbabilidade);
		btnProbabilidade.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				String busca = "";
				if(rdbtnCalvice.isSelected())
					busca = "probabilidadeCalvice("+areaBusca.getText()+")."; //escrever a proposição a ser chamada usando o texto do areaBusca 
				if(rdbtnOlhos.isSelected())
					busca = "probabilidadeOlho("+areaBusca.getText()+").";
				if(rdbtnPele.isSelected())
					busca = "probabilidadePele("+areaBusca.getText()+").";
				if(rdbtnSangue.isSelected())
					busca = "probabilidadeSanguineo("+areaBusca.getText()+").";
				areaResposta.setText(consultar(busca));
			}	
		});
		


	}

	public String consultar(String consulta){
		JIPTerm busca = pg.getTermParser().parseTerm(consulta);	//CONSULTA
		StringBuffer result = new StringBuffer();

		try{
			JIPQuery pesquisa = pg.openSynchronousQuery(busca); //iniciar busca
			JIPTerm resposta;

			//fazer loop enquanto houver outra resposta
			while (pesquisa.hasMoreChoicePoints())
			{
				resposta = pesquisa.nextSolution();		//isso aqui retorna lista com formato estranho
				//System.out.println(resposta);

				JIPVariable[] vars = null;
				if(resposta!= null){
					vars = resposta.getVariables();

					vars = resposta.getVariables();
					for (JIPVariable var : vars) {
						if (!var.isAnonymous()) {		//O RESULTADO DA PESQUISA ESTÁ AQUI!
							result.append(var.getName() + " = " + var.toString(pg)+"\n");
						}
					}
				}
				else
					System.out.println("NULO");
			}

		} catch(JIPSyntaxErrorException ex){
			ex.printStackTrace();
		} 	

		return result.toString(); 
	}}
