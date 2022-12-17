class Solution { 
    boolean checkSorted(int N, int arr[]){ 

        //The sorted array will look like [1,2,3,4,...n]
        //we can observe that the position of k is at index (k-1). [k is any natural number]
        // so our task is to place the elements at their actual position
        // and  if it happens in exactly 2 swaps then return true otherwise return false.



        if(N==1) //single element can not be swapped.
            return false;
        int c=0; //counter to count the swaps
        for(int i=0;i<N;i++)
        {
            if(arr[i]!=i+1)  /*if ith element is at wrong position 
                            then swap it with element placed at its actual position*/
            {
               int temp= arr[arr[i]-1];  
               arr[arr[i]-1]=arr[i];
               arr[i]=temp;
                c++; //increase the counter by 1

                if(arr[i]!=i+1)   /*after swapping check again,if element  at ith position is at wrong position 
                            then swap it with element placed at its actual position*/
                {
                   temp= arr[arr[i]-1];
                    arr[arr[i]-1]=arr[i];
                    arr[i]=temp;
                    c++; // again increase counter by 1
                }
            }
        }
        if(c==0||c==2) //for counter = 0(already sorted array) ,we can swap same pair of index two times to make counter=2.
        return true;
        return false;
    }
}
