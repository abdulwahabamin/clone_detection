    /**
     * Method that performs a test to link to a file.
     *
     * @throws Exception If test failed
     */
    @SmallTest
    public void testCreateSymlinkOk() throws Exception {
        try {
            CommandHelper.createFile(getContext(), PATH_SOURCE_OK, getConsole());
            boolean ret = CommandHelper.createLink(
                    getContext(), PATH_SOURCE_OK, PATH_LINK_OK, getConsole());
            FileSystemObject fso =
                    CommandHelper.getFileInfo(getContext(), PATH_LINK_OK, false, getConsole());
            assertTrue("response==false", ret); //$NON-NLS-1$
            assertNotNull("fso==null", fso); //$NON-NLS-1$
            assertTrue("fso not is Symlink", fso instanceof Symlink); //$NON-NLS-1$
        } finally {
            try {
                CommandHelper.deleteFile(getContext(), PATH_SOURCE_OK, getConsole());
            } catch (Exception e) {/**NON BLOCK**/}
            try {
                CommandHelper.deleteFile(getContext(), PATH_LINK_OK, getConsole());
            } catch (Exception e) {/**NON BLOCK**/}
        }
    }

