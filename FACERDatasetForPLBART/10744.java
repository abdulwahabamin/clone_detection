    /**
     * Method that performs a test to link to an invalid file.
     *
     * @throws Exception If test failed
     */
    @SmallTest
    public void testCreateSymlinkFail() throws Exception {
        try {
            CommandHelper.createFile(getContext(), PATH_SOURCE_ERROR, getConsole());
            boolean ret = CommandHelper.createLink(
                    getContext(), PATH_SOURCE_ERROR, PATH_LINK_ERROR, getConsole());
            assertTrue("response==false", ret); //$NON-NLS-1$
            try {
                FileSystemObject fso =
                        CommandHelper.getFileInfo(getContext(), PATH_LINK_ERROR, getConsole());
                assertTrue("fso != null", fso == null); //$NON-NLS-1$
            } catch (Exception e) {
                //OK. getFileInfo throws an exception because the symlink couldn't be created
            }
        } catch (InsufficientPermissionsException eex) {
            // This the expected behaviour because the symlink couldn't be created
        } finally {
            try {
                CommandHelper.deleteFile(getContext(), PATH_SOURCE_ERROR, getConsole());
            } catch (Exception e) {/**NON BLOCK**/}
            try {
                CommandHelper.deleteFile(getContext(), PATH_LINK_ERROR, getConsole());
            } catch (Exception e) {/**NON BLOCK**/}
        }
    }

