    private static File[] getAvailableStorages(Context context) {
        File storageRoot = new File("/storage");
        return storageRoot.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.canRead();
            }
        });
    }

