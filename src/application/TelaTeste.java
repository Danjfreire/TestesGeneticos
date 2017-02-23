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

public class TelaTeste extends JFrame {

	private JPanel contentPane;

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
		JIPEngine pg = new JIPEngine();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 11, 533, 439);
		contentPane.add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		JButton btnTeste = new JButton("Teste");
		btnTeste.setBounds(641, 51, 89, 23);
		contentPane.add(btnTeste);
		btnTeste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 //gera vários fails
				try{
					pg.consultFile("analise_genetica.pl");			//CAMINHO DO ARQUIVO
					JIPTerm busca = pg.getTermParser().parseTerm("corPele('A','A','B','B',X).");	//CONSULTA
					
					JIPQuery pesquisa = pg.openSynchronousQuery(busca); //iniciar busca
					JIPTerm resposta;
					StringBuffer consulta = new StringBuffer();
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
				                    consulta.append(var.getName() + " = " + var.toString(pg)+"\n");
				                    consulta.append("pulou linha");
				                }
				            }
				           }
				            else
				            	System.out.println("NULO");
				        }
					 textPane.setText(consulta.toString());

				} catch(JIPSyntaxErrorException ex){
					ex.printStackTrace();
				} 							
			}
		});
	}
}
