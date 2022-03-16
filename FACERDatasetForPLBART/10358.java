    /**
     * Method that computes the selection and returns a text message.
     *
     * @param selection The selection
     * @return String The computed text from the selection
     */
    private String computeSelection(List<FileSystemObject> selection) {
        int folders = 0;
        int files = 0;
        int cc = selection.size();
        for (int i = 0; i < cc; i++) {
            FileSystemObject fso = selection.get(i);
            if (FileHelper.isDirectory(fso)) {
                folders++;
            } else {
                files++;
            }
        }

        // Get the string
        final Resources res = getContext().getResources();

        if (files == 0) {
            return res.getQuantityString(R.plurals.selection_folders, folders, folders);
        }

        if (folders == 0) {
            return res.getQuantityString(R.plurals.selection_files, files, files);
        }

        String nFoldersString = res.getQuantityString(R.plurals.n_folders, folders, folders);
        String nFilesString = res.getQuantityString(R.plurals.n_files, files, files);
        return res.getString(R.string.selection_folders_and_files, nFoldersString, nFilesString);
    }

