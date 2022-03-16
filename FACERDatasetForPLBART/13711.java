    public void fetchAllStorageDirectoryFiles() {
        compositeDisposable.add(storageUtilHelper.getStorageDirectories()
                .subscribeOn(Schedulers.io())
                .observeOn(mainScheduler)
                .map(new Function<List<String>, List<FileModel>>() {
                    @Override
                    public List<FileModel> apply(@NonNull List<String> strings) throws Exception {
                        List<FileModel> fileModelList = new ArrayList<FileModel>();
                        for (String filePathString : strings) {
                            File[] listFiles = new File(filePathString).listFiles();
                            Arrays.sort(listFiles, new MyCustomFileNameComparator());

                            for (File myFile : listFiles) {
                                FileModel tempFileModel = new FileModel();
                                tempFileModel.setParentDirectoryPath(filePathString);
                                tempFileModel.setFolder(myFile.isDirectory());
                                tempFileModel.setName(myFile.getName());
                                tempFileModel.setFileSize(myFile.isDirectory() ? "" : getFileSize(myFile));

                                fileModelList.add(tempFileModel);
                            }
                        }
                        return fileModelList;
                    }
                })
                .subscribeWith(new DisposableSingleObserver<List<FileModel>>() {
                    @Override
                    public void onSuccess(@NonNull List<FileModel> fileModels) {
                        if (fileModels.size() > 0)
                            view.onSuccess(fileModels);
                        else
                            view.onSuccess("");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.onError("Error: " + e.getMessage());
                    }
                }));
    }

