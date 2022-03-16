    /**
     * Method that performs a test to get the real file of a symlink.
     *
     * @throws Exception If test failed
     */
    @SmallTest
    public void testReadLinkOk() throws Exception {
        FileSystemObject fso = CommandHelper.resolveSymlink(getContext(), LINK, getConsole());
        assertNotNull("fso==null)", fso); //$NON-NLS-1$
        assertTrue(
                String.format("parent!=%s", REAL_FILE), //$NON-NLS-1$
                fso.getFullPath().compareTo(REAL_FILE) == 0);
    }

