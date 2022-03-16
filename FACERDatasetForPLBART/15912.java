    private void deleteFiles() {
        File file = new File(Library.FILE_SAVE_LOCATION);
        clearDir(file);

        file = new File(Library.REMOTE_COVERS_LOCATION);
        clearDir(file);
    }

