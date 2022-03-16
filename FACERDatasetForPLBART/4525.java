		@Override
		public void onClick(View view) {

            popupRename = new ExploreRenameDialog(activity,usefile,refreshFragment,fm);

            popupRename.show();
            popupRename.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface intf) {
                    //BLog.e("DISMISS", "Called");
                    if (ExploreRenameDialog.shouldRefresh)
                        refreshFragment.refreshData();
                }
            });


			//fm.addSelectedFile(new FileItem(usefile));
			//State.addCachedFileManager(fm);
			//Bgo.openFragmentBackStack(activity, new FilesDeleteFragment());
			shouldRefresh=false;
			thisDialog.dismiss();

		}

