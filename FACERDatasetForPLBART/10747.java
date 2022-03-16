    /**
     * Method that performs a test over list command setting the
     * directory to list.
     *
     * @throws Exception If test failed
     */
    @MediumTest
    public void testListInfo() throws Exception {
        FileSystemObject file =
                CommandHelper.getFileInfo(getContext(), LS_INFOFILE, getConsole());
        assertNotNull("file==null", file); //$NON-NLS-1$
        assertTrue(
                String.format("file!=%s", LS_INFOFILE_NAME), //$NON-NLS-1$
                file.getName().compareTo(LS_INFOFILE_NAME) == 0);
    }

