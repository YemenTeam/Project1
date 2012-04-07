import java.util.*;

public class Msort {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Character[] a={'A','C','G','D','F','B','Z','Y','X','O'};
		
		LinkedList <Character> unsorted = new LinkedList<Character>();
		
		System.out.println("Unsorted Char Array ");
		for (int i=0;i<a.length;i++){
			unsorted.add(a[i]);
			System.out.print(a[i]+",");
		}
		System.out.println("");
	
		LinkedList<LinkedList <Character>> split = splitList(unsorted);
		
		System.out.println("Split list1 ");
		LinkedList<Character> d = split.get(0);
		for (int i=0;i<d.size();i++){
			System.out.print(d.get(i)+",");
		}
		System.out.println("");
		System.out.println("Split list2 ");
		LinkedList<Character> e = split.get(1);
		for (int i=0;i<e.size();i++){
			System.out.print(e.get(i)+",");
		}
		System.out.println("");
		System.out.println("Sorted Char list ");	
		LinkedList<Character> sorted = mSort(unsorted);
		for (int i=0;i<sorted.size();i++){
			System.out.print(sorted.get(i)+",");
		}

	
	}
	


	private static LinkedList <LinkedList <Character>> splitList(LinkedList <Character> a) {
		
		LinkedList <LinkedList <Character>> x1= new LinkedList<LinkedList <Character>>();
		LinkedList <Character> list1;
		LinkedList <Character> list2; 
		
		if(a.size()==0)
			{
			return x1 ;
			}	
		
		x1 = splitList(cdr(a));

		if(x1.size()!=0){
		list1 = new LinkedList<Character>(x1.get(0));
		list2 = new LinkedList<Character>(x1.get(1));
		}
		else{
		list1 = new LinkedList<Character>();
		list2 = new LinkedList<Character>();
		}
		
		list2.add(a.get(0));

		LinkedList <LinkedList <Character>> x2= new LinkedList<LinkedList <Character>>();
		x2.add(list2);
		x2.add(list1);
		return x2;
	}
	
	private static LinkedList <Character> mSort(LinkedList <Character> a) {
		LinkedList <LinkedList <Character>> split= new LinkedList<LinkedList <Character>>();
		LinkedList <Character> y;
		LinkedList <Character> z;
		
		
		if(a.size()==0)
			{
			return a;
			}
		else if(a.size()==1)
		{
			return a;
		}
		else
		{
			
			split = splitList(a);
			y = mSort(split.get(0));
			z = mSort(split.get(1));

		}
		LinkedList <Character> r  = mergeLists(y,z);
	
		return r;

	}
	
	private static LinkedList <Character> mergeLists(LinkedList <Character> a,LinkedList <Character> b) {
		
		LinkedList <Character> x = new LinkedList <Character>();
		
		
		if(a.size()==0)
			return b;
		else if (b.size()==0)
			return a;
		else if(a.get(0)<b.get(0))
		{
			x.add(a.get(0));
			x.addAll(mergeLists(cdr(a), b));
			
		}
		else{	
			x.add(b.get(0));
			x.addAll(mergeLists(a, cdr(b)));
			
		}
	return x;
	}
			
	public static LinkedList <Character> cdr(LinkedList <Character> a){
		LinkedList <Character> b = new LinkedList <Character> ();
		for (int i=1;i<a.size();i++)
		{
			b.add(a.get(i));
		}
		
		return b;
	}
	
}	
	

