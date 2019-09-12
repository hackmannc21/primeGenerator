package literateProgramming;


public class PrimePrinter {
    public static void main(String[] args) {
        final int numPrime = 1000;
        PrimeGenerator primeGenerator = new PrimeGenerator(numPrime);
        NumberPrinter numberPrinter = new NumberPrinter(4, 50);
        numberPrinter.print(numPrime, primeGenerator.generate());
    }

}
