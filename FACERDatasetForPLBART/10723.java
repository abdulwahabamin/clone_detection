    /**
     * Method that performs a test to delete an invalid file.
     *
     * @throws Exception If test failed
     */
    @SmallTest
    public void testDeleteFileFail() throws Exception {
        try {
            CommandHelper.deleteFile(getContext(), PATH_DELFILE_ERROR, getConsole());
            assertTrue("exit code==0", false); //$NON-NLS-1$
        } catch (NoSuchFileOrDirectory error) {
          //This command must failed. exit code !=0
        }
    }

