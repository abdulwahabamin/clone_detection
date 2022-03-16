    /**
     * Method that creates a new name based on the name of the {@link FileSystemObject}
     * that is not current used by the filesystem.
     *
     * @param ctx The current context
     * @param parentDir The directory in which we want to make the file
     * @param attemptedName The attempted name
     * @param regexp The resource of the regular expression to create the new name
     * @return String The new non-existing name
     */
    public static String createNonExistingName(
            final Context ctx, final String parentDir,
            final String attemptedName, int regexp) {
        // Find a non-exiting name
        String newName = attemptedName;
        if (!isNameExists(ctx, parentDir, newName)) return newName;
        do {
            String name  = FileHelper.getName(newName);
            String ext  = FileHelper.getExtension(newName);
            if (ext == null) {
                ext = ""; //$NON-NLS-1$
            } else {
                ext = "." + ext; //$NON-NLS-1$
            }
            newName = ctx.getString(regexp, name, ext);
        } while (isNameExists(ctx, parentDir, newName));
        return newName;
    }

