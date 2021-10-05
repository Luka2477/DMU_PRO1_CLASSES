package stars;

public class Stars {
    final int MAX_ROWS = 10;

    public void starPicture() {
        for (int row = 1; row <= MAX_ROWS; row++) {
            for (int star = 1; star <= row; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void starPictureA() {
        final int ROWS = 10;
        for(int i=ROWS; i>0; i--) {
            for(int j=0; j<i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void starPictureB() {
        final int ROWS = 10;
        for(int i=1; i<=ROWS; i++) {
            for(int spaces=0; spaces<ROWS-i; spaces++)
                System.out.print(" ");

            for(int stars=0; stars<i; stars++)
                System.out.print("*");

            System.out.println();
        }
    }

    public void starPictureC() {
        final int ROWS = 10;
        for(int i=0; i<ROWS; i++) {
            for(int spaces=0; spaces<i; spaces++)
                System.out.print("-");

            for(int stars=0; stars<ROWS-i; stars++)
                System.out.print("*");

            System.out.println();
        }
    }

    public void starPictureD() {
        final int ROWS = 5;
        for(int i=0; i<ROWS; i++) {
            for(int spaces=0; spaces<ROWS-(i+1); spaces++)
                System.out.print("-");

            for(int stars=0; stars<1+i*2; stars++)
                System.out.print("*");

            System.out.println();
        }

        for(int i=ROWS-1; i>=0; i--) {
            for(int spaces=0; spaces<ROWS-(i+1); spaces++)
                System.out.print("-");

            for(int stars=0; stars<1+i*2; stars++)
                System.out.print("*");

            System.out.println();
        }
    }

}
