import java.util.*;
public class CountBrackets{

	public static void main(String args[]){
		// 0 -> {
		// 1 -> (
		// 2 -> [
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
	}
	
}
