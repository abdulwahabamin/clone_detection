    public void start() {
        entity = downLoadHandle.queryDownLoadInfo(entity);
        long totalFileSize;
        long hasDownSize = 0;
        hasDownSize += entity.getLoadedData();
        if (entity.getTotal() == 0) {
            failMessage.clear();
            failMessage.setFailureMessage("文件读�?�失败");
            failMessage.setResultCode(-1);
            MainThreadImpl.getMainThread().post(new Runnable() {
                @Override
                public void run() {
                    listener.onError(entity, failMessage);
                }
            });
            return;
        } else {
            totalFileSize = entity.getTotal();
        }

        if (hasDownSize >= totalFileSize) {
            MainThreadImpl.getMainThread().post(new Runnable() {
                @Override
                public void run() {
                    listener.onCompleted();
                }
            });
            return;
        }
        taskListener = new DownLoadTaskListenerImpl(listener, totalFileSize, hasDownSize);
        taskListener.onStart();
        if (entity.getLoadedData() != entity.getTotal()) {
            entity.setEnd(entity.getTotal() - 1);
            entity.setStart(0);
            createDownLoadTask(entity,taskListener);
        }

    }

