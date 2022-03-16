    /**
     * Method that performs the test of compress data in BZIP format.
     *
     * @throws Exception If test failed
     */
    @LargeTest
    public void testCompressBZIP() throws Exception {
        testCompress(CompressionMode.C_BZIP);
    }

