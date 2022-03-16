    /**
     * Includes System apps + Installed Apps
     */
    public void fetchAllApps() {
        compositeDisposable.add(helper.getAllApps()
                .subscribeOn(Schedulers.io())
                .observeOn(mainScheduler)
                .subscribeWith(new DisposableSingleObserver<List<AppModel>>() {
                    @Override
                    public void onSuccess(@NonNull List<AppModel> appModelList) {
                        if (appModelList.size() > 0)
                            view.onSuccess(appModelList);
                        else
                            view.onError("No Files Found");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.onError("Error: " + e.getMessage());
                    }
                }));
    }

