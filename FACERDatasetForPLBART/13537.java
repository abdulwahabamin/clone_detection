    /**
     * Method that performs a test over list command setting the
     * directory to list.
     *
     * @throws Exception If test failed
     */
    @MediumTest
    public void testList() throws Exception {
        List<FileSystemObject> files = CommandHelper.listFiles(getContext(), LS_PATH, getConsole());
        assertNotNull("files==null", files); //$NON-NLS-1$
        assertTrue("no objects returned", files.size() > 0); //$NON-NLS-1$
    }

