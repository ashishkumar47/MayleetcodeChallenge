package leetcodechallenge;

public class May1 {
	public  static int firstBadVersion(int n) {
	      int mid=0,start=1,end=n;
	        while(start<=end){
	            mid=start+(end-start)/2;
//	            if(!isBadVersion(mid))
//	                start=mid+1;
//	            else
//	                end=mid-1;
	        }
	        return start+(end-start)/2;
	    }

	public static void main(String[] args) {

	}

}
