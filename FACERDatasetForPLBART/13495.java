    /**
     * Method that performs the test of archive and compress data in GZIP format.
     *
     * @throws Exception If test failed
     */
    @LargeTest
    public void testArchiveCompressGZIP() throws Exception {
        testArchiveAndCompress(CompressionMode.AC_GZIP, TAR_GZIP_OUTFILE);
    }

