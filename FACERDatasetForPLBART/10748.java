    /**
     * Method that performs a test over a known parse result.
     *
     * @throws Exception If test failed
     * {@link ListCommand#parse(String, String)}
     */
    @SmallTest
    public void testParse() throws Exception {
        ListCommand cmd = new ListCommand(LS_PATH, getConsole());
        String in =
            "/acct 0 0 41ed 0 0 d 1054 3 0 0 1357390899 1357390899 1357390899 4096\n" + //$NON-NLS-1$
            "/init.cm.rc 1238 8 81e8 0 0 1 370 1 0 0 1357390899 1357390899 1357390899 4096\n" + //$NON-NLS-1$
            "/vendor 14 0 a1ff 0 0 1 1052 1 0 0 1357390899 1357390899 1357390899 4096\n" + //$NON-NLS-1$
            "/cache 4096 8 41f9 1000 2001 b307 2 5 0 0 0 1357390900 1357390900 4096\n"; //$NON-NLS-1$

        String err = ""; //$NON-NLS-1$
        cmd.parse(in, err);
        List<FileSystemObject> files = cmd.getResult();
        assertNotNull("files==null", files); //$NON-NLS-1$
        assertTrue("length!=4", files.size() == 4); //$NON-NLS-1$
        assertTrue(
                "files(0) is not a directory", //$NON-NLS-1$
                files.get(0) instanceof Directory);
        assertTrue(
                "files(1) is not a file", //$NON-NLS-1$
                files.get(1) instanceof RegularFile);
        assertTrue(
                "files(2) is not a symlink", //$NON-NLS-1$
                files.get(2) instanceof Symlink);
        assertNotNull(
                "files(2) linkref is null", //$NON-NLS-1$
                ((Symlink)files.get(2)).getLinkRef());
        assertTrue(
                "files(3) != user", //$NON-NLS-1$
                files.get(3).getUser().getName().compareTo("system") == 0); //$NON-NLS-1$
        assertTrue(
                "files(3) != group", //$NON-NLS-1$
                files.get(3).getGroup().getName().compareTo("cache") == 0); //$NON-NLS-1$
        assertTrue(
                "files(1) != size", //$NON-NLS-1$
                files.get(1).getSize() == 1238);
        assertTrue(
                "files(1) != permissions",  //$NON-NLS-1$
                files.get(1).getPermissions()
                    .toRawString().compareTo("rwxr-x---") == 0); //$NON-NLS-1$
    }

