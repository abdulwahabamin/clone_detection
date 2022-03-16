	public Virtualizer getCurrentVirtualizer() {
		if (mApp.getService().getCurrentMediaPlayer()==mApp.getService().getMediaPlayer())
			return getVirtualizer();
		else
			return getVirtualizer2();
	}

