    /**
     * Method that compress data.
     *
     * @param mode The compress mode
     * @throws Exception If test failed
     */
    private void testCompress(CompressionMode mode) throws Exception {
        CompressExecutable cmd = null;
        try {
            // Copy a file to the folder of the test
            CommandHelper.copy(getContext(), COMPRESS_DATA_SRC, COMPRESS_DATA_DST, getConsole());

            this.mNewPartialData = false;
            this.mNormalEnd = false;
            cmd =
                    CommandHelper.compress(
                        getContext(), mode, COMPRESS_DATA_DST, new AsyncResultListener() {
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
                CompressCommandTest.this.mSync.wait(15000L);
            }
            try {
                if (!this.mNormalEnd && cmd != null && cmd.isCancellable() && !cmd.isCancelled()) {
                    cmd.cancel();
                }
            } catch (Exception e) {/**NON BLOCK**/}

            // Wait for result
            Thread.sleep(500L);

            assertNotNull("cmd != null", cmd); //$NON-NLS-1$
            if (cmd != null) {
                assertTrue("return != true", cmd.getResult().booleanValue()); //$NON-NLS-1$
            }
        } finally {
            if (cmd != null) {
                try {
                    CommandHelper.deleteFile(
                            this.mContext, COMPRESS_DATA_DST, getConsole());
                } catch (Exception e) {/**NON BLOCK**/}
                try {
                    CommandHelper.deleteFile(
                            this.mContext, cmd.getOutCompressedFile(), getConsole());
                } catch (Exception e) {/**NON BLOCK**/}
            }
        }
    }

