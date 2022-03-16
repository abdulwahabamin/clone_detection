	@Override
	public void onDestroy() {
		super.onDestroy();

		try {
			if (mHelper!=null) {
		 		mHelper.dispose();
		 		mHelper = null;
		 	}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	 	
	}

