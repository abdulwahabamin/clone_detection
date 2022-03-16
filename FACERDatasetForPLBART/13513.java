    /**
     * Method that performs a test to delete a file.
     *
     * @throws Exception If test failed
     */
    @SmallTest
    public void testDeleteFileOk() throws Exception {
        CommandHelper.createFile(getContext(), PATH_DELFILE_OK, getConsole());
        boolean ret = CommandHelper.deleteFile(getContext(), PATH_DELFILE_OK, getConsole());
        assertTrue("response==false", ret); //$NON-NLS-1$
    }

