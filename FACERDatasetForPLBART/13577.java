    @Override
    public void onCreate() {
        super.onCreate();

        storageDirectories = Arrays.asList(StorageUtil.getStorageDirectories(this));
    }

