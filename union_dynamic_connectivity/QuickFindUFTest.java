/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class QuickFindUFTest {
    private int id[];

    public QuickFindUFTest(int n) {
        id = new int[n];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        if (!connected(p, q)) {
            for (int i = 0; i < id.length; i++) {
                if (id[i] == id[p] && i != p) {
                    id[i] = id[q];
                }
            }
            id[p] = id[q];
        }
    }

    public void printArray() {
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i] + " ");
        }
        System.out.println();
    }
}
