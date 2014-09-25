import java.util.*;
public class CountBrackets2{

	private static List<String> openers = new ArrayList<String>();
	private static List<String> closers = new ArrayList<String>();
	private static List<String> order = new ArrayList<String>();
	private static int[] counter = new int[3];

	public static void main(String args[]){
		openers.add("("); openers.add("["); openers.add("{");
		closers.add(")"); closers.add("]"); closers.add("}");

		counter[0] = 0; //(
		counter[1] = 0; //{
		counter[2] = 0; //[
		
		String string = args[0];

		if (string.length() % 2 != 0)
			System.out.println("false");
		else{
			Boolean b = vai(string,0);
			System.out.println(b);	
		}
	}

	private static Boolean vai(String string, int index){
		if (index > string.length() -1)
			return counter[0] + counter[1] + counter[2] == 0;
		else{
			char c = string.charAt(index);
//			System.out.println("index: "+index);
//			System.out.print("c: "+c);
			if (openers.contains(String.valueOf(c))){
//				System.out.println(" is opener");
				switch(c){
					case '{': counter[0]++; order.add(String.valueOf(c)); break;
					case '(': counter[1]++; order.add(String.valueOf(c)); break;
					case '[': counter[2]++; order.add(String.valueOf(c)); break;	
				}
			} else if (closers.contains(String.valueOf(c))){
//				System.out.println(" is closer");
				switch(c){		
					case '}': 
						if (order.get(order.size()-1).equals("{"))
							counter[0]--; 
							order.remove(order.size()-1);
						break;
					case ')': 
						if (order.get(order.size()-1).equals("("))
							counter[1]--; 
							order.remove(order.size()-1);
						break;
					case ']': 
						if (order.get(order.size()-1).equals("["))
							counter[2]--; 
							order.remove(order.size()-1);
						break;	
				}
			}
//			System.out.println("counter {: :"+ counter[0]+": counter (: :"+counter[1]+": counter [: :"+counter[2]+":");
			return vai(string,++index);
		}
	}
/*
		int[] counter = new int[3];
		counter[0] = 0;
		counter[1] = 0;
		counter[2] = 0;
		
		List<String> order = new ArrayList<String>();

		String string = args[0].replace(" ","");
		System.out.println("string: "+string);
		for (int i=0; i <= string.length()-1; i++){
			char c = string.charAt(i);
			//System.out.println("char: "+c);
			switch (c){
				case '{': counter[0]++; order.add(String.valueOf(c)); break;
				case '(': counter[1]++; order.add(String.valueOf(c)); break;
				case '[': counter[2]++; order.add(String.valueOf(c)); break;	
				case '}': 
					if (order.get(order.size()-1).equals("{"))
						counter[0]--; 
					break;
				case ')': 
					if (order.get(order.size()-1).equals("("))
						counter[1]--; 
					break;
				case ']': 
					if (order.get(order.size()-1).equals("["))
						counter[2]--; 
					break;	
			}
			System.out.println("counter {: :"+ counter[0]+": counter (: :"+counter[1]+": counter [: :"+counter[2]+":");
		}

		System.out.println(counter[0] + counter[1] + counter[2] == 0);
*/
	//}
	
}
