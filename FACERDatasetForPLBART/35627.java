    @Override
    public void onCompleted(DownLoadEntity entity) {
        MainThreadImpl.getMainThread().post(new Runnable() {
            @Override
            public void run() {
                listener.onCompleted();
            }
        });
    }

