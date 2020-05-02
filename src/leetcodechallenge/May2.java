package leetcodechallenge;

import java.util.HashMap;
import java.util.Map;

public class May2 {
	 public int numJewelsInStones(String J, String S) {
	       Map<Character,Integer>st= new HashMap<>();
	        for(int i=0;i<J.length();i++){
	            st.put(J.charAt(i),1);
	        }
	        int count=0;
	        for(int j=0;j<S.length();j++){
	            char key=S.charAt(j);
	            if(st.containsKey(key))
	                count++;
	        }
	        return count;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
