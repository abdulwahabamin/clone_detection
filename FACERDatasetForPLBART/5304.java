    void delete(String path, String name) {


        Flowable.create(new FlowableOnSubscribe<Void>() {
            @Override
            public void subscribe(FlowableEmitter<Void> e) throws Exception {

                Uri treeUri = Uri.parse(sharedPreferences.getString(Util.BASE_URI, ""));
                DocumentFile documentFile = DocumentFile.fromTreeUri(Browse.this, treeUri);
                documentFile = documentFile.findFile(name);
                if (documentFile != null) {
                    documentFile.delete();

                } else {
                    String processedPath = Util.getProcessedPath(new File(path).getParent());
                    documentFile = Util.getDocumentFile(Browse.this, processedPath, name, treeUri);
                    documentFile.delete();
                }
                e.onComplete();

            }
        }, BackpressureStrategy.BUFFER)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new FlowableSubscriber<Void>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Void aVoid) {

                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e(TAG, "delete error: " + t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        //Toast.makeText(getApplicationContext(),"Files deleted.",Toast.LENGTH_SHORT).show();
                        filesAdapter.clearSelectedList();
                        filesAdapter.disableSelection();
                        paste.setVisibility(View.GONE);
                        filesAdapter.getOnDirectoryChangeListener()
                                .onDirectoryChange(loadDirectories());
                        showOrHideOptions(View.GONE);
                        interstitialAd.loadAd(new AdRequest.Builder().build());
                    }
                });
    }

