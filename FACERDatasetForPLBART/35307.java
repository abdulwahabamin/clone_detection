    @Override
    public void onDestroy(){
        // 中断线程，�?�结�?�线程。
        if (mUpdateThread != null) {
            mUpdateThread.interrupt();
        }
        super.onDestroy();
    }

