    public static FileManager getInstance(AssetManager assetManager) {
        if (INSTANCE == null) {
            INSTANCE = new FileManager(assetManager);
        }
        return INSTANCE;
    }

