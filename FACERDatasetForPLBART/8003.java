    protected void setCurrentDirectory(int position) {
        try {
            setCurrentDirectory(mAdapter.getFile(position).getCanonicalPath());
        } catch (IOException ioe) {
            Log.i("FileManager: ", "Error setting current directory.");
        }
    }

