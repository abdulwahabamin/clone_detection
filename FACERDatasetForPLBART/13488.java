    /**
     * Method that performs a test to change permissions of a file.
     *
     * @throws Exception If test failed
     */
    @SmallTest
    public void testChangeOwnerOk() throws Exception {
        try {
            //Create and list the file
            CommandHelper.createFile(getContext(), PATH_FILE, getConsole());
            FileSystemObject file =
                    CommandHelper.getFileInfo(getContext(), PATH_FILE, false, getConsole());

            //Change the permissions
            User oldUser = file.getUser();
            Group newGroup = new Group(-1, NEW_GROUP);
            boolean ret =
                    CommandHelper.changeOwner(
                            getContext(), PATH_FILE, oldUser, newGroup, getConsole());
            assertTrue("response==false", ret); //$NON-NLS-1$

            //List the file again
            file = CommandHelper.getFileInfo(getContext(), PATH_FILE, false, getConsole());
            Group lsGroup = file.getGroup();
            assertTrue("set group!=list group",  //$NON-NLS-1$
                    newGroup.getName().compareTo(lsGroup.getName()) == 0);

        } finally {
            try {
                CommandHelper.deleteFile(getContext(), PATH_FILE, getConsole());
            } catch (Throwable ex) {
                /**NON BLOCK**/
            }
        }
    }

