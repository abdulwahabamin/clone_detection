	public void showErrorDialog(final int code) {
        runOnUiThread(new Runnable() {
        	
            @Override
            public void run() {
              Dialog d = GooglePlayServicesUtil.getErrorDialog(
		                 code,
		                 LauncherActivity.this,
		                 REQUEST_CODE_RECOVER_FROM_PLAY_SERVICES_ERROR);
              d.show();
            }
            
        });
        
    }

