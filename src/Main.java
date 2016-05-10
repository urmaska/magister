import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import andmeTabel.AndmeTabel;


public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException{
		AndmeTabel andmeTabel = new AndmeTabel();
		String file="bridges.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			String andmeRida = br.readLine();
			andmeTabel.looTabel(andmeRida.split("\t"));
		    while ((andmeRida = br.readLine()) != null) 
		    	andmeTabel.lisaUusRida(andmeRida.split("\t"));
		}
		System.out.println("algus");
//		andmeTabel.prindiSagedusTabel();
//		System.out.println(andmeTabel);
		andmeTabel.setKoopia();
		andmeTabel.otsiReeglid();
		andmeTabel.prindiReeglid();
		andmeTabel.minimeeriReeglid();
		System.out.println("lopp");
		andmeTabel.prindiReeglid();
		andmeTabel.prindiReegliSüsteem();
	}
}
