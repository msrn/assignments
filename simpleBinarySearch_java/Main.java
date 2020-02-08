import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter array size");
        int arraySize = getInput();

        int[] array = new int[arraySize];
        generateArray(array);
        System.out.println(Arrays.toString(array));

        System.out.println("Enter number to search for");
        int num = getInput();

        int returnIndex = binarySearch(array, num);
        if (returnIndex <= - 1) {
            System.out.println(num + " Not found");
        } else {
            System.out.println(num + " found at index (" + returnIndex + ")");
        }

    }


    public static int binarySearch(int[] arr, int value) throws IndexOutOfBoundsException {

        int left = 0;
        int right = arr.length - 1;
        int middle = 0;

        while (left <= right) {
            assert (left <= right);
            middle = left + (right-left)/2;

            if(arr[middle] == value) {
                return middle;
            }
            if(value < arr[middle]) {
                right = middle-1;
            } else if (value > arr[middle]){
                left = middle + 1;
            } else {
                throw new AssertionError("");
            }
        }
        return -1;

    }

    public static void generateArray(int[] arr) {
        assert (arr.length >= 0);
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100) + 1;
        }
        Arrays.sort(arr);
    }

    public static Integer getInput() {
        int input = 0;
        Scanner sc = new Scanner(System.in);
        try {
            while (input <= 0) {
                assert(input <= 0);
                System.out.print("> ");
                input = Integer.parseInt(sc.nextLine());
                if (input <= 0) {
                    System.out.println("Must be positive");
                }
            }
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            throw new AssertionError("Input not valid (must be integer)");
        }
        return input;
    }
}
