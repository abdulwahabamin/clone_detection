    /**
     * Method that performs a test over known search results.
     *
     * @throws Exception If test failed
     */
    @LargeTest
    public void testFolderUsageWithPartialResult() throws Exception {
        this.mNewPartialData = false;
        this.mNormalEnd = false;
        this.mUsage = null;
        AsyncResultExecutable cmd =
                CommandHelper.getFolderUsage(getContext(), PATH, new AsyncResultListener() {
                        @Override
                        public void onAsyncStart() {
                            /**NON BLOCK**/
                        }
                        @Override
                        public void onAsyncEnd(boolean cancelled) {
                            synchronized (FolderUsageCommandTest.this.mSync) {
                                FolderUsageCommandTest.this.mNormalEnd = true;
                                FolderUsageCommandTest.this.mSync.notify();
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
                            FolderUsageCommandTest.this.mNewPartialData = true;
                            try {
                                FolderUsageCommandTest.this.mUsage =
                                        (FolderUsage)(((FolderUsage)result).clone());
                            } catch (Exception e) {/**NON BLOCK**/}
                            Log.d(TAG, FolderUsageCommandTest.this.mUsage.toString());
                        }
                   }, getConsole());
        synchronized (FolderUsageCommandTest.this.mSync) {
            FolderUsageCommandTest.this.mSync.wait(15000L);
        }
        try {
            if (!this.mNormalEnd && cmd != null && cmd.isCancellable() && !cmd.isCancelled()) {
                cmd.cancel();
            }
        } catch (Exception e) {/**NON BLOCK**/}
        assertTrue("no new partial data", this.mNewPartialData); //$NON-NLS-1$
        assertNotNull("usage==null", this.mUsage); //$NON-NLS-1$
        assertTrue("no files returned", this.mUsage.getNumberOfFiles() > 0); //$NON-NLS-1$
        assertTrue("no size returned", this.mUsage.getTotalSize() > 0); //$NON-NLS-1$
        assertTrue("no text category returned", //$NON-NLS-1$
                this.mUsage.getStatisticsForCategory(MimeTypeCategory.APP) > 0);
    }

