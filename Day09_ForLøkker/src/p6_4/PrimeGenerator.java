package p6_4;

public class PrimeGenerator {
    private int number;

    public PrimeGenerator(int number) {
        this.number = number;
    }

    public int nextPrime() {
        int number = this.number+1;
        while(true) {
            if(this.isPrime(number)) {
                this.number = number;
                return number;
            }

            number++;
        }
    }

    public boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0)
                return false;
        }

        return true;
    }
}
