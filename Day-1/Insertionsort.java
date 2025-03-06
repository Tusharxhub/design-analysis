// ! Wap to perform Insertion sort for any given list of numbers.

public class Insertionsort {

    public static void main(String[] args) {
        int[] arr = { 5, 2, 8, 7, 1, 3, 9, 4, 6 };
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}


//? Time Complexity: in best case O(n), in worst case O(n^2)
//? Space Complexity: O(1)