	public PresetReverb getCurrentReverb() {
		if (mApp.getService().getCurrentMediaPlayer()==mApp.getService().getMediaPlayer())
			return getReverb();
		else
			return getReverb2();
	}

