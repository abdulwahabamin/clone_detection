    private void LoadAds(){
        mAdView.setVisibility(View.INVISIBLE);
        //mAdView.getLayoutParams().height=getValues.dpToPx(50);
        
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorCode) {
                SetupOnAdFailed();
                isAdLoaded=false;
            }

            @Override
            public void onAdLoaded() {
                SetupOnAdLoaded();
                isAdLoaded=true;
            }

        });
    }

