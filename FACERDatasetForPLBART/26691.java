    private void setImageViewVisible(boolean visible) {
        if (mImageView != null) {
            if (visible) {
                mImageView.setVisibility(View.VISIBLE);
            } else {
                mImageView.setVisibility(View.GONE);
            }
        }
    }

