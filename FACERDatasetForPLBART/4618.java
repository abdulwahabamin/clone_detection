		@Override
		public void onClick(View view) {

			ArrayList<FileItem> fileitems = adapter.getSelectedFiles();
			if(fileitems!=null && !fileitems.isEmpty()) {
				for(FileItem f: fileitems) {
					((File) f).delete();
				}
			}
			deleteHandler.postDelayed(completedReturnPrevious, 1000);
		}

