    private Boolean isOnline(){
        final ConnectivityManager conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo activeNetwork = conMgr.getActiveNetworkInfo();
        if (activeNetwork != null && activeNetwork.isConnected()) {

            if (!isUp() && !isTouch) {
                mBothmusicPlayer.setTranslationY(getValues.ScreenHeight() - getValues.dpToPx(mMiniMusicplayerheight) - mAdView.getHeight());
            }

            if (!isAdLoaded) {
                AdRequest adRequest = new AdRequest.Builder().build();
                mAdView.loadAd(adRequest);
            }
            mAdView.setVisibility(View.VISIBLE);

            isTouch = true;
            return true;
        } else {
            isAdLoaded=false;
            SetupOnAdFailed();
            isTouch =false;
            return false;
        }
    }

