    /**
     * Method that resolve the symbolic links of the list of files passed as argument.<br />
     * This method invokes the {@link ResolveLinkCommand} in those files that have a valid
     * symlink reference
     *
     * @param context The current context
     * @param files The listed files
     */
    public static void resolveSymlinks(Context context, List<FileSystemObject> files) {
        int cc = files.size();
        for (int i = 0; i < cc; i++) {
            FileSystemObject fso = files.get(i);
            resolveSymlink(context, fso);
        }
    }

