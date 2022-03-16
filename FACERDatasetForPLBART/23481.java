        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                if (mBack == null) {
                    mBack = mNowPlayingView.getBackground();
                }
                Drawable dr = getResources().getDrawable(android.R.drawable.menuitem_background);
                dr.setState(new int[] { android.R.attr.state_focused});
                mNowPlayingView.setBackgroundDrawable(dr);
                mNowPlayingView.setSelected(true);
            } else {
                mNowPlayingView.setBackgroundDrawable(mBack);
                mNowPlayingView.setSelected(false);
            }
        }

