    /**
     * Pastes the specified file into the current directory.
     *
     * @param file The file to paste into the current directory.
     */
    public void pasteIntoCurrentDir(File file) {
        mIsPasteShown =  false;
        AsyncCopyMoveTask task = new AsyncCopyMoveTask(mContext, file, new File(currentDir + "/" + file.getName()),
                                                       this, shouldMoveCopiedFile);
        task.execute();
    }

