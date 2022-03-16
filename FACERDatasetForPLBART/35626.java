    @Override
    public void onDownLoading(long downSize) {
        hasDownedSize += downSize;
        MainThreadImpl.getMainThread().post(new Runnable() {
            @Override
            public void run() {
                double percent = (double)hasDownedSize / totalSize;
                listener.onDownloading(percent);
                Log.e("hasDownedSize", percent + "");

            }
        });
    }

