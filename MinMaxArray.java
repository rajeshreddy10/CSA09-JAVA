import java.util.Arrays;
public class MinMaxArray{
    public static void main (String[] args){
        int arr[]={5,3,8,2,56,42,90,53,21,48};
        int min=3;
        int max=2;
        Arrays.sort(arr);
        int min_el=arr[min-1];
        int max_el=arr[arr.length-max];
        int sum=min_el+max_el;
        int diff=max_el-min_el;
        System.out.println("minimum element: "+min_el);
        System.out.println("maximum element: "+max_el);
        System.out.println("addition: "+sum);
        System.out.println("difference: "+diff);
    }
}