    public void fetchCurrentStorageDirectory(final String currentDirPath) {
        compositeDisposable.add(Single
                .fromCallable(new Callable<List<FileModel>>() {
                    @Override
                    public List<FileModel> call() throws Exception {
                        List<FileModel> fileModelList = new ArrayList<FileModel>();

                        File mFile = new File(currentDirPath);
                        File[] filesList = mFile.listFiles();
                        Arrays.sort(filesList, new MyCustomFileNameComparator());

                        for (File myFile : filesList) {
                            FileModel tempFileModel = new FileModel();
                            tempFileModel.setName(myFile.getName());
                            tempFileModel.setFolder(myFile.isDirectory());
                            tempFileModel.setParentDirectoryPath(myFile.getParent());
                            tempFileModel.setFileSize(myFile.isDirectory() ? "" : getFileSize(myFile));

                            fileModelList.add(tempFileModel);
                        }

                        return fileModelList;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(mainScheduler)
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

