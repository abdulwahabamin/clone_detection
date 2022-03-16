    /**
     * Deletes the specified file.
     *
     * @param file The file to delete.
     */
    public void deleteFile(File file) {
        int fileType;
        if (file.isDirectory())
            fileType = FOLDER;
        else
            fileType = FILE;

        AsyncDeleteTask task = new AsyncDeleteTask(getActivity(), this, file, fileType);
        task.execute();
    }

