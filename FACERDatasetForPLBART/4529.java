		@Override
		public void onClick(View v) {
			

		    shouldRefresh=false;
		    thisDialog.dismiss();
			Bgo.openFile(activity, fm, usefile);
		}

