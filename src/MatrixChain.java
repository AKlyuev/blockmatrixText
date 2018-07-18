import java.util.HashMap;

public class MatrixChain {

    private static BlockMatrix bm;

    public static void main(String[] args) {

        bm = new BlockMatrix(5);

        //add our blocks to the BlockMatrix:

        bm.add(new Block("First"));
        bm.add(new Block("Second"));
        bm.add(new Block("Third"));
        bm.deleteBlock(2);

        System.out.println("\nOur block matrix:\n" + bm);
        System.out.println("\nMatrix is valid: " + isMatrixValid());

    }


    //NOT COMPLETE, just similar to what the Medium tutorial did, probably doesn't definitively decide validity
    public static Boolean isMatrixValid() {
        Block currentBlock;

        //loop through matrix to check block hashes:
        for (int i = 1; i < bm.getInputCount(); i++) {
            currentBlock = bm.getBlock(i);
            //compare registered hash and calculated hash:
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                System.out.println("Hashes for Block " + i + " not equal (first instance of block with unequal hashes, there may be more)");
                return false;
            }
        }

        //check if all row hashes are valid
        for (int i = 0; i < bm.getDimension(); i++) {
            if (!bm.calculateRowHash(i).equals(bm.getRowHashes()[i])) {
                System.out.println("Row hashes for row " + i + " not equal (first instance of row with unequal hashes, there may be more");
                return false;
            }
        }

        //check if all column hashes are valid
        for (int i = 0; i < bm.getDimension(); i++) {
            if (!bm.calculateColumnHash(i).equals(bm.getColumnHashes()[i])) {
                System.out.println("Column hashes for row " + i +  " not equal (first instance of column with unequal hashes, there may be more");
                return false;
            }
        }

        //check if all deletions have been valid
        if (!bm.getDeletionValidity()) {
            System.out.println("One or more deletions were not valid and altered more than one row and column hash");
            return false;
        }

        return true;
    }

}
