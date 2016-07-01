/*
Given an array of citations (each citation is a non-negative integer) of a researcher, 
write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations 
each, and the other N − h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 
0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with 
no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.

Hint:

An easy approach is to sort the array first.
What are the possible values of h-index?
A faster approach is to use extra space.
*/

public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length==0){
            return 0;
        }
        quickSort(citations, 0, citations.length-1);
        /*int max = 0;
       for (int i = 0; i < citations.length; i++) {
            if (citations.length - i >= citations[i])
                max = Math.max(max, citations[i]);
            else 
                max = Math.max(max, citations.length - i);
        }
        return max;*/
         for(int i = 0; i < citations.length; ++i){
              if(citations[i] >= citations.length - i){
                  return citations.length - i;
              }
         }
         return 0;
    }
    
    public void quickSort(int[] citations, int low, int high){
        if (low<high){
            int pos = partion(citations, low, high);
            quickSort(citations, low, pos-1);
            quickSort(citations, pos+1, high);
        }
    }
    
    public int partion(int[] citations, int low, int high){
        int pivotkey = citations[low];
        while (low < high){
            while (low < high && citations[high] >= pivotkey){
                high--;
            }
            citations[low] = citations[high];
            while (low < high && citations[low] <= pivotkey){
                low++;
            }
            citations[high] = citations[low];
        }
        citations[low] = pivotkey;
        return low;
    }
}
