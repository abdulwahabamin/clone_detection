		@Override
		public void onDismiss(DialogInterface intf) {
			//BLog.e("DISMISS", "Called");
			if(ExploreDialog.shouldRefresh)
				refreshFragment.refresh();
		}

