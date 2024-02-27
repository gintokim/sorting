//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class SortingAlgorithms {

    // Пузырьковая сортировка
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Обмен элементов, если они стоят в неправильном порядке
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Быстрая сортировка
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                // Обмен элементов, если они стоят в неправильном порядке
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Обмен элементов, чтобы поместить опорный элемент в правильное место
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        // Создаем массивы для тестирования
        int[] smallArray = {5, 2, 9, 1, 5, 6};
        int[] largeArray = new int[10000];
        for (int i = 0; i < 10000; i++) {
            largeArray[i] = (int) (Math.random() * 1000);
        }

        // Измеряем время выполнения пузырьковой сортировки для небольшого массива
        long startTime = System.nanoTime();
        bubbleSort(smallArray);
        long endTime = System.nanoTime();
        System.out.println("Bubble Sort (small array): " + (endTime - startTime) + " nanoseconds");

        // Измеряем время выполнения быстрой сортировки для небольшого массива
        startTime = System.nanoTime();
        quickSort(smallArray, 0, smallArray.length - 1);
        endTime = System.nanoTime();
        System.out.println("Quick Sort (small array): " + (endTime - startTime) + " nanoseconds");

        // Измеряем время выполнения пузырьковой сортировки для крупного массива
        startTime = System.nanoTime();
        bubbleSort(largeArray);
        endTime = System.nanoTime();
        System.out.println("Bubble Sort (large array): " + (endTime - startTime) + " nanoseconds");

        // Измеряем время выполнения быстрой сортировки для крупного массива
        startTime = System.nanoTime();
        quickSort(largeArray, 0, largeArray.length - 1);
        endTime = System.nanoTime();
        System.out.println("Quick Sort (large array): " + (endTime - startTime) + " nanoseconds");
    }
}