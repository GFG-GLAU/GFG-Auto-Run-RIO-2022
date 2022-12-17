class Solution{
    public boolean solve(int N, String S1, String S2, String S3){
    //convert the strings into character arrays
    char[] ch1=S1.toCharArray();
    char[] ch2=S2.toCharArray();
    char[] ch3=S3.toCharArray();

    //sort all three  arrays
    Arrays.sort(ch1);
    Arrays.sort(ch3);
    Arrays.sort(ch2);

    //check if any two arrays are equal
    //if any two arrays found equal then return true otherwise return false

    //comparing ch1 and ch2 arrays 
    int flag=0;
    for(int i=0;i<ch1.length;i++){
        if(ch1[i]!=ch2[i]) 
            {
                flag=1;
                break;
            }
    }
    // flag==1 means there exist a index where characters are not same.
    if(flag==0) return true;   


    //if ch1 and ch2 are not equal then compare ch1 and ch3 array
    flag=0;
    for(int i=0;i<ch1.length;i++){
        if(ch1[i]!=ch3[i]) 
        {
            flag=1;
            break;
        }
    }
    if(flag==0) return true; 

    // ch1 and ch3 are not equal then compare ch2 and ch3 array
    flag=0;
    for(int i=0;i<ch2.length;i++){
        if(ch2[i]!=ch3[i]) 
        {
            flag=1;
            break;
        }
    }
    if(flag==0) return true; 

    return false;//if all arrays are different return false
    }
}
