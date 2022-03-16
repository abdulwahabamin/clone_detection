    public boolean createFile(File newFile) {
        try {
            if (newFile.createNewFile()) {
                addToDataSet(newFile);
                return true;
            }
        } catch (IOException ioe) {
            return false;
        }
        return false;
    }

