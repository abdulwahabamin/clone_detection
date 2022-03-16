		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long arg3) {

			File f = fm.getDirectoryItemAsFile(position);
			if(f!=null) {
				if(f.isDirectory()) {
					fm.setCurrentDirectory(activity, f.getAbsolutePath());
					refreshData();
					title.setText(f.getName());
					path.setText(f.getAbsolutePath());

					//adapter.notifyDataSetChanged();
					
				}
			}
			
			
		}

