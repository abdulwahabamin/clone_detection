    public DownLoadTask(DownLoadEntity entity, IDownLoadTaskListener listener) {
        this.entity = entity;
        this.listener = listener;
        this.saveFileName = entity.getFileName();
        this.needDownSize = entity.getEnd() - (entity.getStart() + entity.getLoadedData());
        this.CALL_BACK_LENGTH = needDownSize / 100;
        failureMessage = new FailureMessage();
    }

