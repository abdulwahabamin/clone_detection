    public void setImageBitmap(final Bitmap b) {
        //final int THUMBSIZE = 200;

        mDrawable=null;
        mBitmap = b;
        //mDrawable = image;
        mSpinner.setVisibility(View.GONE);
        mImage.setVisibility(View.VISIBLE);
        mImage.setImageBitmap(mBitmap);
        //imageDrawableLoadedHandler.sendEmptyMessage(COMPLETE);

    }

