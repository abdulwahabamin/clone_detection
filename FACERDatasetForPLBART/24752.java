    private void SetupOnAdFailed(){
        SetupGetValue();
        mAdView.setVisibility(View.INVISIBLE);

        RelativeLayout.LayoutParams layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(0, 0, 0, 0);
        mContentArea.setLayoutParams(layoutParams);

        if (!isUp() && !isTouch) {
            mBothmusicPlayer.setTranslationY(ScreenHeight - getValues.dpToPx(mMiniMusicplayerheight));
        }
    }

