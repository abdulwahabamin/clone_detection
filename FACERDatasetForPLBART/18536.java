	@Override
	public void onPause() {
		super.onPause();
		
		if (this.isRemoving()) {
			cursor.close();
		}
		
	}

