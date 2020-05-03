package leetcodechallenge;

import java.util.HashMap;
import java.util.Map;

public class May3 {
	 public static boolean canConstruct(String ransomNote, String magazine) {
	        Map<Character,Integer>map= new HashMap<>();
	        for(int i=0;i<magazine.length();i++){
	            if(map.containsKey(magazine.charAt(i))){
	                int t=map.get(magazine.charAt(i));
	                t++;
	                map.put(magazine.charAt(i),t);
	            }
	            else{
	                map.put(magazine.charAt(i),1);
	            }
	        }
	        for(int j=0;j<ransomNote.length();j++){
	            if(map.get(ransomNote.charAt(j))==null||map.get(ransomNote.charAt(j))<=0)
	                return false;
	            else{
	                int t=map.get(ransomNote.charAt(j));
	                t--;
	                map.put(ransomNote.charAt(j),t);
	            }
	        }
	        return true;        
	    }

	public static void main(String[] args) {

	}

}
