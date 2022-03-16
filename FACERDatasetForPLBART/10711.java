    /**
     * Method that performs a test to copy a file.
     *
     * @throws Exception If test failed
     */
    @SmallTest
    public void testCopyOk() throws Exception {
        try {
            CommandHelper.createFile(getContext(), PATH_FILE_SRC, getConsole());
            boolean ret = CommandHelper.copy(
                    getContext(), PATH_FILE_SRC, PATH_FILE_DST, getConsole());
            assertTrue("response==false", ret); //$NON-NLS-1$
        } finally {
            try {
                CommandHelper.deleteFile(getContext(), PATH_FILE_SRC, getConsole());
            } catch (Throwable ex) {
                /**NON BLOCK**/
            }
            try {
                CommandHelper.deleteFile(getContext(), PATH_FILE_DST, getConsole());
            } catch (Throwable ex) {
                /**NON BLOCK**/
            }
        }
    }

