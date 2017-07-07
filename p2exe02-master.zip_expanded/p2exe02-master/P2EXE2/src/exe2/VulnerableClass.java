package exe2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VulnerableClass {
	
	public void vulnerableMethod(String FILENAME) throws Exception{
		
		Pattern pattern = Pattern.compile("[^A-Za-z0-9._]");
		Matcher matcher = pattern.matcher(FILENAME);
		if(matcher.find())
			throw new Exception("Invalid characters");
		
		boolean _run = true;
		
		while (_run) {
			
		    Scanner console = new Scanner(System.in);
		    System.out.println("Digite a operacao desejada para realizar:\n"
		    		+ "R para ler um arquivo\n"
		    		+ "W para escrever em um arquivo\n"
		    		+ "Ou digite S para sair");
			
		    String opr= console.nextLine();
			
		    if (opr.equals("R")){
				BufferedReader br = null;
				FileReader fr = null;
				
				try {

					fr = new FileReader(FILENAME);
					br = new BufferedReader(fr);

					String sCurrentLine;

					br = new BufferedReader(new FileReader(FILENAME));

					while ((sCurrentLine = br.readLine()) != null) {
						System.out.println(sCurrentLine);
					}

				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
			
			else if (opr.equals("W")) {
				  BufferedWriter buffWrite;
				  
				  try {
					buffWrite = new BufferedWriter(new FileWriter(FILENAME));
					String linha = "";
					System.out.println("Escreva algo: ");
				    linha = console.nextLine();
				    buffWrite.append(linha + "\n");
				    buffWrite.flush();
				     
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		    
			else if (opr.equals("S")){
				_run = false;
				console.close();
			}
				    
			else
				System.out.println("Operação inválida, digite novamente.");
		}
	}
}