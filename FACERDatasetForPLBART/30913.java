    @Override
    public void inflate() {
        if (mContext != null) {
            mBitmap = BitmapFactory.decodeResource(mContext.getResources(), mResId);
        }
    }

