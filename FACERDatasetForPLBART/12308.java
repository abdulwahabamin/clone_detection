    /**
     * Constructor of <code>FolderUsage</code>.
     *
     * @param folder The folder of which retrieve the usage
     */
    public FolderUsage(String folder) {
        super();

        // Initialize the class
        this.mFolder = folder;
        this.mNumberOfFolders = 0;
        this.mNumberOfFiles = 0;
        this.mTotalSize = 0;

        // Fill the array of statistics
        MimeTypeCategory[] categories = MimeTypeCategory.values();
        this.mStatistics = new SparseArray<Long>(categories.length-1);
        int cc = categories.length;
        for (int i = 0; i < cc; i++) {
            this.mStatistics.put(categories[i].ordinal(), Long.valueOf(0));
        }
    }

