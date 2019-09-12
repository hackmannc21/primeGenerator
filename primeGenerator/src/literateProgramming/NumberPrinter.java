package literateProgramming;

public class NumberPrinter {
    private final int colsPerPage;
    private final int rowPerPage;

    public NumberPrinter(int colsPerPage, int rowPerPage) {
        this.colsPerPage = colsPerPage;
        this.rowPerPage = rowPerPage;
    }

    void print(int numPrime, int[] primes) {
        int pageNumber = 1;
        int pageoffset = 1;
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

}
