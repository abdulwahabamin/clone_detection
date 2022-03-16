    /**
     * Method that performs a small write test.
     *
     * @throws Exception If an exception occurs while executing the test
     */
    @SmallTest
    public void testSmallWriteWithPartialResult() throws Exception {
        try {
            WriteExecutable cmd =
                    CommandHelper.write(getContext(),
                    WRITE_FILE_SMALL, new AsyncResultListener() {
                            @Override
                            public void onAsyncStart() {/**NON BLOCK**/}
                            @Override
                            public void onAsyncEnd(boolean cancelled) {/**NON BLOCK**/}
                            @Override
                            public void onAsyncExitCode(int exitCode) {/**NON BLOCK**/}
                            @Override
                            public void onException(Exception cause) {
                                fail(String.valueOf(cause));
                            }
                            @Override
                            public void onPartialResult(Object results) {/**NON BLOCK**/}
                       }, getConsole());
            OutputStream os = cmd.createOutputStream();
            os.write(TEST_DATA, 0, TEST_DATA.length);
            cmd.end();

            // Wait for allow close all instrumentation data
            Thread.sleep(2500L);
        } finally {
            try {
                CommandHelper.deleteFile(getContext(), WRITE_FILE_SMALL, getConsole());
            } catch (Exception e) {/**NON BLOCK**/}
        }
    }

