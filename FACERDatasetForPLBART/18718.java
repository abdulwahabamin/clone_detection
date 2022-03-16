    /**
     * Stores the specified file/folder's path in a temp variable and displays
     * the "Paste" option in the ActionBar.
     *
     * @param path The path of the file/folder to copy/move.
     * @param shouldMove Pass true if the file/folder should be moved instead of copied.
     */
    public void copyMove(String path, boolean shouldMove) {
        shouldMoveCopiedFile = shouldMove;
        copyMoveSourceFile = new File(path);
        if (!copyMoveSourceFile.exists()) {
            Toast.makeText(mContext, R.string.cant_copy_this_file_folder, Toast.LENGTH_SHORT).show();
            return;
        }

        //Show the paste option in the ActionBar.
        mIsPasteShown =  true;
        ((MainActivity) getActivity()).showFolderFragmentActionItems(currentDir,
                                                                     getActivity().getMenuInflater(),
                                                                     ((MainActivity) getActivity()).getMenu(),
                                                                     true);

    }

