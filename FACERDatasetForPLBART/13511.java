    /**
     * Method that performs a test to delete an invalid directory.
     *
     * @throws Exception If test failed
     */
    @SmallTest
    public void testDeleteDirFail() throws Exception {
        try {
            CommandHelper.deleteDirectory(getContext(), PATH_DELDIR_ERROR, getConsole());
            assertTrue("exit code==0", false); //$NON-NLS-1$
        } catch (NoSuchFileOrDirectory error) {
          //This command must failed. exit code !=0
        }
    }

