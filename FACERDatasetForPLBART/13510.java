    /**
     * Method that performs a test to delete a directory.
     *
     * @throws Exception If test failed
     */
    @SmallTest
    public void testDeleteDirOk() throws Exception {
        try {
            CommandHelper.createDirectory(getContext(), PATH_DELDIR_OK, getConsole());
        } finally {
            boolean ret = CommandHelper.deleteDirectory(getContext(), PATH_DELDIR_OK, getConsole());
            assertTrue("response==false", ret); //$NON-NLS-1$
        }
    }

