/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class WeightedQuickUnion {
    private int id[];
    private int sz[];

    public WeightedQuickUnion(int n) {
        id = new int[n];
        sz = new int[n];

        for (int i = 0; i < id.length; i++) { // Initialize
            id[i] = i;
            sz[i] = 0;
        }
    }

    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    public int findRoot(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        sz[i]++;
        return i;
    }

    public void union(int p, int q) {
        int i = findRoot(p);
        int j = findRoot(q);

        if (i == j) return;

        if (sz[i] < sz[j]) {  // compare which one is larger
            id[i] = j;        // if number of objects in root j > i => link id i to root j
            sz[j] += sz[i];   // update new number of objects j => plus number of objects in i
        }
        else {
            id[j] = i;        // similar with above but in otherwise
            sz[i] += sz[j];
        }
    }

    public void printArray() {
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i] + " ");
        }
        System.out.println();
    }
}
