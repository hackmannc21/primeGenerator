package literateProgramming;


public class PrimePrinter {
    public static void main(String[] args) {
        final int numPrime = 1000;
      int[] primes = generatePrimes(numPrime);
      printNumbers(numPrime, primes);
    }

  private static void printNumbers(int numPrime, int[] primes) {
    int pageNumber = 1;
    int pageoffset = 1;
    final int colsPerPage = 4;
    final int rowPerPage = 50;
    while (pageoffset <= numPrime) {
        System.out.print("The First ");
        System.out.print(Integer.toString(numPrime));
        System.out.print(" Prime Numbers --- Page ");
        System.out.print(Integer.toString(pageNumber));
        System.out.println("\n");
        for (int rowoffset = pageoffset; rowoffset <= pageoffset + rowPerPage - 1; rowoffset++) {
            for (int col = 0; col <= colsPerPage - 1; col++)
                if (rowoffset + col * rowPerPage <= numPrime)
                    System.out.printf("%10d", primes[rowoffset + col * rowPerPage]);
            System.out.println();
        }
        System.out.println("\f");
        pageNumber++;
        pageoffset += rowPerPage * colsPerPage;
    }
  }

  private static int[] generatePrimes(int numPrime) {
    final int ORDMAX = 30;
    int primes[] = new int[numPrime + 1];
    int multiples[] = new int[ORDMAX + 1];
    int candidatePrime = 1;
    int lastPrimeIndex = 1;
    primes[1] = 2;
    int ORD = 2;
    int nextPrimeSquare = 9;
    int N = 0;

    while (lastPrimeIndex < numPrime) {
        boolean maybePrime;
        do {
            candidatePrime += 2;
            if (candidatePrime == nextPrimeSquare) {
                ORD++;
                nextPrimeSquare = primes[ORD] * primes[ORD];
                multiples[ORD - 1] = candidatePrime;
            }
            N = 2;
            maybePrime = true;
            while (N < ORD && maybePrime) {
                while (multiples[N] < candidatePrime)
                    multiples[N] += primes[N] + primes[N];
                if (multiples[N] == candidatePrime)
                    maybePrime = false;
                N++;
            }
        } while (!maybePrime);
        lastPrimeIndex++;
        primes[lastPrimeIndex] = candidatePrime;
    }
    return primes;
  }
}
