# BlockmatrixText

This is an implementation of the new block matrix data structure based off the NIST Cybersecurity Whitepaper, "A Data Structure for Integrity Protection with Erasure Capability."

The paper can be found [here](https://csrc.nist.gov/CSRC/media/Publications/white-paper/2018/05/31/data-structure-for-integrity-protection-with-erasure-capability/draft/documents/data-structure-for-integrity-with-erasure-draft.pdf).

In this demo each Block holds text, but the data structure itself could hold anything in its blocks. The block matrix maintains integrity of its contents while still allowing deletion. 

Users can create a blockmatrix of their desired size, insert data, and delete data.

