    /**
     * Method that checks if a name exists in the current directory.
     *
     * @param context The application context
     * @param parentDir The full path to the parent directory
     * @param name The name to check
     * @return boolean Indicate if the name exists in the current directory
     */
    public static boolean isNameExists(Context context, String parentDir, String name) {
        if (parentDir == null || parentDir.equals(ROOT_DIRECTORY)) {
            parentDir = "";
        }
        //Verify if the name exists in the current file list
        try {
            return CommandHelper.getFileInfo(context, parentDir + "/" + name, null) != null;
        } catch (Exception e) {
            // This is a slight misreporting, however, I don't want to do a bunch of refactoring
            Log.i(TAG, "Failed to get file info: " + e.getMessage());
            return false;
        }
    }

