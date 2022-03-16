    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (changed) {
            mPath.reset();
            mPath.moveTo(0, getHeight());
            mPath.lineTo(getWidth(), getHeight() / 2);
            mPath.lineTo(0, 0);
            mPath.close();
        }
        super.onLayout(changed, left, top, right, bottom);
    }

