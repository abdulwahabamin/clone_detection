    /**
     * Method that creates a new name based on the name of the {@link FileSystemObject}
     * that is not current used by the filesystem.
     *
     * @param ctx The current context
     * @param files The list of files of the current directory
     * @param attemptedName The attempted name
     * @param regexp The resource of the regular expression to create the new name
     * @return String The new non-existing name
     */
    public static String createNonExistingName(
            final Context ctx, final List<FileSystemObject> files,
            final String attemptedName, int regexp) {
        // Find a non-exiting name
        String newName = attemptedName;
        if (!isNameExists(files, newName)) return newName;
        do {
            String name  = FileHelper.getName(newName);
            String ext  = FileHelper.getExtension(newName);
            if (ext == null) {
                ext = ""; //$NON-NLS-1$
            } else {
                ext = "." + ext; //$NON-NLS-1$
            }
            newName = ctx.getString(regexp, name, ext);
        } while (isNameExists(files, newName));
        return newName;
    }

