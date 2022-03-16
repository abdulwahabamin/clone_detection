    private void handleIntent(Intent intent){

        int selectData=intent.getExtras().getInt("select_data");
        if(selectData==QuickAccess.DOCUMENTS){
           loadDocuments();

        }else{

            loadMedia(selectData)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<List<FileDirectory>>() {

                        @Override
                        public void onSubscribe(Subscription s) {
                            mediaSubscription=s;
                            s.request(Long.MAX_VALUE);
                        }

                        @Override
                        public void onNext(List<FileDirectory> fileDirectoryList) {

                        }

                        @Override
                        public void onError(Throwable t) {
                            Log.e(TAG,"error: "+t.getMessage());
                        }

                        @Override
                        public void onComplete() {
                            fileList=Util.sortBy(fileList,Util.NAME);
                            mediaAdapter=new MediaAdapter(fileList,QuickAccess.this,selectData, Glide.with(QuickAccess.this));
                            mediaAdapter.setOnItemSelectedListener(QuickAccess.this);
                            mediaAdapter.setOnRecyclerItemClickListener(QuickAccess.this);
                            mediaRV.setAdapter(mediaAdapter);
                            progressBar.setVisibility(View.GONE);
                            sort.setVisibility(View.VISIBLE);
                        }
                    });
        }
    }

