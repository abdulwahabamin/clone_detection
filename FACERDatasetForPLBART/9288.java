    @Override
    public void dealloc() {
        super.dealloc();

        // Synchronize the underlaying storage
        mSyncHandler.removeMessages(MSG_SYNC_FS);
        sync();
    }

