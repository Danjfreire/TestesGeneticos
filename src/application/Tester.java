package application;
import java.io.IOException;

import com.ugos.jiprolog.engine.*;

public class Tester {
	public static void main (String [] args){
		JIPTerm busca = null;
		JIPEngine pg = new JIPEngine();
		try{
			pg.consultFile("arquivos/Testes.pl");			//CAMINHO DO ARQUIVO
			busca = pg.getTermParser().parseTerm("lista(X).");	//CONSULTA
		} catch(JIPSyntaxErrorException ex){
			ex.printStackTrace();
		} 
		
		//iniciar busca
		JIPQuery pesquisa = pg.openSynchronousQuery(busca);
		JIPTerm resposta;
		
		//fazer loop enquanto houver outra resposta
		 while (pesquisa.hasMoreChoicePoints())
	        {
	            resposta = pesquisa.nextSolution();		//isso aqui retorna lista com formato estranho
	            //System.out.println(resposta);

	            JIPVariable[] vars = resposta.getVariables();
	            for (JIPVariable var : vars) {
	                if (!var.isAnonymous()) {		//O RESULTADO DA PESQUISA ESTÁ AQUI!
	                    System.out.print(var.getName() + " = " + var.toString(pg) + " ");
	                    System.out.println();
	                }
	            }
	        }
		
		
		
		
		
		
		
		
	}
}
