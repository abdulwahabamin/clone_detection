    /**
     * Method that resolves the symbolic link of a file passed in as argument.<br />
     * This method invokes the {@link ResolveLinkCommand} on the file that has a valid
     * symlink reference
     *
     * @param context The current context
     * @param fso FileSystemObject to resolve symlink
     */
    public static void resolveSymlink(Context context, FileSystemObject fso) {
        if (fso instanceof Symlink && ((Symlink)fso).getLinkRef() == null) {
            try {
                FileSystemObject symlink =
                        CommandHelper.resolveSymlink(context, fso.getFullPath(), null);
                ((Symlink)fso).setLinkRef(symlink);
            } catch (Throwable ex) {/**NON BLOCK**/}
        }
    }

