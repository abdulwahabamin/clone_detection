    void loadDocuments(){

        fileEx.find(Environment.getExternalStorageDirectory().toString(),FileEx.DOC_SELECTOR)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<FileDirectory>>() {

                    @Override
                    public void onSubscribe(Subscription s) {
                        documentSubscription=s;
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(List<FileDirectory> fileDirectories) {
                        fileList=fileDirectories;
                        //Toast.makeText(getApplicationContext(),"search list size: "+fileDirectories.size(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e("SearchActivity","Error message: "+t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        fileList=Util.sortBy(fileList,Util.NAME);
                        mediaAdapter=new MediaAdapter(fileList,QuickAccess.this,QuickAccess.DOCUMENTS,Glide.with(QuickAccess.this));
                        mediaAdapter.setOnItemSelectedListener(QuickAccess.this);
                        mediaAdapter.setOnRecyclerItemClickListener(QuickAccess.this);
                        mediaRV.setAdapter(mediaAdapter);
                        progressBar.setVisibility(View.GONE);
                        sort.setVisibility(View.VISIBLE);
                    }
                });
    }

