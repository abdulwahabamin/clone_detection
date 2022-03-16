    @Override
    public void run() {
        call = NetService.getInstance().getDownLoadService().downloadFile(entity.getUrl(),
                "bytes=" + entity.getStart() + "-" + entity.getEnd());

        ResponseBody result = null;
        try {
            Response<ResponseBody> response = call.execute();
            result = response.body();
            if (response.isSuccessful()) {
                if (writeToFile(result, entity.getStart(), entity.getLoadedData())) {
                    onCompleted();
                }
            } else {
                onError(new Throwable(response.message()));
            }
        } catch (IOException e) {
            onError(new Throwable(e.getMessage()));
        } finally {
            if (result != null) {
                result.close();
            }
        }
    }

