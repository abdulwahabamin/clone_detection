    /**
     * Method that archive and compress data.
     *
     * @param mode The compress mode
     * @param dst The destination file
     * @throws Exception If test failed
     */
    private void testArchiveAndCompress(CompressionMode mode, String dst) throws Exception {
        try {
            this.mNewPartialData = false;
            this.mNormalEnd = false;
            CompressExecutable cmd =
                    CommandHelper.compress(
                        getContext(), mode, dst, ARCHIVE_DATA, new AsyncResultListener() {
                            @Override
                            public void onAsyncStart() {
                                /**NON BLOCK**/
                            }
                            @Override
                            public void onAsyncEnd(boolean cancelled) {
                                synchronized (CompressCommandTest.this.mSync) {
                                    CompressCommandTest.this.mNormalEnd = true;
                                    CompressCommandTest.this.mSync.notify();
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
                                CompressCommandTest.this.mNewPartialData = true;
                                Log.d(TAG, (String)result);
                            }
                       }, getConsole());
            synchronized (CompressCommandTest.this.mSync) {
                CompressCommandTest.this.mSync.wait(60000L);
            }
            try {
                if (!this.mNormalEnd && cmd != null && cmd.isCancellable() && !cmd.isCancelled()) {
                    cmd.cancel();
                }
            } catch (Exception e) {/**NON BLOCK**/}

            // Wait for result
            Thread.sleep(500L);

            assertTrue("no new partial data", this.mNewPartialData); //$NON-NLS-1$
            assertNotNull("cmd != null", cmd); //$NON-NLS-1$
            if (cmd != null) {
                assertTrue("return != true", cmd.getResult().booleanValue()); //$NON-NLS-1$
            }
        } finally {
            try {
                CommandHelper.deleteFile(getContext(), dst, getConsole());
            } catch (Exception e) {/**NON BLOCK**/}
        }
    }

