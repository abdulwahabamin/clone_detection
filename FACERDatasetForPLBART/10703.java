    /**
     * Method that performs the test of archive data in TAR format.
     *
     * @throws Exception If test failed
     */
    @LargeTest
    public void testArchiveTAR() throws Exception {
        testArchiveAndCompress(CompressionMode.A_TAR, TAR_OUTFILE);
    }

