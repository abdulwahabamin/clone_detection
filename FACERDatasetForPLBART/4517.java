    @Override
    public void setImageBitmap(Bitmap bitmap) {
        if(bitmap!=null) {
            bmpWidth = bitmap.getWidth();
            bmpHeight = bitmap.getHeight();
            mLastTouchX = mPosX = 0;
            mLastTouchY = mPosY = 0;
        }
        //setWindowSize();
        super.setImageBitmap(bitmap);
    }

