    public DownLoadRequest(DownLoadEntity entity, IDownLoadListener listener) {
        this.entity = entity;
        this.listener = listener;
        failMessage = new FailureMessage();
        downLoadHandle = new DownLoadHandle();
        downloadService = Executors.newFixedThreadPool(CpuUtils.getNumCores() + 1);
    }

