    /******************
     * File Operations
     ******************/
    public boolean createDirectory(File newDir) {
        if ((newDir.mkdir())) {
            addToDataSet(newDir);
            return true;
        }
        return false;
    }

