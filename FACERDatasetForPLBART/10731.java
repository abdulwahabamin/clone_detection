    /**
     * Method that performs a test over known executable program.
     *
     * @throws Exception If test failed
     */
    @MediumTest
    public void testExecWithPartialResult() throws Exception {
        try {
            // Create the test program
            WriteExecutable writeCmd =
                    CommandHelper.write(getContext(), EXEC_CMD, null, getConsole());
            OutputStream os = writeCmd.createOutputStream();
            os.write(EXEC_PROGRAM.getBytes());
            writeCmd.end();

            // Enable execute permission
            CommandHelper.changePermissions(
                    getContext(),
                    EXEC_CMD,
                    Permissions.fromOctalString(EXEC_CMD_PERMISSIONS),
                    getConsole());

            // Execute the test program
            this.mNewPartialData = false;
            CommandHelper.exec(getContext(), EXEC_CMD, new AsyncResultListener() {
                @Override
                public void onAsyncStart() {
                    /**NON BLOCK**/
                }
                @Override
                public void onAsyncEnd(boolean cancelled) {
                    synchronized (ExecCommandTest.this.mSync) {
                        ExecCommandTest.this.mSync.notify();
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
                    ExecCommandTest.this.mNewPartialData = true;
                }
            }, getConsole());
            synchronized (ExecCommandTest.this.mSync) {
                ExecCommandTest.this.mSync.wait(15000L);
            }
            assertTrue("no new partial data", this.mNewPartialData); //$NON-NLS-1$

        } finally {
            try {
                CommandHelper.deleteFile(getContext(), EXEC_CMD, getConsole());
            } catch (Exception e) {/**NON BLOCK**/}
        }
    }

