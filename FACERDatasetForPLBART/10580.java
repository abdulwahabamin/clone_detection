    /**
     * Method that checks if a name exists in the current directory.
     *
     * @param files The list of files of the current directory
     * @param name The name to check
     * @return boolean Indicate if the name exists in the current directory
     */
    public static boolean isNameExists(List<FileSystemObject> files, String name) {
        //Verify if the name exists in the current file list
        int cc = files.size();
        for (int i = 0; i < cc; i++) {
            FileSystemObject fso = files.get(i);
            if (fso.getName().compareTo(name) == 0) {
                return true;
            }
        }
        return false;
    }

