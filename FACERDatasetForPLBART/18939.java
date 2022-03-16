	public EqualizerHelper(Context context, int audioSessionId1, 
						   int audioSessionId2, boolean equalizerEnabled) {
		
		//Context and helper objects.
		mContext = context.getApplicationContext();
		mApp = (Common) mContext;
		
		//Init mMediaPlayer's equalizer engine.
		mEqualizer = new Equalizer(0, audioSessionId1);
		mEqualizer.setEnabled(equalizerEnabled);
		
		//Init mMediaPlayer2's equalizer engine.
		mEqualizer2 = new Equalizer(0, audioSessionId2);
		mEqualizer2.setEnabled(equalizerEnabled);
		
		//Init mMediaPlayer's virtualizer engine.
		mVirtualizer = new Virtualizer(0, audioSessionId1);
		mVirtualizer.setEnabled(equalizerEnabled);
		
		//Init mMediaPlayer2's virtualizer engine.
		mVirtualizer2 = new Virtualizer(0, audioSessionId2);
		mVirtualizer2.setEnabled(equalizerEnabled);
		
		//Init mMediaPlayer's bass boost engine.
		mBassBoost = new BassBoost(0, audioSessionId1);
		mBassBoost.setEnabled(equalizerEnabled);
		
		//Init mMediaPlayer2's bass boost engine.
		mBassBoost2 = new BassBoost(0, audioSessionId2);
		mBassBoost2.setEnabled(equalizerEnabled);
		
		//Init mMediaPlayer's reverb engine.
		mReverb = new PresetReverb(0, audioSessionId1);
		mReverb.setEnabled(equalizerEnabled);
		
		//Init mMediaPlayer's reverb engine.
		mReverb2 = new PresetReverb(0, audioSessionId2);
		mReverb2.setEnabled(equalizerEnabled);
		
	}

