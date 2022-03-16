    /**
     * Method that performs a test to create a new file.
     *
     * @throws Exception If test failed
     */
    @SmallTest
    public void testCreateFileOk() throws Exception {
        try {
            boolean ret = CommandHelper.createFile(getContext(), PATH_NEWFILE_OK, getConsole());
            assertTrue("response==false", ret); //$NON-NLS-1$
        } finally {
            try {
                CommandHelper.deleteFile(getContext(), PATH_NEWFILE_OK, getConsole());
            } catch (Throwable ex) {
                /**NON BLOCK**/
            }
        }
    }

