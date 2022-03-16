    public FileExploreAdapter(List<FileModel> files,
                              PathItemClickListener listener,
                              HashMap<String, Long> cacheSizeDirectory) {
        fileModels = files;
        pathListener = listener;
        this.cacheSizeDirectory = cacheSizeDirectory;
    }

