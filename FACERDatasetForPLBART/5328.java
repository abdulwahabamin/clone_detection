    void setOrRefreshRecentItems(List<FileDirectory> recentItemList){
        Util.getRecentlyAddedFiles(recentItemList)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new FlowableSubscriber<Map<String,List<FileDirectory>>>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Map<String,List<FileDirectory>> fileDirectoryMap) {
                        recentItemsMap=fileDirectoryMap;
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e(TAG,"Recent List Error: "+t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        List<String> keyList=Util.getRecentItemKeys();
                        recentFilesAdapter=new RecentFilesAdapter(Home.this
                                ,recentItemsMap,keyList, Glide.with(Home.this));
                        setRecentItemListener();
                        recentFilesAdapter.setOnDataLoadListener(new OnDataLoadListener() {
                            @Override
                            public void onDataLoaded(boolean loaded) {
                                if(recentsProgressBar.getVisibility()==View.VISIBLE)
                                    recentsProgressBar.setVisibility(View.GONE);
                            }
                        });
                        recentFilesView.setAdapter(recentFilesAdapter);
                    }
                });
    }

