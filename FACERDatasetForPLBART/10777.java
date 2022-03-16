    /**
     * Method that uncompress data.
     *
     * @param src The compressed file
     * @param expectOutput If the test need to expect output in the uncompress operation
     * @throws Exception If test failed
     */
    @SuppressWarnings("unused")
    private void testUncompress(String src, boolean expectOutput) throws Exception {
        UncompressExecutable cmd = null;
        try {
            this.mNewPartialData = false;
            this.mNormalEnd = false;
            cmd =
                CommandHelper.uncompress(
                    getContext(), src, null, new AsyncResultListener() {
                        @Override
                        public void onAsyncStart() {
                            /**NON BLOCK**/
                        }
                        @Override
                        public void onAsyncEnd(boolean cancelled) {
                            synchronized (UncompressCommandTest.this.mSync) {
                                UncompressCommandTest.this.mNormalEnd = true;
                                UncompressCommandTest.this.mSync.notify();
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
                        public void onPartialResult(Object result) {
                            UncompressCommandTest.this.mNewPartialData = true;
                            Log.d(TAG, (String)result);
                        }
                   }, getConsole());
            synchronized (UncompressCommandTest.this.mSync) {
                UncompressCommandTest.this.mSync.wait(60000L);
            }
            try {
                if (!this.mNormalEnd && cmd != null && cmd.isCancellable() && !cmd.isCancelled()) {
                    cmd.cancel();
                }
            } catch (Exception e) {/**NON BLOCK**/}

            // Wait for result
            Thread.sleep(500L);

            if (expectOutput) {
                assertTrue("no new partial data", this.mNewPartialData); //$NON-NLS-1$
            }
            assertNotNull("cmd != null", cmd); //$NON-NLS-1$
            if (cmd != null) {
                assertTrue("return != true", cmd.getResult().booleanValue()); //$NON-NLS-1$
            }
        } finally {
            try {
                CommandHelper.deleteFile(getContext(), src, getConsole());
            } catch (Exception e) {/**NON BLOCK**/}
            try {
                if (cmd != null) {
                    if (cmd.IsArchive()) {
                        CommandHelper.deleteDirectory(
                                getContext(), cmd.getOutUncompressedFile(), getConsole());
                    } else {
                        CommandHelper.deleteFile(
                                getContext(), cmd.getOutUncompressedFile(), getConsole());
                    }
                }
            } catch (Exception e) {/**NON BLOCK**/}
        }
    }

