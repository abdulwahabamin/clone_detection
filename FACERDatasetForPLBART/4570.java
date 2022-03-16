		@Override
		public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int position,
				long arg3) {

			File f = fm.getDirectoryItemAsFile(position);
			if(f!=null) {
				
				if(State.getFileExploreState()==State.FILE_EXPLORE_STATE_STANDALONE && !f.isDirectory()) {
					//openOptions(f.getAbsolutePath());
                    popupMenu = new ExploreDialog(getActivity(),f,thisFragment,fm);

                    popupMenu.show();
                    popupMenu.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface intf) {
                            //BLog.e("DISMISS", "Called");
                            if(ExploreDialog.shouldRefresh)
                                refreshData();
                        }
                    });
				}

			}
			return true;
			
			
		}

