import java.util.Arrays;

public class Sorts {

    public static void MergeSort(int[] array) {
        if (array.length < 2) {
            return;
        }

        int mid = array.length/2;

        int[] leftArray = new int[mid];
        int[] rightArray = new int[array.length - mid];

        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = array[i];
        }

        for (int a = 0; a < rightArray.length; a++){
            rightArray[a] = array[mid];
            mid++;
        }
        

        MergeSort(leftArray);
        MergeSort(rightArray);
        
        
        Merge(leftArray, rightArray, array);
        
       
      

    }

    public static void Merge(int[] left, int[] right, int[] inital) {
        int k = 0;
        int i = 0; 
        int j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] > right[j]) {
                inital[k++] = right[j++];
            }
            else {
                inital[k++] = left[i++];
            }
        }
        while (i < left.length) {
            inital[k++] = left[i++];
        }
        while (j < right.length) {
            inital[k++] = right[j++];
        }

                
    }

    public static void QuickSort(int[] array) {
        int start = 0; 
        int end = array.length;
        QuickSortH(array, start, end);
    }

    public static void QuickSortH(int[] array, int start, int end) {

        int pivot = start;
        int length = end - start;

        if (length < 2) {
            return;
        }

        int left = array[start];
        int middle = array[start + (length / 2)];
        int right = array[end - 1];

        int median = Median(left,middle,right);

        if (median == left) {
            pivot = start;
        }
        else if (median == right) {
            pivot = start + (length - 1);
        }
        else if (median == middle) {
            pivot = start + (length / 2);
        }
        
        Swap(pivot, (end - 1), array);
       
        int itemFromLeft = start;
        int itemFromRight = end - 1;

        while (itemFromLeft < itemFromRight) {
            if (array[itemFromLeft] > array[end - 1] && array[itemFromRight] < array[end - 1]) {
                Swap (itemFromLeft, itemFromRight, array);
                itemFromLeft++;
                itemFromRight--;
            } else if (array[itemFromLeft] <= array[end - 1] && array[itemFromRight] <= array[end - 1]){
                itemFromLeft++;
            } else if (array[itemFromRight] >= array[end - 1] && array[itemFromLeft] >= array[end - 1]){
                itemFromRight--;
            } else {
                itemFromLeft++;
                itemFromRight--;
            }
            
        }

        Swap (itemFromLeft, end - 1, array);
        QuickSortH(array, itemFromLeft, end);
        QuickSortH(array, start, itemFromLeft);
    }

    public static void Swap(int firstIndex, int secondIndex, int[] array) {
        int temp = array[secondIndex];
        array[secondIndex] = array[firstIndex];
        array[firstIndex] = temp;
    }

    public static int Median(int a, int b, int c) {
        return Math.max(Math.min(a,b), Math.min(Math.max(a,b),c));
    }


    public static void BubbleSort (int[] array) {
        for (int i = 1; i <array.length; i++) {
            for (int a = 0; a < array.length - 1; a++ ){
                if (array[a] > array[a + 1]) {
                    Swap(a, a + 1, array);
                }
            }
        }
    }

    public static void InsertionSort (int[] array) {
        int helper = 0;
        for (int i = 1; i < array.length; i++) {
            helper = i - 1;
            while (helper >= 0 && array[helper + 1] < array[helper]) {
                Swap(helper + 1, helper, array);
                helper--;
            }
        }
    }
    
    public static void SelectionSort (int[] array) {
        int minIndex = 0;
        for (int i = 0; i < array.length - 1; i++) {
            minIndex = i;
            for (int a = i + 1; a < array.length; a++) {
                if (array[a] < array[minIndex]) {
                    minIndex = a;
                }
            }
            Swap(i, minIndex, array);
        }
    }

    public static void Heapify(int index, int length, int[] array) {

        int leftNode = index * 2 + 1;
        int rightNode = index * 2 + 2;
        int max = index;

        if (leftNode < length && array[leftNode] > array[max]) {
            max = leftNode;
        }

        if (rightNode < length && array[rightNode] > array[max]) {
            max = rightNode;
        }

        if (index != max) {
            Swap(index, max, array);
            Heapify(max, length, array);
        }

    }

    public static void MaxHeap(int[] array) {
        
        int length = array.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            Heapify(i, length, array);
        }

    }

    public static void HeapSort(int[] array) {

        MaxHeap(array);

        int length = array.length;
        for (int i = length - 1; i > 0; i--) {
            Swap(0, i, array);
            Heapify(0, i, array);
        }

    }

    public static void PancakeSort(int[] array) {
        PancakeSortH(array, array.length);
    }

    public static boolean PancakeCheck(int[] array, int length) {
        for (int i = 1; i < length; i++) {
            if (array[i-1] > array[i]) {
                return false;
            }
        }
        return true;
    }

    public static void PancakeReverse(int[] array, int index) {

        for (int i = 0; i < Math.floor(index/2); i++) {
            Swap(i, index - i - 1, array);
        }
        
    }

    public static void PancakeSortH(int[] array, int length) {
        boolean check = PancakeCheck(array, length);

        if (!check) {
            int local_max = array[0];
            int index = -1;
            for (int i = 0; i < length; i++) {
                if (array[i] > local_max) {
                    local_max = array[i];
                    index = i;
                }
            }
            PancakeReverse(array, index + 1);
            PancakeReverse(array, length);
            length--;

            PancakeSortH(array, length);
        }
    }


    public static void main(String[] args) {
        int[] edgeCase = {0};
        int[] edgeCase1 = {};
        int[] edgeCase2 = {-23,-5,-6,-7,-231,543,0};
        int[] edgeCase3 = {-22,-5,-5,-5,-5,5,0};

        System.out.println("----------Merge Sort----------");
        System.out.println("Testing Edge Cases");
        System.out.println("\nEdge Case 1: " + Arrays.toString(edgeCase));
        MergeSort(edgeCase);
        System.out.println("Edge Case 1 Result: " + Arrays.toString(edgeCase));
        System.out.println("\nEdge Case 2: " + Arrays.toString(edgeCase1));
        MergeSort(edgeCase1);
        System.out.println("Edge Case 2 Result: " + Arrays.toString(edgeCase1));
        System.out.println("\nEdge Case 3: " + Arrays.toString(edgeCase2));
        MergeSort(edgeCase2);
        System.out.println("Edge Case 3 Result: " + Arrays.toString(edgeCase2));
        System.out.println("\nEdge Case 4: " + Arrays.toString(edgeCase3));
        MergeSort(edgeCase3);
        System.out.println("Edge Case 4 Result: " + Arrays.toString(edgeCase3));

        edgeCase = new int[]{0};
        edgeCase1 = new int[]{};
        edgeCase2 = new int[]{-23,-5,-6,-7,-231,543,0};
        edgeCase3 = new int[]{-22,-5,-5,-5,-5,5,0};
        
        System.out.println("----------Quick Sort----------");
        System.out.println("Testing Edge Cases");
        System.out.println("\nEdge Case 1: " + Arrays.toString(edgeCase));
        QuickSort(edgeCase);
        System.out.println("Edge Case 1 Result: " + Arrays.toString(edgeCase));
        System.out.println("\nEdge Case 2: " + Arrays.toString(edgeCase1));
        QuickSort(edgeCase1);
        System.out.println("Edge Case 2 Result: " + Arrays.toString(edgeCase1));
        System.out.println("\nEdge Case 3: " + Arrays.toString(edgeCase2));
        QuickSort(edgeCase2);
        System.out.println("Edge Case 3 Result: " + Arrays.toString(edgeCase2));
        System.out.println("\nEdge Case 4: " + Arrays.toString(edgeCase3));
        QuickSort(edgeCase3);
        System.out.println("Edge Case 4 Result: " + Arrays.toString(edgeCase3));

        edgeCase = new int[]{0};
        edgeCase1 = new int[]{};
        edgeCase2 = new int[]{-23,-5,-6,-7,-231,543,0};
        edgeCase3 = new int[]{-22,-5,-5,-5,-5,5,0};
        
        System.out.println("----------Bubble Sort----------");
        System.out.println("Testing Edge Cases");
        System.out.println("\nEdge Case 1: " + Arrays.toString(edgeCase));
        BubbleSort(edgeCase);
        System.out.println("Edge Case 1 Result: " + Arrays.toString(edgeCase));
        System.out.println("\nEdge Case 2: " + Arrays.toString(edgeCase1));
        BubbleSort(edgeCase1);
        System.out.println("Edge Case 2 Result: " + Arrays.toString(edgeCase1));
        System.out.println("\nEdge Case 3: " + Arrays.toString(edgeCase2));
        BubbleSort(edgeCase2);
        System.out.println("Edge Case 3 Result: " + Arrays.toString(edgeCase2));
        System.out.println("\nEdge Case 4: " + Arrays.toString(edgeCase3));
        BubbleSort(edgeCase3);
        System.out.println("Edge Case 4 Result: " + Arrays.toString(edgeCase3));

        edgeCase = new int[]{0};
        edgeCase1 = new int[]{};
        edgeCase2 = new int[]{-23,-5,-6,-7,-231,543,0};
        edgeCase3 = new int[]{-22,-5,-5,-5,-5,5,0};

        System.out.println("----------Insertion Sort----------");
        System.out.println("Testing Edge Cases");
        System.out.println("\nEdge Case 1: " + Arrays.toString(edgeCase));
        InsertionSort(edgeCase);
        System.out.println("Edge Case 1 Result: " + Arrays.toString(edgeCase));
        System.out.println("\nEdge Case 2: " + Arrays.toString(edgeCase1));
        InsertionSort(edgeCase1);
        System.out.println("Edge Case 2 Result: " + Arrays.toString(edgeCase1));
        System.out.println("\nEdge Case 3: " + Arrays.toString(edgeCase2));
        InsertionSort(edgeCase2);
        System.out.println("Edge Case 3 Result: " + Arrays.toString(edgeCase2));
        System.out.println("\nEdge Case 4: " + Arrays.toString(edgeCase3));
        InsertionSort(edgeCase3);
        System.out.println("Edge Case 4 Result: " + Arrays.toString(edgeCase3));

        edgeCase = new int[]{0};
        edgeCase1 = new int[]{};
        edgeCase2 = new int[]{-23,-5,-6,-7,-231,543,0};
        edgeCase3 = new int[]{-22,-5,-5,-5,-5,5,0};

        System.out.println("----------Selection Sort----------");
        System.out.println("Testing Edge Cases");
        System.out.println("\nEdge Case 1: " + Arrays.toString(edgeCase));
        SelectionSort(edgeCase);
        System.out.println("Edge Case 1 Result: " + Arrays.toString(edgeCase));
        System.out.println("\nEdge Case 2: " + Arrays.toString(edgeCase1));
        SelectionSort(edgeCase1);
        System.out.println("Edge Case 2 Result: " + Arrays.toString(edgeCase1));
        System.out.println("\nEdge Case 3: " + Arrays.toString(edgeCase2));
        SelectionSort(edgeCase2);
        System.out.println("Edge Case 3 Result: " + Arrays.toString(edgeCase2));
        System.out.println("\nEdge Case 4: " + Arrays.toString(edgeCase3));
        SelectionSort(edgeCase3);
        System.out.println("Edge Case 4 Result: " + Arrays.toString(edgeCase3));

        edgeCase = new int[]{0};
        edgeCase1 = new int[]{};
        edgeCase2 = new int[]{-23,-5,-6,-7,-231,543,0};
        edgeCase3 = new int[]{-22,-5,-5,-5,-5,5,0};

        System.out.println("----------Heap Sort----------");
        System.out.println("Testing Edge Cases");
        System.out.println("\nEdge Case 1: " + Arrays.toString(edgeCase));
        HeapSort(edgeCase);
        System.out.println("Edge Case 1 Result: " + Arrays.toString(edgeCase));
        System.out.println("\nEdge Case 2: " + Arrays.toString(edgeCase1));
        HeapSort(edgeCase1);
        System.out.println("Edge Case 2 Result: " + Arrays.toString(edgeCase1));
        System.out.println("\nEdge Case 3: " + Arrays.toString(edgeCase2));
        HeapSort(edgeCase2);
        System.out.println("Edge Case 3 Result: " + Arrays.toString(edgeCase2));
        System.out.println("\nEdge Case 4: " + Arrays.toString(edgeCase3));
        HeapSort(edgeCase3);
        System.out.println("Edge Case 4 Result: " + Arrays.toString(edgeCase3));
        
        edgeCase = new int[]{0};
        edgeCase1 = new int[]{};
        edgeCase2 = new int[]{-23,-5,-6,-7,-231,543,0};
        edgeCase3 = new int[]{-22,-5,-5,-5,-5,5,0};

        System.out.println("----------Pancake Sort----------");
        System.out.println("Testing Edge Cases");
        System.out.println("\nEdge Case 1: " + Arrays.toString(edgeCase));
        PancakeSort(edgeCase);
        System.out.println("Edge Case 1 Result: " + Arrays.toString(edgeCase));
        System.out.println("\nEdge Case 2: " + Arrays.toString(edgeCase1));
        PancakeSort(edgeCase1);
        System.out.println("Edge Case 2 Result: " + Arrays.toString(edgeCase1));
        System.out.println("\nEdge Case 3: " + Arrays.toString(edgeCase2));
        PancakeSort(edgeCase2);
        System.out.println("Edge Case 3 Result: " + Arrays.toString(edgeCase2));
        System.out.println("\nEdge Case 4: " + Arrays.toString(edgeCase3));
        PancakeSort(edgeCase3);
        System.out.println("Edge Case 4 Result: " + Arrays.toString(edgeCase3));

}

}