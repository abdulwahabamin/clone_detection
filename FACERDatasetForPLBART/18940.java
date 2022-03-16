	/**
	 * Releases all EQ objects and sets their references to null.
	 */
	public void releaseEQObjects() throws Exception {
		mEqualizer.release();
		mEqualizer2.release();
		mVirtualizer.release();
		mVirtualizer2.release();
		mBassBoost.release();
		mBassBoost2.release();
		mReverb.release();
		mReverb2.release();
		
		mEqualizer = null;
		mEqualizer2 = null;
		mVirtualizer = null;
		mVirtualizer2 = null;
		mBassBoost = null;
		mBassBoost2 = null;
		mReverb = null;
		mReverb2 = null;
		
	}

