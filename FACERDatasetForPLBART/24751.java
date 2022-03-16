    private void SetupOnAdLoaded(){
        mAdView.setVisibility(View.VISIBLE);
        RelativeLayout.LayoutParams layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(0, 0, 0, mAdView.getHeight());
        mContentArea.setLayoutParams(layoutParams);

        ScreenHeight=getValues.ScreenHeight()-mAdView.getHeight()+getValues.dpToPx(4);

        if (!isUp() && !isTouch)
        {
            mBothmusicPlayer.setTranslationY(ScreenHeight - getValues.dpToPx(mMiniMusicplayerheight));
        }

    }

