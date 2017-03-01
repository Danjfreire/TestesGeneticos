package application;

import java.io.File;

public class Testes {
	public static void main(String[] args){
		File temp = new File("");
		String caminho =  temp.getAbsolutePath();
		String definivo = caminho.replace("\\", "\\\\");
		System.out.println(definivo);
		TelaIndividuo t = new TelaIndividuo();
		t.setVisible(true);
	}
}
