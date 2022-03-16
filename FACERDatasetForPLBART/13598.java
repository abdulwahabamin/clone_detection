    public Single<List<String>> getStorageDirectories() {
        return Single.fromCallable(new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                List<String> storageDirectories = Collections.EMPTY_LIST;

                storageDirectories = Arrays.asList(StorageUtil.getStorageDirectories(context));

                return storageDirectories;
            }
        });
    }

