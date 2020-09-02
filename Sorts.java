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

}

}