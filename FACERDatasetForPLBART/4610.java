		@Override
		public void onClick(View view) {
			Log.e("ARCHIVE","archive now clicked");
			amb.done();
        if(stopfiles.isEmpty() && zipfolder.getText().length()>0 && zipfilename.getText().length()>0) {
            String fn = zipfilename.getText().toString().replaceAll(".zip","")+".zip";
            BrowseService.ArchiveFiles(zipfolder.getText().toString(), fn, adapter.getSelectedFiles());
            goPreviousNow();
        }

			//deleteHandler.postDelayed(completedReturnPrevious, 1000);
		}

