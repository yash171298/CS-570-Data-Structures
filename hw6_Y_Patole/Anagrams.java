
/*  
 * Name- Yash Patole
 * Cwid: 10460520
 * Assignment- 6
 * CS-570
 * 
 * */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class Anagrams {
	final Integer[] primes={2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
	 Map<Character,Integer> letterTable;
	 Map<Long,ArrayList<String>> anagramTable;
	 //Use Constructor - Constructs Anagram class and initializes class variables
	public Anagrams() {
	 //Constructor is invoking buildLetterTable method
		buildLetterTable();
		anagramTable = new HashMap<Long,ArrayList<String>>();	
	}
	//build letter table for hashing
	private void buildLetterTable() {
	    letterTable= new HashMap<Character,Integer>();
	    Character[] alphabets= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	   
	    for(int i = 0; i < 26; i++) {
			letterTable.put(alphabets[i], primes[i]);
		}
	
	} 
	
	// compute the hash code and add word in hash table
		 private void addWord(String s) {	
			
			 Long hash = this.myHashCode(s);
			 if(anagramTable.get(hash) == null) {
				 ArrayList<String> al = new ArrayList<String>();
				 al.add(s);
				 anagramTable.put(hash, al);
			} 
			else {
				anagramTable.get(hash).add(s);
			}
		}
		 
		 private Long myHashCode(String s) {
				long key=1;
				for(int j=0; j<s.length(); j++) {
					key= key*(long)letterTable.get(s.charAt(j));
				}
				return key;
			}
		 
		 private void processFile(String s) throws IOException {
				FileInputStream fStream = new FileInputStream(s);
				BufferedReader br = new BufferedReader(new InputStreamReader(fStream));
		       String strLine;
		       while((strLine = br.readLine()) != null) {
					this.addWord(strLine);
				}
				br.close();
			}
		 
		 private ArrayList<Map.Entry<Long,ArrayList<String>>> getMaxEntries() {
				
				ArrayList<Map.Entry<Long,ArrayList<String>>> lists = new ArrayList<>(); 
				int max = 0;
			    
				for (Map.Entry<Long,ArrayList<String>> entry : anagramTable.entrySet()) {
					
				  if(entry.getValue().size() > max) {
						lists.clear();
						lists.add(entry);
						max = entry.getValue().size();
					} 
				  else if(entry.getValue().size() == max) {
						lists.add(entry);
					}
				}
				 return lists;
				 
			}
		 
		 public static void main(String[] args) {
				// TODO Auto-generated method stub
				Anagrams a = new Anagrams();
				final long startTime = System.nanoTime();
				try {
					a.processFile ("words_alpha.txt");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				ArrayList<Map.Entry<Long, ArrayList<String>>> maxEntries = a.getMaxEntries ();
				long hashCode = maxEntries.get(0).getKey();
				int length = maxEntries.get(0).getValue().size();
				final long estimatedTime = System.nanoTime() - startTime ;
				final double seconds = ((double)estimatedTime/1000000000);
				System.out.println("Elapsed Time : "+ seconds);
				System.out.println("Key of max anagrams: "+ hashCode);
				System.out.println("List of max anagrams: " + maxEntries.get(0).getValue());
				System.out.println("Length of list of max anagrams : "+ length);
			}

}
