import java.util.Arrays;
import java.util.Scanner;

public class QuickSortSimpleInput {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }

    public static int readInt(Scanner sc, String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.println("Entrada inválida; por favor ingresa solo números.");
            sc.next(); 
            System.out.print(prompt);
        }
        return sc.nextInt();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = readInt(sc, "¿Cuántos números quieres ordenar? ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = readInt(sc, "Ingresa el número #" + (i + 1) + ": ");
        }
        System.out.println("Antes: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Después: " + Arrays.toString(arr));
        sc.close();
    }
}
