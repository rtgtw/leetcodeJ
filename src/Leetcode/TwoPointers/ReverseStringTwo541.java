package Leetcode.TwoPointers;


//Calculate how many chunks will be needed
//Length / 2K = chunks needed

//operation per chunk, then edge case for remainder

//chunk - 1 since it starts at 0, next chunk will be chunk + chunk-1
//if chunk + chunk -1 > or = length then we're done,
//if chunk + chunk - 1 < length then we have a remainder
public class ReverseStringTwo541 {

    public String reverseStr(String s, int k){
        //first convert String into character array
        char sCA[] = s.toCharArray();

        //Two pointers to move and swap
        //Right 1, left 0
        //right 5, left 4
        //k =2  2k = 4

        int left = 0;
        int right = k -1;
        //length of array
        int arrayLength = sCA.length - 1;


        //how many values we are doing our operations on
        int chunk = 2 * k;

        //far right bound
        int rightBound = chunk - 1;

        //remainder start
        int remainderLowerBound = rightBound + 1;


        if(sCA.length < chunk){
            if(sCA.length == 1 ){
                return new String(sCA);
            }
            if(arrayLength < right){
                right = sCA.length - 1;
                //Swap everything
                while(left < right){
                    char swap = ' ';
                    swap = sCA[left];
                    sCA[left] = sCA[right];
                    sCA[right] = swap;
                    left++;
                    right--;
                }
                return new String(sCA);
            }
            //Swap from 0 to k
            left = 0;
            right = k - 1;
            while (left < right){
                char swap = ' ';
                swap = sCA[left];
                sCA[left] = sCA[right];
                sCA[right] = swap;
                left++;
                right--;
            }

            return new String(sCA);
        }


        //Calculate how many chunks will be needed
        int chunksNeeded = sCA.length /  chunk;



        //Can decrement chunksNeeded in while loop
        while(chunksNeeded > 0){

            //currently on pointers to swap
            while(left < right){
                char swap = ' ';
                swap = sCA[left];
                sCA[left] = sCA[right];
                sCA[right] = swap;
                left++;
                right--;
            }

            //once the swap is made we can decrement chunks needed and move to the remainder
            chunksNeeded--;

            if(chunksNeeded > 0) {
                //Finished with a chunk, now we have to change left and right to equal the next chunk
                left = left + chunk;
                right = right + chunk;
                rightBound = rightBound + chunk;
            }
        }

        //have the far right bound
        //array length - right bound = remainder
        if(arrayLength - rightBound == 0){
            //return array
            return new String(sCA);
        }
        else if(arrayLength - rightBound < chunk && arrayLength - rightBound > k){
            //reverse the first two
            //remainder starts at right bound+1
            char swap = ' ';
            swap = sCA[remainderLowerBound];
            sCA[remainderLowerBound] = sCA[remainderLowerBound + 1];
            sCA[remainderLowerBound + 1] = swap;
        }
                else if(arrayLength - rightBound < k){
            //reverse them all
            //start at remainderLowerBound to arrayLength
            while(remainderLowerBound < arrayLength){
                //swap
                char swap = ' ';
                swap = sCA[remainderLowerBound];
                sCA[remainderLowerBound] = sCA[arrayLength];
                sCA[arrayLength] = swap;
                remainderLowerBound++;
                arrayLength--;
            }
        }

        return new String(sCA);
    }

    public static void main(String args[]){
        String s = "abcdefg";
        String s1 = "abcd";
        int k = 8;
        ReverseStringTwo541 sol = new ReverseStringTwo541();
        System.out.println(sol.reverseStr(s,k));
    }
}
