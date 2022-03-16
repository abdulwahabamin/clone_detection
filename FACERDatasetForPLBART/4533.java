		@Override
		public void onDismiss(DialogInterface intf) {
			//BLog.e("DISMISS", "Called");
			if(ExploreRenameDialog.shouldRefresh)
				refreshFragment.refresh();
		}

