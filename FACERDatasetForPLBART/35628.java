    @Override
    public void onError(final DownLoadEntity entity, final FailureMessage message) {
        if (!isReturnError) {
            MainThreadImpl.getMainThread().post(new Runnable() {
                @Override
                public void run() {
                    listener.onError(entity,message);
                }
            });
        }

        isReturnError = true;
    }

