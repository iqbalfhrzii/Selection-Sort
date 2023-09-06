import java.util.Random;
import java.util.Scanner;

public class SelectionSort {
    private int[] array;

    public SelectionSort(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public void selectionSortWithProcess() {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                swapValues(i, minIndex);
                displayArray();
            }
        }
    }

    private void swapValues(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void displayArray() {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah elemen array yang diinginkan: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        Random random = new Random();
        System.out.println("Angka acak:");

        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(10000);
        }

        SelectionSort sorter = new SelectionSort(arr);

        System.out.println("List Angka sebelum diurutkan:");
        sorter.displayArray();

        long startTime = System.currentTimeMillis(); // Waktu awal

        sorter.selectionSortWithProcess(); // Panggil metode pengurutan

        long endTime = System.currentTimeMillis(); // Waktu akhir
        long executionTime = endTime - startTime; // Menghitung waktu eksekusi

        System.out.println("\nList Angka setelah diurutkan:");
        sorter.displayArray();

        System.out.println("\nWaktu eksekusi: " + (executionTime / 1000.0) + " detik");

        scanner.close();
    }

}
