		@Override
		public void onClick(View v) {
			fm.addSelectedClipboardCopyFile(usefile);
//BLog.e("USEFILE: "+usefile.getAbsolutePath());
		    //Device.copyToClipboard(activity, usefile.getAbsolutePath());
			shouldRefresh=true;
		    thisDialog.dismiss();
		    
		}

