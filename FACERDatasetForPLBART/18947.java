	public BassBoost getCurrentBassBoost() {
		if (mApp.getService().getCurrentMediaPlayer()==mApp.getService().getMediaPlayer())
			return getBassBoost();
		else
			return getBassBoost2();
	}

