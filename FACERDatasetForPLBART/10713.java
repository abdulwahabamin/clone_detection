    /**
     * Method that performs a test to create a new directory.
     *
     * @throws Exception If test failed
     */
    @SmallTest
    public void testCreateDirOk() throws Exception {
        try {
            boolean ret = CommandHelper.createDirectory(getContext(), PATH_NEWDIR_OK, getConsole());
            assertTrue("response==false", ret); //$NON-NLS-1$

        } finally {
            try {
                CommandHelper.deleteDirectory(getContext(), PATH_NEWDIR_OK, getConsole());
            } catch (Throwable ex) {/**NON BLOCK**/}
        }
    }

