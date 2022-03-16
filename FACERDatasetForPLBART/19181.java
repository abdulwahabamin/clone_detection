	@Override
	public void onPause() {
		super.onPause();

		try {
			if (isFinishing() && mHelper!=null) {
				mHelper.dispose();
				mHelper = null;	
			}
			
			finish();			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

