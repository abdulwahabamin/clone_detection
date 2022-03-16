    public void setRecentList(){
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, -7);
           // Log.d(TAG,simpleDateFormat.format(calendar.getTime())+"");
            fileEx.findwithDate(Environment.getExternalStorageDirectory().toString(), simpleDateFormat.parse(simpleDateFormat
                    .format(calendar.getTime())))
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Subscriber<List<FileDirectory>>() {
                        @Override
                        public void onSubscribe(Subscription s) {
                            s.request(Long.MAX_VALUE);
                        }

                        @Override
                        public void onNext(List<FileDirectory> fileDirectoryList) {
                            recentList=fileDirectoryList;

                            Log.e(TAG,"name: "+recentList.size());
                        }

                        @Override
                        public void onError(Throwable t) {
                            Log.e(TAG,t.getMessage());
                        }

                        @Override
                        public void onComplete() {
                            setOrRefreshRecentItems(recentList);
                        }
                    });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

