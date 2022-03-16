	@Override
	public void onPause() {
		super.onPause();
		amb.done();
        if(useFile!=null) {
            File delf = new File(useFile);
            if(delf.exists())
                delf.delete();
        }
	}

