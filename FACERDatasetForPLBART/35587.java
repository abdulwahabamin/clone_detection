    public void download(final DownLoadEntity entity, final IDownLoadListener listener) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                DownLoadRequest downLoadRequest = new DownLoadRequest(entity,listener);
                downLoadRequest.start();
            }
        });
    }

