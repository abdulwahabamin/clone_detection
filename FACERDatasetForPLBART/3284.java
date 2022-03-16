    public void setImageDrawable(final Drawable image) {
        mDrawable = image;
        mBitmap=null;
        mSpinner.setVisibility(View.GONE);
        mImage.setVisibility(View.VISIBLE);
        imageLoadedHandler.sendEmptyMessage(COMPLETE);

    }

