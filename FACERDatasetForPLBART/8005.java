    public void goToAppFolder(View v) {
        try {
            setCurrentDirectory(getFilesDir().getCanonicalPath());
        } catch (IOException ioe) {
            Log.i("FileManager: ", "Error opening app data directory");
        }
    }

