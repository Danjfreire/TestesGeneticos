package application;

import java.util.ArrayList;

import javax.swing.JTextField;

import org.jpl7.Query;
import org.jpl7.Term;
import org.jpl7.Util;

public class Arvore {
	public StringBuffer gerarArvoreProlog(JTextField tfPessoa, String nivel){
		String consulta = "arvoreGenealogica('"+ tfPessoa.getText() +"', Arvore,"+ nivel +",Resposta, Id)";
		System.out.println(consulta);
		StringBuffer resposta = new StringBuffer();
		//Realizar consulta 
		Query q = new Query(consulta);
		Term t = q.oneSolution().get("Arvore");
		Term id = q.oneSolution().get("Id");
		Term tr = q.oneSolution().get("Resposta");
		
		if(id.toString().equals("1")){			
			resposta.append(tr + "\n\n");
			
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
				
				
				resposta.append("\n\n\n");
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
			tfPessoa.setText("");
			
		}else{
			resposta.append(tr);
			tfPessoa.setText("");
		}
		return resposta;
	}
	
	public StringBuffer gerarArvoreDescendencia(JTextField tfPai, JTextField tfMae, String nivel){
		String consulta = "descendentes('" + tfPai.getText() + 	"','" + tfMae.getText() + "',Descendentes," + nivel + ", Resposta, Id)";
		StringBuffer resposta = new StringBuffer();
		Query q = new Query(consulta);
		Term t = q.oneSolution().get("Descendentes");
		Term t1 = q.oneSolution().get("Resposta");
		Term t2 = q.oneSolution().get("Id");
		
		if(!(t2.toString().equals("1"))){
			if(t2.toString().equals("2") || t2.toString().equals("5")){
				tfPai.setText("");
				resposta.append(t1);
			}if(t2.toString().equals("3") || t2.toString().equals("4")){
				tfMae.setText("");
				resposta.append(t1);
			}
		}
		else{
			System.out.print(t);
			resposta.append(t1);
			resposta.append("\n\n");
			
			ArrayList<Term> termos= new ArrayList<Term>();
			Term aux;
			
			termos.add(t.arg(1));
			aux = t.arg(2);
			
			while(!(aux.isAtom())){
				termos.add(aux.arg(1));
				aux = aux.arg(2);
			}
			
			int i;
			Term base = termos.get(termos.size() - 1);
			String[] elementosTemp = Util.atomListToStringArray(base);
			int tamanhoRef = (elementosTemp.length/36) * 22 + (elementosTemp.length/36 - 1)*2;
			
			int tabulacao;			
			elementosTemp = Util.atomListToStringArray(termos.get(0));
			int espacoCasal = (22 - elementosTemp[0].length())/2  + 1 + (22 - elementosTemp[1].length())/2;
			tabulacao = (tamanhoRef - 45)/2 + (22 - elementosTemp[0].length())/2;
			
			i = 0;
			while(i < tabulacao){
				resposta.append(" ");
				i++;
			}
			resposta.append(elementosTemp[0]);
			i = 0;
			while(i < espacoCasal){
				resposta.append(" ");
				i++;
			}
			resposta.append(elementosTemp[1]);
			resposta.append("\n");
			
			tabulacao = (tamanhoRef - 45)/2 + 2;
			i = 0;
			while(i < tabulacao){
				resposta.append(" ");
				i++;
			}
			i = 2;
			while(i < 14){
				resposta.append(elementosTemp[i]);
				i++;
			}
			i = 0;
			while(i < 5){
				resposta.append(" ");
				i++;
			}
			i = 14;
			while(i < elementosTemp.length){
				resposta.append(elementosTemp[i]);
				i++;
			}
			resposta.append("\n\n\n");
			int marcador;
			int inicio;
			int indice; 
			int j;
			i = 1;
			int casal = 1;
			
			while(i < termos.size()-1){
				elementosTemp = Util.atomListToStringArray(termos.get(i));
				tabulacao = (tamanhoRef - ((elementosTemp.length/36)*22 + (elementosTemp.length/36)/2 + ((elementosTemp.length/36)/2 - 1)*2))/2;
				j = 0;
				while(j < tabulacao + 7){
					resposta.append(" ");
					j++;
				}
				inicio = 0;
				marcador = 0;
				indice = 0;
				resposta.append("CASAL " + String.format("%02d", casal));
				while(indice < elementosTemp.length - 24){
					if((indice % 12 == 0) && (indice != inicio) && (marcador == 1)){
						indice = indice + 24;
						inicio = indice;
						resposta.append("                ");
						resposta.append("CASAL " + String.format("%02d", casal));
						marcador = 0;
					}
					else if((indice % 12 == 0) && (indice != inicio) && (marcador == 0)){
						indice = indice + 24;
						inicio = indice;
						resposta.append("               ");
						resposta.append("CASAL " + String.format("%02d", casal));
						casal++;
						marcador = 1;
					}
					indice++;
				}
				resposta.append("\n");
				j = 0;
				while(j < tabulacao + 2){
					resposta.append(" ");
					j++;
				}
				inicio = 0;
				marcador = 0;
				indice = 0;
				while(indice < elementosTemp.length - 24){
					if((indice % 12 == 0) && (indice != inicio) && (marcador == 1)){
						indice = indice + 24;
						inicio = indice;
						resposta.append("      ");
						marcador = 0;
					}
					else if((indice % 12 == 0) && (indice != inicio) && (marcador == 0)){
						indice = indice + 24;
						inicio = indice;
						resposta.append("     ");
						marcador = 1;
					}
					resposta.append(elementosTemp[indice]);
					indice++;
				}
				resposta.append("\n");
				j = 0;
				while(j < tabulacao){
					resposta.append(" ");
					j++;
				}
				inicio = 12;
				marcador = 0;
				indice = 12;
				resposta.append("pai:");
				while(indice < elementosTemp.length - 12){
					if((indice % 12 == 0) && (indice != inicio) && (marcador == 1)){
						indice = indice + 24;
						inicio = indice;
						resposta.append("  pai:");
						marcador = 0;
					}
					else if((indice % 12 == 0) && (indice != inicio) && (marcador == 0)){
						indice = indice + 24;
						inicio = indice;
						resposta.append(" pai:");
						marcador = 1;
					}
					resposta.append(elementosTemp[indice]);
					indice++;
				}
				resposta.append("\n");
				j = 0;
				while(j < tabulacao){
					resposta.append(" ");
					j++;
				}
				inicio = 24;
				marcador = 0;
				indice = 24;
				resposta.append("mãe:");
				while(indice < elementosTemp.length){
					if((indice % 12 == 0) && (indice != inicio) && (marcador == 1)){
						indice = indice + 24;
						inicio = indice;
						resposta.append("  mãe:");
						marcador = 0;
					}
					else if((indice % 12 == 0) && (indice != inicio) && (marcador == 0)){
						indice = indice + 24;
						inicio = indice;
						resposta.append(" mãe:");
						marcador = 1;
					}
					resposta.append(elementosTemp[indice]);
					indice++;
				}
				resposta.append("\n\n\n");
				i++;
			}
			elementosTemp = Util.atomListToStringArray(termos.get(i));
			inicio = 0;
			indice = 0;
			int filho = 1;
			resposta.append("      ");
			resposta.append("FILHO " + String.format("%04d", filho));
			while(indice < elementosTemp.length - 24){
				if((indice % 12 == 0) && (indice != inicio)){
					indice = indice + 24;
					inicio = indice;
					filho++;
					resposta.append("              ");
					resposta.append("FILHO " + String.format("%04d", filho));
				}
				indice++;
			}
			resposta.append("\n");
			inicio = 0;
			indice = 0;
			resposta.append("  ");
			while(indice < elementosTemp.length - 24){
				if((indice % 12 == 0) && (indice != inicio)){
					indice = indice + 24;
					inicio = indice;
					resposta.append("      ");
				}
				resposta.append(elementosTemp[indice]);
				indice++;
			}
			resposta.append("\n");
			inicio = 12;
			indice = 12;
			resposta.append("pai:");
			while(indice < elementosTemp.length - 12){
				if((indice % 12 == 0) && (indice != inicio)){
					indice = indice + 24;
					inicio = indice;
					resposta.append("  pai:");
				}
				resposta.append(elementosTemp[indice]);
				indice++;
			}
			resposta.append("\n");
			inicio = 24;
			indice = 24;
			resposta.append("mãe:");
			while(indice < elementosTemp.length){
				if((indice % 12 == 0) && (indice != inicio) ){
					indice = indice + 24;
					inicio = indice;
					resposta.append("  mãe:");
				}
				resposta.append(elementosTemp[indice]);
				indice++;
			}
			tfPai.setText("");
			tfMae.setText("");
		}
		return resposta;
	}
}
