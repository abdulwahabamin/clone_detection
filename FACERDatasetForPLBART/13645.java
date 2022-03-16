    public void backUpApp(final File srcFile, final File destDir) {
        compositeDisposable.add(Single.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return FileUtil.getInstance().copyFile(srcFile, destDir);
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(mainScheduler)
                .subscribeWith(new DisposableSingleObserver<Boolean>() {
                    @Override
                    public void onSuccess(@NonNull Boolean aBoolean) {
                        if (aBoolean)
                            view.onError("Apk backup Success"); //Currently reusing to display snackbar
                        else
                            view.onError("Apk backup Failed");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.onError("Error: " + e.getMessage());
                    }
                }));
    }

