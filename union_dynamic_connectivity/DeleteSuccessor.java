/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class DeleteSuccessor {
    private int id[];

    public int smallestScuccssor(int x) {
        return id[binarySearch(x)+1];
    }

    public int binarySearch(int x){
        int last = id.length;
        int first = 0;
        int middle = 0;

        while(true)
            middle = (last+first)/2;
            if(id[middle] > x){
                last = middle;
            }
            if(id[middle] < x) {
                first = middle;
            }
            if(id[middle] == x){
                return middle;
            }
        }
    }
}
