		@Override
		public void onClick(View view) {
            fm.addSelectedFile(new FileItem(usefile));
			State.addCachedFileManager(fm);
            Bgo.openFragmentBackStack(activity, new FilesDeleteFragment());
            shouldRefresh=false;
			thisDialog.dismiss();

		}

