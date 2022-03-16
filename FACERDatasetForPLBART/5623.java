	@Override
	public void onClick(View view) {
		mDialog = ProgressDialog.show(ApplicationBackup.this, 
				  					  "Backing up applications",
				  					  "", true, false);
		
		Thread all = new Thread(new BackgroundWork(mAppList));
		all.start();
	}

