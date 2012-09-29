package debruijn.generator;

public class Generator {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int length 	= 0;
		LinkedNodeSequence<String> alphabet = new LinkedNodeSequence<String>();
		
		try{
			for(int x=0;x<args.length;x++){
				if(args[x].compareTo("-h")==0)
					printHelp(); 
				if(args[x].compareTo("-l")==0)
					length = Integer.parseInt(args[++x]);
				if(args[x].compareTo("-a")==0){
					x++;
					while(x<args.length){
						if(args[x].contains("-")) break;
						alphabet.addLast(args[x]);
						x++;
					}
				}
			}
		}catch(Exception ex){
			printHelp();
			System.err.print(ex.getStackTrace());
		}
		
		/*length =3;
		alphabet.addLast("0");
		alphabet.addLast("1");
		//alphabet.addLast("2");*/
		
		if(length==1){
			for(String curr:alphabet)
				System.out.print(curr);
			System.out.println();
			return;
		}else if(alphabet.size()==1){
			 for(int x=0;x<length;x++)
				 System.out.println(alphabet.get(0));
			 return;
		}else if(length<1||alphabet.size()<1) printHelp();
		
		DeBruijnGraph graphStruct = new DeBruijnGraph(length, alphabet);
		graphStruct.genPermutations();
		
		System.out.println(graphStruct.genSequence());
		//graphStruct.genSequence();
	}
	
	public static void printHelp(){
		System.out.println("--------------------------------------------------");
		System.out.println("This program creates a DeBruijn Sequence.\n");
		System.out.println("-h - prints this menu");
		System.out.println("-l - length of desired permutations");
		System.out.println("-a - alphabet of desired permutations e.g. -a 0 1");
		System.out.println();System.out.println();
		System.out.println("Version 0.1");
		System.out.println("Currently only supports alphabet characters of length: 1");
		System.out.println("--------------------------------------------------");
		System.out.println("-----------------Warren Green 2012----------------");
		System.out.println("--------------------------------------------------");
		System.exit(0);
	}
	

}
