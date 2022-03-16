    /**
     * Method that changes the current directory of the view.
     *
     * @param newDir The new directory location
     * @param addToHistory Add the directory to history
     */
    public void changeCurrentDir(final String newDir, boolean addToHistory) {
        changeCurrentDir(newDir, addToHistory, false, false, null, null);
    }

