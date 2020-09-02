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
        int[] edgeCase = {0,0,0,0,2,0,0,0,0};
        MergeSort(edgeCase);
         System.out.println(Arrays.toString(edgeCase));
}

}