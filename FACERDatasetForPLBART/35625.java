    @Override
    public void onCancel(DownLoadEntity entity) {
        if (!isReturnCancel){
            MainThreadImpl.getMainThread().post(new Runnable() {
                @Override
                public void run() {
                    listener.onCancel();
                }
            });
        }

        isReturnCancel = true;
    }

