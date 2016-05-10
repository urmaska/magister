package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Mõõtmine {
	
	public static void main(String[] args) throws IOException {
		
		// voting.txt 15
		// cars.txt 5
		// nursery.txt 7
		// bridges
		String file="bridgesm.txt";
		long a1 = 0, a2 = 0, a3 = 0, a4=0;
		String sis[][] = new String[100000][16];
		long start, stop, elapsed;
		int indeks = 0;
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			String andmeRida = br.readLine();
		    while ((andmeRida = br.readLine()) != null) {
		    	sis[indeks++] = andmeRida.split("\t");
		    }	
		}
		
		for(int j=0;j<1000;j++){
		
		start = System.nanoTime();
		for(int i=0; i<indeks;i++)
			RuleSystem.reegliSystem(sis[i][0], sis[i][1], sis[i][2], sis[i][3], sis[i][4], sis[i][5],
	    			sis[i][6], sis[i][7], sis[i][8], sis[i][9]/*, sis[i][10]/*, 
		   			sis[i][11], sis[i][12], sis[i][13], sis[i][14], sis[i][15]/**/);
		stop = System.nanoTime();
	    elapsed = stop - start;
//	    System.out.println("reeglisüsteem " + elapsed);
	    a1+=elapsed;
		
				
		start = System.nanoTime();
		for(int i=0; i<indeks;i++)
			RuleSystem.pikkus(sis[i][0], sis[i][1], sis[i][2], sis[i][3], sis[i][4], sis[i][5],
    			sis[i][6], sis[i][7], sis[i][8], sis[i][9]/*, sis[i][10], 
   			sis[i][11], sis[i][12], sis[i][13], sis[i][14], sis[i][15]/**/);
		stop = System.nanoTime();
	    elapsed = stop - start;
//	    System.out.println("pikkus " + elapsed);
	    a2+=elapsed;

		start = System.nanoTime();
		for(int i=0; i<indeks;i++)
			RuleSystem.sagedaseimTunnus(sis[i][0], sis[i][1], sis[i][2], sis[i][3], sis[i][4], sis[i][5],
	    			sis[i][6], sis[i][7], sis[i][8], sis[i][9]/*, sis[i][10], 
		   			sis[i][11], sis[i][12], sis[i][13], sis[i][14], sis[i][15]/**/);
		stop = System.nanoTime();
	    elapsed = stop - start;
//	    System.out.println("sagedaseim " + elapsed);
	    a3+=elapsed;

		start = System.nanoTime();
		for(int i=0; i<indeks;i++)
			RuleSystem.sagedus(sis[i][0], sis[i][1], sis[i][2], sis[i][3], sis[i][4], sis[i][5],
	    			sis[i][6], sis[i][7], sis[i][8], sis[i][9]/*, sis[i][10], 
		   			sis[i][11], sis[i][12], sis[i][13], sis[i][14], sis[i][15]/**/);
		stop = System.nanoTime();
	    elapsed = stop - start;
//	    System.out.println("sagedaseim " + elapsed);
	    a4+=elapsed;
		
	}
		System.out.println("minimeeritud reeglisüsteem " + a1/1000000 + "ms\nPikkuse järgi " + a2/1000000 + "ms\n sageduse puu " + a3/1000000 + "ms\n sageduse järgi " + a4/1000000 + "ms");
	}
}
