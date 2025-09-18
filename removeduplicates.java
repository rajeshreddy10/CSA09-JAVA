import java.util.Arrays;

public class removeduplicates {
    public static void main(String[] args) {
        int[] arr = {4, 2, 8, 2, 4, 9, 1, 8, 3, 3};
        Arrays.sort(arr);
        System.out.print("Array without Duplicates: ");
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || arr[i] != arr[i - 1]) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
