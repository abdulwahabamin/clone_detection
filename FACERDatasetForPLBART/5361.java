    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            fileEx.find(Environment.getExternalStorageDirectory().toString(),query)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<List<FileDirectory>>() {

                        @Override
                        public void onSubscribe(Subscription s) {
                            s.request(Long.MAX_VALUE);
                        }

                        @Override
                        public void onNext(List<FileDirectory> fileDirectories) {
                            searchResultList=fileDirectories;
                            fileDirectoryList=searchResultList;
                            //Toast.makeText(getApplicationContext(),"search list size: "+fileDirectories.size(),Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onError(Throwable t) {
                            Log.e("SearchActivity","Error message: "+t.getMessage());
                        }

                        @Override
                        public void onComplete() {
                            if(searchResultList.size()==0) {
                                errorText.setVisibility(View.VISIBLE);
                                back.setVisibility(View.VISIBLE);
                            }
                            searchListAdapter=new SearchListAdapter(searchResultList,SearchActivity.this);
                            progressBar.setVisibility(View.GONE);
                            searchRecyclerView.setAdapter(searchListAdapter);
                            searchListAdapter.setOnRecyclerItemClickListener(SearchActivity.this);
                            //Toast.makeText(getApplicationContext(),"Completed ",Toast.LENGTH_SHORT).show();
                        }
                    });
            //Toast.makeText(getApplicationContext(), "Search is working", Toast.LENGTH_SHORT).show();
        }
    }

