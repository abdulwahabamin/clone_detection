    public ListAdapter(String selectedDirectory) {
        mCurrentDirectory = selectedDirectory;
        mContextMenuPosition = -1;
        mFileList = new ArrayList<>();
        File directory = new File(selectedDirectory);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            for (File f : files) {
                if (f.canRead()) {
                    mFileList.add(f);
                }
            }
        } else {
            Log.i("FileManager: ", "Directory does not exist");
        }
    }

