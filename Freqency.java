import java.util.Arrays;
public class Freqency{
    public static void main(String[] args){
        int arr[] = {1,2,3,4,5,1,2,3,4,1,2,3,1,2,1};
        int n = arr.length;
        Arrays.sort(arr);
        int count =1;
        for(int i=0;i<n-1;i++){
            if(arr[i]==arr[i+1]){
                count++;
            }else{
                System.out.println(arr[i]+" : "+count);
                count=1;
            }
        }
        System.out.println(arr[n-1]+" : "+count);
    }
}