    /**
     * Method that performs a test to create a new invalid file.
     *
     * @throws Exception If test failed
     */
    @SmallTest
    public void testCreateFileFail() throws Exception {
        try {
            CommandHelper.createFile(getContext(), PATH_NEWFILE_ERROR, getConsole());
            assertTrue("exit code==0", false); //$NON-NLS-1$
        } catch (NoSuchFileOrDirectory error) {
          //This command must failed. exit code !=0
        } finally {
            try {
                CommandHelper.deleteFile(getContext(), PATH_NEWFILE_ERROR, getConsole());
            } catch (Throwable ex) {
                /**NON BLOCK**/
            }
        }
    }

