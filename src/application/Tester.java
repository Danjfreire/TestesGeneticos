package application;

import java.io.File;
import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;

public class Tester {
	public static void main (String [] args){
		
		//Configura o caminho do arquivo
		File temp = new File("");
		String tempCaminho = temp.getAbsolutePath();
		String caminho = tempCaminho.replace("\\", "\\\\");
		String caminhoPL = caminho + "\\\\analise_genetica";
		//String caminhoTXT = caminho + "\\\\pessoas.txt";
		
		//ver caminho
		System.out.println(caminhoPL);
		
		//montagem da chamada: consult(caminhoDoArquivo)
		Query q1 = new Query( "consult", new Term[] {new Atom(caminhoPL)} );
		
		//verirficacao da resposta
		System.out.println( "consult " + (q1.hasSolution() ? "succeeded" : "failed"));
		
		//teste lista
		String c = "teste(X)";
		System.out.println(Query.oneSolution(c).get("X"));
		
		TelaIndividuo t = new TelaIndividuo();
		t.setVisible(true);
	}
}
