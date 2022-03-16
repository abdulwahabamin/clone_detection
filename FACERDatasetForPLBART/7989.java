    public void setDirectory(String newDirectory) {
        mCurrentDirectory = newDirectory;
        mContextMenuPosition = -1;
        mFileList = new ArrayList<>();
        File directory = new File(mCurrentDirectory);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            for (File f : files) {
                if (f.canRead()) {
                    mFileList.add(f);
                }
            }
            notifyDataSetChanged();
        } else {
            Log.i("FileManager: ", "Directory does not exist");
        }
    }

