    /**
     * Method that returns if the file system object is in the selection list.
     *
     * @param selection The selection list
     * @param fso The file system object
     * @return boolean Indicates if the file system object is in the selection list
     */
    public static boolean isFileSystemObjectSelected(
            List<FileSystemObject> selection, FileSystemObject fso) {
        if (selection != null) {
            int cc = selection.size();
            for (int i = 0; i < cc; i++) {
                if (selection.get(i).compareTo(fso) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

