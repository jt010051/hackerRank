package com.hackerrank;
import java.util.Scanner;

import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.io.*; import java.text.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;


import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class hackerRank {

	
    public static void main(String[] args) {
    	//review; doesn't pass all test cases
    	 Scanner in = new Scanner(System.in);
         Deque<Integer> deque = new ArrayDeque<>();
         //HashSet<Integer> set = new HashSet<>();
         int max = Integer.MIN_VALUE;

         int n = in.nextInt();
         int m = in.nextInt();

         for (int i = 0; i < n; i++) {
             int num = in.nextInt();
             		deque.add(num);
//set.add(num);
             	    if (deque.size() ==m) {
                    	if (deque.size()>max) max=deque.size();
                    	int first = deque.remove();
                    	if(!deque.contains(first)) deque.remove(first);
                    }
         }
    
         System.out.println(max);
    }
	static void comparator() {
		Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
	}
	static void javaStack() {
		Stack<Character> stack = new Stack<Character>();
        Scanner sc = new Scanner(System.in);
        String line;
        while (sc.hasNextLine()){
            line = sc.nextLine();
            if (isBalanced(line)) System.out.println("true");
            else System.out.println("false");
        }
	}
    public static boolean isBalanced(String s) {
		//review code
        Stack<Character> stack = new Stack<Character>();
        for (int i=0; i<s.length();++i){
            if (s.charAt(i) == '(') stack.push('(');
            else if (s.charAt(i) == '{') stack.push('{');
            else if (s.charAt(i) == '[') stack.push('[');
            else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) return false;
                if (stack.pop() != '(') return false;
            }
            else if (s.charAt(i) == '}') {
                if (stack.isEmpty()) return false;
                if (stack.pop() != '{') return false;
            }
            else if (s.charAt(i) == ']') {
                if (stack.isEmpty()) return false;
                if (stack.pop() != '[') return false;
            }
        }
        return stack.isEmpty();
    }
    

		
	static void array2() {
		Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
	}
	private static boolean isSolvable(int leap, int[] game, int i) {
	    // Base Cases
	    if (i >= game.length) {
	        return true;
	    } else if (i < 0 || game[i] == 1) {
	        return false;
	    }
	            
	    game[i] = 1; // marks as visited

	    // Recursive Cases
	    return isSolvable(leap, game, i + leap) || 
	           isSolvable(leap, game, i + 1) || 
	           isSolvable(leap, game, i - 1);
	}
	public static boolean canWin(int leap, int[] game) {
	    return isSolvable(leap, game, 0);
	}

	static void bitSet() {
		 Scanner scan = new Scanner(System.in);
	      int n = scan.nextInt();
	    int m = scan.nextInt();

	    BitSet b1 = new BitSet(n);
	    BitSet b2 = new BitSet(n);

	    for (int i = 0; i < m; i++) {
	      String opcode = scan.next();
	      int num1 = scan.nextInt();
	      int num2 = scan.nextInt();

	      switch(opcode) {
	        case "AND":
	          if (num1 == 1 && num2 == 2) {
	            b1.and(b2);
	          } else if (num1 == 2 && num2 == 1) {
	            b2.and(b1);
	          } else if (num1 == 1 && num2 == 1) {
	            b1.and(b1);
	          } else if (num1 == 2 && num2 == 2) {
	            b2.and(b2);
	          }
	          break;
	        case "OR":
	          if (num1 == 1 && num2 == 2) {
	            b1.or(b2);
	          } else if (num1 == 2 && num2 == 1) {
	            b2.or(b1);
	          } else if (num1 == 1 && num2 == 1) {
	            b1.or(b1);
	          } else if (num1 == 2 && num2 == 2) {
	            b2.or(b2);
	          }
	          break;
	        case "XOR":
	          if (num1 == 1 && num2 == 2) {
	            b1.xor(b2);
	          } else if (num1 == 2 && num2 == 1) {
	            b2.xor(b1);
	          } else if (num1 == 1 && num2 == 1) {
	            b1.xor(b1);
	          } else if (num1 == 2 && num2 == 2) {
	            b2.xor(b2);
	          }
	          break;
	        case "FLIP":
	          if (num1 == 1) {
	            b1.flip(num2);
	          } else if (num1 == 2) {
	            b2.flip(num2);
	          }
	          break;
	        case "SET":
	          if (num1 == 1) {
	            b1.set(num2);
	          } else if (num1 == 2) {
	            b2.set(num2);
	          }
	          break;
	      }
	      System.out.println(b1.cardinality() + " " + b2.cardinality());
	    }
	}

	static void javaSort() {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
		
			
			Student st = new Student(id, fname, cgpa);
			
		
			studentList.add(st);
			
			 Collections.sort(studentList,  Comparator.comparing(Student :: getCgpa).reversed().
		              thenComparing(Student :: getFname).thenComparing(Student :: getId));
			testCases--;
		}
		
	
	
		
    
       
      	for(Student st: studentList){
			System.out.println(st.getFname());
		}
	}

	static void generics() {
		Printer myPrinter = new Printer();
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
        int count = 0;

        for (Method method : Printer.class.getDeclaredMethods()) {
            String name = method.getName();

            if(name.equals("printArray"))
                count++;
        }

        if(count > 1)System.out.println("Method overloading is not allowed!");
	}
	


	static void hSet() {
		Scanner s = new Scanner(System.in);
	        int t = s.nextInt();
	        String [] pair_left = new String[t];
	        String [] pair_right = new String[t];
	        
	        for (int i = 0; i < t; i++) {
	            pair_left[i] = s.next();
	            pair_right[i] = s.next();
	        }
	        HashSet<String> pairs = new HashSet<String>(t);

	        for(int i = 0; i < t; i++)
	        {
	            pairs.add("(" + pair_left[i] + ", " + pair_right[i] + ")" );
	            System.out.println(pairs.size());        
	        }
	}
	

	static void map() {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		in.nextLine();
		HashMap<String, Integer> h = new HashMap<>();
		for(int i=0;i<n;i++)
		{
			String name=in.nextLine();
			int phone=in.nextInt();
			h.put(name, phone);
			in.nextLine();
			
		}
		while(in.hasNext())
		{
			String s=in.nextLine();
if(h.containsKey(s)) {

	System.out.println(s+"="+h.get(s));
}
else {
	System.out.println("Not Found");
}
		}
	}


	static void arrayList() {
		Scanner scan = new Scanner(System.in);
		  int n = scan.nextInt();
	        /* Save numbers in 2-D ArrayList */
	        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
	  for (int i=0; i<n; i++) {
		  int size=scan.nextInt();
		     ArrayList<Integer> list=new ArrayList<>();

		     for(int j=0;j<size;j++)
		       {
		          int item=scan.nextInt();
		          list.add(item);
		       }
		     lists.add(list);
		  
	  }
	  int totalprint=scan.nextInt();
	    for(int k=0;k<totalprint;k++)
	    {
	      int row=scan.nextInt();
	      int col=scan.nextInt();
	      try
	       {
	       System.out.println(lists.get(row-1).get(col-1));
	       }
	      catch(Exception e)
	      {
	      System.out.println("ERROR!");
	      }
	    }
	    scan.close();
	}
		
		
		            	


	static void hourglassArray() {
		int a[][] = new int[6][6];
        int maxSum = Integer.MIN_VALUE;
        try (Scanner scanner = new Scanner(System.in);)
        {
            for(int i = 0; i < 6; i++)
            {
                for(int j = 0; j < 6; j++)
                {
                    a[i][j] = scanner.nextInt();
                    if (i > 1 && j > 1)
                    {
                        int sum =
                            a[i][j]
                            + a[i][j-1]
                            + a[i][j-2]
                            + a[i-1][j-1]
                            + a[i-2][j]
                            + a[i-2][j-1]
                            + a[i-2][j-2];
                        if (sum > maxSum) {maxSum = sum;}
                    }
                }
            }
        }
        System.out.println(maxSum);
	}
		
		
