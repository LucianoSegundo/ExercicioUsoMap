package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> resultadoVotacao = new TreeMap<>();
		try (BufferedReader leitor = new BufferedReader(new FileReader("./votação.csv"))) {

			String linha = leitor.readLine();

			while (linha != null) {
				
				String[] picotada = linha.split(",");
				String chave = picotada[0];
				Integer valor = Integer.parseInt(picotada[1]);
				
				if(resultadoVotacao.containsKey(chave)) {
					valor += resultadoVotacao.get(chave);
					resultadoVotacao.put(chave, valor);
					
				}
				else resultadoVotacao.put(chave, valor);
				
				linha = leitor.readLine();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Resultado da votação");
		for(String key : resultadoVotacao.keySet()) {
			System.out.println(key+ " : "+ resultadoVotacao.get(key));
		}
	}

}
