    @Override
    public void onDestroy() {
        MusicUtils.unbindFromService(this);
        super.onDestroy();
        if (mCursor != null) {
            mCursor.close();
        }
    }

