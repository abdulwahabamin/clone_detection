    public AsyncApplyEQToGenreTask(Context context, 
    							   String genreName,
    							   int fiftyHertzLevel, 
    							   int oneThirtyHertzLevel, 
    							   int threeTwentyHertzLevel, 
    							   int eightHundredHertzLevel, 
    							   int twoKilohertzLevel, 
    							   int fiveKilohertzLevel, 
    							   int twelvePointFiveKilohertzLevel, 
    							   int virtualizerLevel, 
    							   int bassBoostLevel, 
    							   int reverbSetting) {
    	
    	mContext = context.getApplicationContext();
    	mApp = (Common) mContext;
    	titleGenre = genreName;
    	
    	mFiftyHertzLevel = fiftyHertzLevel;
        mOneThirtyHertzLevel = oneThirtyHertzLevel;
        mThreeTwentyHertzLevel = threeTwentyHertzLevel;
        mEightHundredHertzLevel = eightHundredHertzLevel;
        mTwoKilohertzLevel = twoKilohertzLevel;
        mFiveKilohertzLevel = fiveKilohertzLevel;
        mTwelvePointFiveKilohertzLevel = twelvePointFiveKilohertzLevel;
        mVirtualizerLevel = virtualizerLevel;
        mBassBoostLevel = bassBoostLevel;
        mReverbSetting = reverbSetting;
    	
    }

