    @Override
    public void onStart() {
        if (!isReturnStart){
            MainThreadImpl.getMainThread().post(new Runnable() {
                @Override
                public void run() {
                    listener.onStart((double)hasDownedSize / totalSize);
                }
            });
        }
        isReturnStart = true;
    }

