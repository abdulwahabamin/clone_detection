    /**
     * Method that performs a checksum test
     *
     * @throws Exception If an exception occurs while executing the test
     */
    @SmallTest
    @SuppressWarnings("null")
    public void testChecksums() throws Exception {
        ChecksumExecutable cmd =
                CommandHelper.checksum(getContext(),
                        TEST_FILE, new AsyncResultListener() {
                            @Override
                            public void onAsyncStart() {
                                /**NON BLOCK**/
                            }
                            @Override
                            public void onAsyncEnd(boolean cancelled) {
                                synchronized (ChecksumCommandTest.this.mSync) {
                                    ChecksumCommandTest.this.mNormalEnd = true;
                                    ChecksumCommandTest.this.mSync.notify();
                                }
                            }
                            @Override
                            public void onAsyncExitCode(int exitCode) {
                                /**NON BLOCK**/
                            }
                            @Override
                            public void onException(Exception cause) {
                                fail(String.valueOf(cause));
                            }
                            @Override
                            public void onPartialResult(Object results) {
                                /**NON BLOCK**/
                            }
                        }, getConsole());

        synchronized (ChecksumCommandTest.this.mSync) {
            ChecksumCommandTest.this.mSync.wait(15000L);
        }
        try {
            if (!this.mNormalEnd && cmd != null && cmd.isCancellable() && !cmd.isCancelled()) {
                cmd.cancel();
            }
        } catch (Exception e) {/**NON BLOCK**/}
        assertNotNull("md5==null", cmd.getChecksum(CHECKSUMS.MD5)); //$NON-NLS-1$
        assertNotNull("sha1==null", cmd.getChecksum(CHECKSUMS.SHA1)); //$NON-NLS-1$
        assertEquals("md5sum fails", MD5_SUM, cmd.getChecksum(CHECKSUMS.MD5)); //$NON-NLS-1$
        assertEquals("sha1sum fails", SHA1_SUM, cmd.getChecksum(CHECKSUMS.SHA1)); //$NON-NLS-1$
    }

