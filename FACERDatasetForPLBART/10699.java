    /**
     * Method that performs a test to change permissions of a file.
     *
     * @throws Exception If test failed
     */
    @SmallTest
    public void testChangePermissionsOk() throws Exception {
        try {
            //Create and list the file
            CommandHelper.createFile(getContext(), PATH_FILE, getConsole());
            FileSystemObject file =
                    CommandHelper.getFileInfo(getContext(), PATH_FILE, false, getConsole());

            //Change the permissions
            Permissions oldpermissions = file.getPermissions();
            String oldOctalPermissions = oldpermissions.toOctalString();
            boolean read = oldpermissions.getUser().isRead();
            oldpermissions.getUser().setRead(!read);
            boolean ret =
                    CommandHelper.changePermissions(
                            getContext(), PATH_FILE, oldpermissions, getConsole());
            assertTrue("response==false", ret); //$NON-NLS-1$

            //List the files again
            file = CommandHelper.getFileInfo(getContext(), PATH_FILE, false, getConsole());
            Permissions newpermissions = file.getPermissions();
            String newOctalPermissions = newpermissions.toOctalString();
            assertTrue("newpermissions==oldpermissions",  //$NON-NLS-1$
                    newOctalPermissions.compareTo(oldOctalPermissions) != 0);

        } finally {
            try {
                CommandHelper.deleteFile(getContext(), PATH_FILE, getConsole());
            } catch (Throwable ex) {
                /**NON BLOCK**/
            }
        }
    }

