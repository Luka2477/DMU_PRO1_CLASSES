package modelarray;

public class ArrayMethods {
    public void printArray(int[] tabel) {
        System.out.print("{");
        for (int i = 0; i < tabel.length; i++) {
            if (i == 0) {
                System.out.print(tabel[i]);
            }
            else {
                System.out.print(", " + tabel[i]);
            }
        }
        System.out.println("}  ");
    }

    /**
     *
     * @return et array med indhold [0,0,0,0,0,0,0,0,0,0]
     */
    public int[] fyldArrayA() {
        return new int[10];
    }
    
    /**
     *
     * @return et array med indhold [2,44,-23,99,8,-5,7,10,20,30]
     */
    public int[] fyldArrayB() {
        //int[] result = new int[10];
        return new int[]{2,44,-23,99,8,-5,7,10,20,30};
    }
    
    /**
     *
     * @return et array med indhold [0,1,2,3,4,5,6,7,8,9]
     */
    public int[] fyldArrayC() {
        int[] result = new int[10];
        for(int i=0; i<result.length; i++) {
            result[i] = i;
        }
        return result;
    }

    /**
     *
     * @return et array med indhold [2,4,6,8,10,12,14,16,18,20]
     */
    public int[] fyldArrayD() {
        int[] result = new int[10];
        for(int i=1; i<=result.length; i++) {
            result[i-1] = i*2;
        }
        return result;
    }

    /**
     *
     * @return et array med indhold [1,4,9,16,25,36,49,64,81,100]
     */
    public int[] fyldArrayE() {
        int[] result = new int[10];
        for(int i=1; i<=result.length; i++) {
            result[i-1] = i*i;
        }
        return result;
    }

    /**
     *
     * @return et array med indhold [0,1,0,1,0,1,0,1,0,1]
     */
    public int[] fyldArrayF() {
        int[] result = new int[10];
        for(int i=0; i<result.length; i++) {
            result[i] = i % 2;
        }
        return result;
    }

    /**
     *
     * @return et array med indhold [0,1,2,3,4,0,1,2,3,4]
     */
    public int[] fyldArrayG() {
        int[] result = new int[10];
        for(int i=0; i<result.length; i++) {
            result[i] = i % 5;
        }
        return result;
    }
    
    public int findMax(int[] tabel) {
        int max = -1;
        for (int j : tabel) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }

    //------------------------------------------------------------------------------------

    public int sum(int[] t) {
        int sum = 0;
        for(int element : t)
            sum += element;

        return sum;
    }

    public double sum(double[] t) {
        double sum = 0;
        for(double element : t)
            sum += element;

        return sum;
    }

    public int[] makeSum(int[] a, int[] b) {
        int shortestLength = Math.min(a.length, b.length);
        int[] longest = (a.length > b.length) ? a : b;
        int[] sums = new int[longest.length];

        for(int i=0; i<shortestLength; i++)
            sums[i] = a[i] + b[i];

        System.arraycopy(longest, shortestLength, sums, shortestLength, longest.length - shortestLength);

        return sums;
    }

    public boolean hasUneven(int[] t) {
        for(int element : t)
            if(element % 2 != 0)
                return true;

        return false;
    }
}
