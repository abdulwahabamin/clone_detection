    public DownLoadEntity queryDownLoadInfo(final DownLoadEntity entity) {
        entity.setLoadedData(0);
        final Call<ResponseBody> call;

        call = NetService.getInstance().getDownLoadService().getHttpHeader(entity.getUrl(),
                "bytes=" + 0 + "-" + 0);

        executeGetFileWork(call,new GetFileInfoListener(call,entity));
        while (!getFileService.isShutdown() && getCount() != 1) {

        }
        return entity;
    }

