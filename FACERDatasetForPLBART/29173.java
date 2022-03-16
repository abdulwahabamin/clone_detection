    @Override
    public boolean quit() {
        mQuit = true;
        mDataPool.shutdown();
        return super.quit();
    }

