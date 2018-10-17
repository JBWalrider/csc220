package lab06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class AnagramUtilTester {
	
	static<T>void e(T o) {System.err.println(o);}
	
	public static void main(String[]a){
		String[] s00 = new String[]{"", "q", "pinky", "moo", "waldo", "supercalifragilisticexpialidocious"};
		String s01 = "" + "q" + "iknpy" + "moo" + "adlow" + "aaacccdeefgiiiiiiillloopprrssstuux";
		String s02 = "";
		if (!(AnagramUtil.sort(null) == null)) e("sort: Sort null string not returning null");
		for (int i = 0; i < 6; i++) {s02 += AnagramUtil.sort(s00[i]);}
		if (!(s01.equals(s02))) e("sort: Not sorting");
		if (!(AnagramUtil.areAnagrams("anagram", "magrana"))) e("areAnagrams: Words should be anagrams");
		if (AnagramUtil.areAnagrams("anagram", "magranaa")) e("areAnagrams: Words should not be anagrams (case 0)");
		if (AnagramUtil.areAnagrams("anagram", "magrano")) e("areAnagrams: Words should not be anagrams (case 1)");
		String[] s10 = null;
		String[] s11 = {"", "joy", "cat", "ski", "fed", "pinky"};
		String[] s12 = {"", "cat", "fed", "pinky", "ski", "joy"}; //act, def, iknpy, iks, joy
		AnagramUtil.insertionSort(s10);
		AnagramUtil.insertionSort(s11);
		for (int i = 0; i < 6; i++) {if (!(s11[i].equals(s12[i]))) e("insertionSort: Not sorting");}
        String[] s21 = {"", "anag", "agan", "agna", "moose", "moo", "john", "jonh", "sheep", "shepe", "shpee", "sphee", "speeh", "clyde"};
        String[] s22 = {"sheep", "shepe", "shpee", "sphee", "speeh"};
        String[] s23 = AnagramUtil.getLargestAnagramGroup(s21);
        for (int i = 0; i < 5; i++) {if (!(s22[i].equals(s23[i]))) e("getLargestAnagramGroup: Not returning largest group");}
        String[] s30 = readFile("sample_word_list.txt");
        String[] s31 = AnagramUtil.getLargestAnagramGroup(s30);
        String[] s32 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
        String[] s33 = {"carets","Caters","caster","crates","Reacts","recast","traces"};
        for (int i = 0; i < s33.length; i++) {if (!(s33[i].equals(s31[i]))) e("getLargestAnagramGroup (String[]): Not correct");}
        for (int i = 0; i < s33.length; i++) {if (!(s33[i].equals(s32[i]))) e("getLargestAnagramGroup (String): Not correct");}
		System.out.println("Testing done.");
	}
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
//if(sort(c[i]).equals(sort(c[i-1])))z=i+1;else a=i; //+2b (getLargestAnagramGroup)