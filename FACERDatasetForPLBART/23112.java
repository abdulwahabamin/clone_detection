	@Override
	public void onDestroy() {
		stopForeground(true);
		if (mMediaPlayer.isPlaying())
			mMediaPlayer.stop();
		mMediaPlayer.release();
		mMediaPlayer = null;
		stopCpuProfilerService();
		super.onDestroy();
	}

