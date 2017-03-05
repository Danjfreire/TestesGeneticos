package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jpl7.JPL;
import org.jpl7.Query;
import org.jpl7.Term;
import org.jpl7.Util;
import org.jpl7.Variable;
import org.jpl7.fli.term_t;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import java.awt.Button;
import java.awt.TextArea;
import java.awt.Panel;
import java.awt.Canvas;
import java.awt.Font;

public class T extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T frame = new T();
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
	public T() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 436, 202);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Courier New", Font.BOLD, 13));
		scrollPane.setViewportView(textArea);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setBounds(460, 35, 380, 160);
		contentPane.add(textArea_1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StringBuffer r = new StringBuffer();
				r =gerarArvoreProlog("arvoreGenealogica('wallace santana', Arvore,7)");
				textArea.setText(r.toString());
			}
		});
		btnNewButton.setBounds(181, 224, 89, 23);
		contentPane.add(btnNewButton);
		
		Button button = new Button("New button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(294, 225, 70, 22);
		contentPane.add(button);
		
		
	}
	public StringBuffer gerarArvoreProlog(String consulta){
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
