/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class PathCompressionQuickUnion {
    private int id[];
    private int sz[];

    public PathCompressionQuickUnion(int n) {
        id = new int[n];

        for (int i = 0; i < id.length; i++) { // Initialize
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    public int findRoot(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public void union(int p, int q) {
        int i = findRoot(p);
        int j = findRoot(q);

        if (i == j) return;
        
    }

    public void printArray() {
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i] + " ");
        }
        System.out.println();
    }
}
