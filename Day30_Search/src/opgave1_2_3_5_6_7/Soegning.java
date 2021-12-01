package opgave1_2_3_5_6_7;

import java.util.ArrayList;

public class Soegning {

    public boolean findUlige(int[] tabel) {
        int i = 0;
        boolean found = false;

        while (i < tabel.length && !found) {
            if (tabel[i] % 2 != 0) {
                found = true;
            } else {
                i++;
            }
        }

        return found;
    }

    // her skriver du metoder til opgaverne 2,3,5,6 og 7

    public int findiInterval (int[] tabel, int minBound, int maxBound) {
        int i = 0;
        int num = -1;

        while (i < tabel.length && num == -1) {
            if (tabel[i] >= minBound && tabel[i] <= maxBound) {
                num = tabel[i];
            } else {
                i++;
            }
        }

        return num;
    }

    public boolean findToSammen (int[] tabel) {
        int i = 1;
        boolean found = false;

        while (i < tabel.length && !found) {
            if (tabel[i-1] == tabel[i]) {
                found = true;
            } else {
                i++;
            }
        }

        return found;
    }

    public int beregnKvadratrodLinær (int n) {
        int r = 1;

        while (r * r <= n) {
            r++;
        }

        return r-1;
    }

    public int beregnKvadratrodBinær (int n) {
        int r = -1;
        int left = 1, right = n;

        while (left <= right && r == -1) {
            int middle = (left + right) / 2;
            int k1 = middle * middle;
            int k2 = (middle+1) * (middle+1);

            if (k1 == n || (k1 < n && k2 > n)) {
                r = middle;
            } else if (k1 > n) {
                right = middle-1;
            } else {
                left = middle+1;
            }
        }

        return r;
    }

    public int find (ArrayList<Integer> list, int n) {
        int i = 0;
        int index = -1;

        while (i < list.size() && index == -1) {
            if (list.get(i) == n) {
                index = i;
            } else {
                i++;
            }
        }

        if (index != 0) {
            int temp = list.get(index-1);
            list.set(index-1, list.get(index));
            list.set(index, temp);
            index--;
        }

        return index;
    }
}
