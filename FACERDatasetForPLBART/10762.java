    /**
     * Method that performs a read of a file
     *
     * @throws Exception If an exception occurs while executing the test
     */
    @MediumTest
    public void testReadWithPartialResult() throws Exception {
        this.mNewPartialData = false;
        this.mNormalEnd = false;
        final StringBuffer sb = new StringBuffer();
        AsyncResultExecutable cmd =
                CommandHelper.read(getContext(), READ_FILE, new AsyncResultListener() {
                        @Override
                        public void onAsyncStart() {
                            /**NON BLOCK**/
                        }
                        @Override
                        public void onAsyncEnd(boolean cancelled) {
                            synchronized (ReadCommandTest.this.mSync) {
                                ReadCommandTest.this.mNormalEnd = true;
                                ReadCommandTest.this.mSync.notify();
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
                            ReadCommandTest.this.mNewPartialData = true;
                            sb.append(new String((byte[])results));
                        }
                   }, getConsole());
        synchronized (ReadCommandTest.this.mSync) {
            ReadCommandTest.this.mSync.wait(15000L);
        }
        try {
            if (!this.mNormalEnd && cmd != null && cmd.isCancellable() && !cmd.isCancelled()) {
                cmd.cancel();
            }
        } catch (Exception e) {/**NON BLOCK**/}
        assertTrue("no new partial data", this.mNewPartialData); //$NON-NLS-1$
        assertNotNull("sb==null", sb); //$NON-NLS-1$
        Log.v(TAG, String.format("read data: %s", sb.toString())); //$NON-NLS-1$
        assertTrue("read.size > 0", sb.length() > 0); //$NON-NLS-1$
    }

