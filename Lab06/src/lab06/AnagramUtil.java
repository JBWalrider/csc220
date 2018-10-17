package lab06;
import java.io.BufferedReader;import java.io.FileReader;import java.util.ArrayList;import java.util.Comparator;
public class AnagramUtil{
	public static String sort(String inputString){
		if(inputString==null)return null;
		char[]c=inputString.toLowerCase().toCharArray();char b;
		for(int i=0;++i<c.length;)for(int j=i;j>0;j--)if(c[j-1]>c[j]){b=c[j-1];c[j-1]=c[j];c[j]=b;}
		return new String(c);
	}
	public static boolean areAnagrams(String string1,String string2){return sort(string1).equals(sort(string2));}
	public static void insertionSort(String[]inputList){
		if(inputList==null)return;
		class OrderStrings implements Comparator<String>{public int compare(String q,String w){return q.compareTo(w);}}
		Comparator<String>o=new OrderStrings();String b;String[]c=inputList;
		for(int i=0;++i<c.length;)for(int j=i;j>0;j--)if(o.compare(sort(c[j-1]),sort(c[j]))>0){b=c[j-1]+"";c[j-1]=c[j]+"";c[j]=b;} //quotes needed?
	}
	public static String[] getLargestAnagramGroup(String[]inputList){
        String[]c=inputList,s={};int a=0,z=1;insertionSort(c);
        for(int i=0;++i<c.length;z=sort(c[i]).equals(sort(c[i-1]))?i+1:z+(a=i)-i)if(z-a>s.length){s=new String[z-a];for(int j=a;j<z;j++)s[j-a]=c[j];} 
        return s;
    }
	public static String[]getLargestAnagramGroup(String filename){return getLargestAnagramGroup(readFile(filename));} 
	
    public static String[] readFile(String filename)
	{
		ArrayList<String> results = new ArrayList<String>();
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(filename));
			while(input.ready())
			{
				results.add(input.readLine());
			}
			input.close();
		}
		catch(Exception e)
		{e.printStackTrace();}
		String[] retval = new String[1];
		return results.toArray(retval);
	}	
}

