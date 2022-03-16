    /**
     * Method that performs the test of archive and compress data in BZIP format.
     *
     * @throws Exception If test failed
     */
    @LargeTest
    public void testArchiveCompressBZIP() throws Exception {
        testArchiveAndCompress(CompressionMode.AC_BZIP, TAR_BZIP_OUTFILE);
    }

