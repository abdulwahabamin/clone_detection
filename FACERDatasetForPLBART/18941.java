	public Equalizer getCurrentEqualizer() {
		if (mApp.getService().getCurrentMediaPlayer()==mApp.getService().getMediaPlayer())
			return getEqualizer();
		else
			return getEqualizer2();
	}

