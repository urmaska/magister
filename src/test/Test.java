package test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@SuppressWarnings("unused")
public class Test {

	@org.junit.Test
	public void test() throws IOException {
		String file="lenses.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			String andmeRida = br.readLine();
		    while ((andmeRida = br.readLine()) != null) {
		    	String[] sisendid = andmeRida.split("\t");
//		    	assertEquals(sisendid[4], RuleSystem.reegliSystem(sisendid[0], sisendid[1], sisendid[2], sisendid[3]));
//		    	assertEquals(sisendid[4], RuleSystem.sagedaseimTunnus(sisendid[0], sisendid[1], sisendid[2], sisendid[3]));
		    	
//		    	assertEquals(sisendid[3], RuleSystem.reegliSystem(sisendid[0], sisendid[1], sisendid[2]));
//		    	assertEquals(sisendid[3], RuleSystem.sagedaseimTunnus(sisendid[0], sisendid[1], sisendid[2]));

		    }	
		}
	}

}