static void secondArray() {
	Scanner scan = new Scanner(System.in);
	int x = scan.nextInt();
      int [] arr = new int[x];
	for (int i=0; i<x; i++) {
         arr[i] = scan.nextInt();
         
	}
	int count=0;
    for(int j=0;j<x;j++){
        int sum=0;
        for(int k=j;k<x;k++){
            sum=arr[k]+sum;
            if(sum<0){
                count++;
            }
        }
    }
    System.out.println(count);
}
	
	static void array() {
		Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
int [] a= new int[n];

for(int i = 0; i < n; i++){
    a[i]=scan.nextInt();
}
        scan.close();

        // Prints each sequential element in array a
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
		
	}
	static void probablePrime() throws IOException{
		 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	        String n = bufferedReader.readLine();
	        BigInteger num= new BigInteger(n);	
	        if (num.isProbablePrime(1)==true) {
	        	System.out.println("prime");
	        }
	        else {
	        	System.out.println("not prime");
	        }
	        bufferedReader.close();	
		
	}
	public static String getSmallestAndLargest(String s, int k) {
		 Scanner scan = new Scanner(System.in);
		 scan.nextInt();
	        scan.close();
        String smallest = s.substring(0,k);
        String largest = "";
        s = scan.next();
        for(int i=0;i<s.length()-k+1;i++){
        	if(s.substring(i,i+k).compareTo(smallest) <0) smallest = s.substring(i,i+k);
        	if(s.substring(i,i+k).compareTo(largest) >0) largest = s.substring(i,i+k); 
        	        }
        return smallest + "\n" + largest;
    }
	static void bigDecimal() {
		 Scanner sc= new Scanner(System.in);
	        int n=sc.nextInt();
	        String []s=new String[n+2];
	        for(int i=0;i<n;i++){
	            s[i]=sc.next();
	        }
	        sc.close();

	        String[] x = Arrays.copyOf(s, n);
	        Arrays.sort(x,Collections.reverseOrder(Comparator.comparing(BigDecimal::new)));
	        s = x;

	        
	        for(int i=0;i<n;i++)
	        {
	            System.out.println(s[i]);
	        }
	}
	
	static class MyCalculator implements AdvancedArithmetic {
	    public int divisor_sum(int n) {
	        int sum = 0;
	        int sqrt = (int) Math.sqrt(n);
	        for (int i = 1; i <= sqrt; i++) {
	            if (n % i == 0) { // if "i" is a divisor
	                sum += i + n/i; // add both divisors
	            }
	        }
	        /* If sqrt is a divisor, we should only count it once */
	        if (sqrt * sqrt == n) {
	            sum -= sqrt;
	        }
	        return sum;
	    }
	
	
	
	
	
}
interface AdvancedArithmetic{
	  int divisor_sum(int n);
	}

	static void calculator() {
		
		  MyCalculator my_calculator = new MyCalculator();
	        Scanner sc = new Scanner(System.in);
 
		  int n = sc.nextInt();

	        System.out.print("I implemented: ");
	        ImplementedInterfaceNames(my_calculator);
	        System.out.print(my_calculator.divisor_sum(n) + "\n");
	      	sc.close();
	}
	
    static void ImplementedInterfaceNames(Object o){
        Class[] theInterfaces = o.getClass().getInterfaces();
        for (int i = 0; i < theInterfaces.length; i++){
            String interfaceName = theInterfaces[i].getName();
            System.out.println(interfaceName);
        }
    }
	   static void book() {
		Scanner sc=new Scanner(System.in);
		String title=sc.nextLine();
		MyBook new_novel=new MyBook();
		new_novel.setTitle(title);
		System.out.println("The title is: "+new_novel.getTitle());
      	sc.close();
		
	}
 static class MyBook extends Book{
String title;
		@Override
		public void setTitle(String s) {
this.title=s;			
		}
public String getTitle() {
return title;	
	
}
	    
	}
	static abstract class Book{
		String title;
		abstract void setTitle(String s);
		String getTitle(){
			return title;
		}
		
	}
	static void patternSyntaxChecker() {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String pattern = in.nextLine(); 
	
			
			try {
                Pattern.compile(pattern);
                
                System.out.println("Valid");
            } catch (PatternSyntaxException e) {
                System.out.println("Invalid");
            }
            testCases--;
		}
	}
	static void split() {
		Scanner scan = new Scanner(System.in);
		  String s=scan.nextLine();
		//Complete the code
		    if (s.trim().length()==0 || s.trim().length()>400000)
		    {
		        System.out.println(0);
		        return;
		    }

		    String words[]=s.trim().split("[ !,?.\\_'@]+");
		    System.out.println(words.length);
		    for (String word:words)
		        System.out.println(word);
		
		
	}
	static void anagram() {
		Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
		
	}
	
static boolean isAnagram(String a, String b) {
	a =a.toLowerCase();
	b =b.toLowerCase();

 int CHARACTER_RANGE= 256;

	if (a.length() != b.length()) {
        return false;
    }
    int count[] = new int[CHARACTER_RANGE];
    for (int i = 0; i < a.length(); i++) {
    	
        count[a.charAt(i)]++;
        count[b.charAt(i)]--;
    }
    for (int i = 0; i < CHARACTER_RANGE; i++) {
    	
        if (count[i] != 0) {
            return false;
        }
    }
    return true;
	
}
}