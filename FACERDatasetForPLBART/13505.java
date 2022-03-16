    /**
     * Method that performs a test to create a new invalid directory.
     *
     * @throws Exception If test failed
     */
    @SmallTest
    public void testCreateDirFail() throws Exception {
        try {
            CommandHelper.createDirectory(getContext(), PATH_NEWDIR_ERROR, getConsole());
            assertTrue("exit code==0", false); //$NON-NLS-1$
        } catch (NoSuchFileOrDirectory error) {
          //This command must failed. exit code !=0
        } finally {
            try {
                CommandHelper.deleteDirectory(getContext(), PATH_NEWDIR_ERROR, getConsole());
            } catch (Throwable ex) {/**NON BLOCK**/}
        }
    }

