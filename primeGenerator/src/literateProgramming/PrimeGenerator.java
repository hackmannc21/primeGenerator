package literateProgramming;

class PrimeGenerator {
    private int numPrime;

    public PrimeGenerator(int numPrime) {
        this.numPrime = numPrime;
    }

    public int[] generate() {
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
