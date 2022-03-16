    private static final void SetupMargin(Boolean isMiniPlayerVisible){
        RelativeLayout.LayoutParams layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        if (isMiniPlayerVisible){
            layoutParams.setMargins(0,getValues.GetStatusBarHeight()+getValues.dpToPx(mToolbar_height),0,2*getValues.dpToPx(mMiniMusicplayerheight));
        }
        else {
            layoutParams.setMargins(0,getValues.GetStatusBarHeight() + getValues.dpToPx(mToolbar_height),0,getValues.dpToPx(mMiniMusicplayerheight));
        }
        mRootofList.setLayoutParams(layoutParams);
    }

