    private void createDownLoadTask(DownLoadEntity entity,IDownLoadTaskListener downLoadTaskListener) {
        DownLoadTask downLoadTask;
        downLoadTask = new DownLoadTask.Builder().downLoadEntity(entity).IDownLoadTaskListener
                (downLoadTaskListener).build();
        downloadService.submit(downLoadTask);
    }

