    /**
     * Calculates the parent dir of the current dir and calls getDir().
     * Returns true if the parent dir is the rootDir
     */
    public boolean getParentDir() {

        if (currentDir.equals("/"))
            return true;

        //Get the current folder's parent folder.
        File currentFolder = new File(currentDir);
        String parentFolder = "";
        try {
            parentFolder = currentFolder.getParentFile().getCanonicalPath();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FilesFoldersFragment.currentDir = parentFolder;
        getDir(parentFolder, null);
        return false;

    }

