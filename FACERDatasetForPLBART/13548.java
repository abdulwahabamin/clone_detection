    /**
     * Method that performs a test to get the parent directory of a known file.
     *
     * @throws Exception If test failed
     */
    @SmallTest
    public void testParentDirOk() throws Exception {
        try {
            CommandHelper.createFile(getContext(), FILE, getConsole());
            String parent = CommandHelper.getParentDir(getContext(), FILE, getConsole());
            assertNotNull("parent==null", parent); //$NON-NLS-1$
            assertTrue(
                    String.format(
                            "parent!=%s", PARENT), parent.compareTo(PARENT) == 0); //$NON-NLS-1$
        } finally {
            try {
                CommandHelper.deleteFile(getContext(), FILE, getConsole());
            } catch (Throwable ex) {
                /**NON BLOCK**/
            }
        }
    }

