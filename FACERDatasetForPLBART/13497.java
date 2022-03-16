    /**
     * Method that performs the test of compress data in GZIP format.
     *
     * @throws Exception If test failed
     */
    @LargeTest
    public void testCompressGZIP() throws Exception {
        testCompress(CompressionMode.C_GZIP);
    }

