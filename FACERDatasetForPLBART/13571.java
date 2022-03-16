    /**
     * Method that performs a large write test.
     *
     * @throws Exception If an exception occurs while executing the test
     */
    @LargeTest
    public void testLargeWriteWithPartialResult() throws Exception {
        try {
            WriteExecutable cmd =
                    CommandHelper.write(getContext(),
                    WRITE_FILE_LARGE, new AsyncResultListener() {
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
            Random random = new Random();
            for (int i = 0; i < 50; i++) {
                byte[] data = new byte[DATA_SIZE];
                random.nextBytes(data);
                os.write(data, 0, data.length);
            }
            cmd.end();

            // Wait for allow close all instrumentation data
            Thread.sleep(2500L);
        } finally {
            try {
                CommandHelper.deleteFile(getContext(), WRITE_FILE_LARGE, getConsole());
            } catch (Exception e) {/**NON BLOCK**/}
        }
    }

