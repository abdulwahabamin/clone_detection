		public void handleMessage(Message msg) {
			
			switch(msg.what) {
				case SET_PROGRESS:
					mDialog.setMessage((String)msg.obj);
					break;
				case FINISH_PROGRESS:
					mDialog.cancel();
					Toast.makeText(ApplicationBackup.this, 
								   "Applications have been backed up", 
								   Toast.LENGTH_SHORT).show();
					break;
			}
		}

