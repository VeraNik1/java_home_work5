package HomeWork5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
/*
* Учитывая два целочисленных массива nums1 и nums2, верните максимальную длину подмассива, который появляется в обоих массивах.

Example 1:
Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
Output: 3
Explanation: Повторяющийся подмассив с максимальной длиной равен [3,2,1].

Example 2:
Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0,0]
Output: 5
Explanation: Повторяющийся подмассив с максимальной длиной равен [0,0,0,0,0].

* */
public class Main {
    public static void main(String[] args) {
    // пример 1
    int [] nums1 = {1,2,3,2,1};
    int [] nums2 = {3,2,1,4,7};
    examples(nums1, nums2);    
    // пример 2    
    int [] nums3 = {0,0,0,0,0};
    int [] nums4 = {0,0,0,0,0,0};     
    examples(nums3, nums4);
    // пример 3    
    int [] nums5 = {1,2,3,4,5};
    int [] nums6 = {6,7,8,9,10};     
    examples(nums5, nums6);
    // пример 4    
    int [] nums7 = {1,2,3,4,5,6};
    int [] nums8 = {4,5,6,2,3,4,5,6,1,2,3,4,5};     
    examples(nums7, nums8);
    // пример 5
    int [] nums9 = {1,2,3,4,5};
    int [] nums10 = {5,4,3,2,1};     
    examples(nums9, nums10);  
    }
    
    // метод examples для обработки примеров
    
    private static void examples(int[] n1, int[] n2) {
        System.out.println(Arrays.toString(n1));
        System.out.println(Arrays.toString(n2));
        maxSubArray(n1, n2);
        System.out.println();
    }

    /**
     * Метод getSets возвращает множество подмассивов исходного массива
     *
     * array - исходный массив
     * tempSubSet - множество подмассивов исходного массива
     */
    private static HashSet<ArrayList<Integer>> getSets(int[] array) {
        HashSet<ArrayList<Integer>> tempSubSet = new HashSet<>();
        for (int n = 1; n <= array.length; n++) {
            for (int i = 0; i < array.length; i++) {
                ArrayList<Integer> tempArray = new ArrayList<>();
                for (int j = i; j < i + n; j++) {
                    if (j >= array.length) break;
                    tempArray.add(array[j]);
                }
             tempSubSet.add(tempArray);
            }
        }
        return tempSubSet;
    }
    /**
     * maxSubArray - метод находит есть ли общие подмассивы, выводит максимальные
     * nums1 - первый массив
     * nums2 - второй массив
     */
    private static void maxSubArray(int[] nums1, int[] nums2) {

        HashSet<ArrayList<Integer>> tempSubSet1 = getSets(nums1);  // получаем множества
        HashSet<ArrayList<Integer>> tempSubSet2 = getSets(nums2);  // подмассивов каждого входного массива
        tempSubSet2.retainAll(tempSubSet1); // находим одинаковые подмассивы пересечением множеств
        int max = 0;
        ArrayList<ArrayList<Integer>> maxSubArrays = new ArrayList<>();
        for (ArrayList<Integer> item : tempSubSet2) { // определяем самый большой размер подмассива
        if (max < item.size()) {
                max = item.size();
                maxSubArrays = new ArrayList<>();
                maxSubArrays.add(item);
        }
        else if(max == item.size()){
            maxSubArrays.add(item);
        }       
        }

        if (max == 0) {// выходим если нет повторяющихся подмассивов
            System.out.println("Повторяющихся подмассивов нет");
            return;
        }
        System.out.printf("Максимальный размер общего подмассива: %d\n", max);
        if (maxSubArrays.size() > 1) {
            System.out.print("Подмассивы с максимальным размером: ");
        } else {
            System.out.print("Подмассив максимального размера равен: ");
        }
        for (ArrayList<Integer> i : maxSubArrays) {
            System.out.print(i + " ");
        }
    }

}
