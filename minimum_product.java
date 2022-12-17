class Solution {
    public static int solve(int N, int S) {
      
        /*approch: To make the product minimum  we will get as many possible occurrences
                   of 1 as possible (because 1 is smallest possible element of the array).
                we place 1 at n-1 indices and at last index we balance the sum.
                so last index value = S-(N-1).
                    */ 

        return S-(N-1);

    }
}
