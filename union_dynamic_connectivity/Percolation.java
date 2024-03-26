/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** *

 */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[][] site;
    private WeightedQuickUnionUF checkIsFullUnion;
    private WeightedQuickUnionUF checkIsPercolation;
    private int rootTop;
    private int rootBottom;
    private int countOpenedSite;
    private int length;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        site = new boolean[n][n];
        rootTop = n * n; // 25
        rootBottom = n * n + 1;
        length = n;
        countOpenedSite = 0;
        checkIsFullUnion = new WeightedQuickUnionUF(rootTop + 1); // 26 => 0 -> 25
        checkIsPercolation = new WeightedQuickUnionUF(rootBottom + 1); // 27 => 0 -> 26
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (checkIndex(row, col)) {
            if (!isOpen(row, col)) {
                site[row][col] = true;
                countOpenedSite++;
            }
            if (row == 0) {
                checkIsFullUnion.union(col, rootTop);
                checkIsPercolation.union(col, rootTop);
            }
            if (row == length - 1) {
                checkIsPercolation.union(row * length + col, rootBottom);
            }

            if (row > 0 && isOpen(row - 1, col)) {
                checkIsFullUnion.union(row * length + col, (row - 1) * length + col);
            }

            if (row < length - 1 && isOpen(row + 1, col)) {
                checkIsFullUnion.union(row * length + col, (row + 1) * length + col);
            }
            if (col > 0 && isOpen(row, col - 1)) {
                checkIsFullUnion.union(row * length + col, (row) * length + col - 1);
            }
            if (col < length - 1 && isOpen(row, col + 1)) {
                checkIsFullUnion.union(row * length + col, (row) * length + col + 1);
            }
        }
        else {
            throw new IndexOutOfBoundsException();
        }

    }

    public boolean checkIndex(int row, int col) {
        if (row < 1 || row > length - 1 || col < 1 || col > length - 1) return false;
        return true;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) { // fixed
        if (checkIndex(row, col)) {
            return site[row][col];
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (checkIndex(row, col)) {
            return checkIsFullUnion.find(rootTop) == checkIsFullUnion.find(row * length + col);
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return countOpenedSite;
    }

    // does the system percolate?
    public boolean percolates() {
        return checkIsPercolation.find(rootTop) == checkIsPercolation.find(rootBottom);
    }


}
