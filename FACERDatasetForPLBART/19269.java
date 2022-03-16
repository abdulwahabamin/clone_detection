		@Override
		protected String doInBackground(String... params) {
			//Check if the user is adding or removing an album from the list.
			String operation = params[0];
			if (operation.equals("ADD")) {
				addAlbumToLibrary();
			} else {
				removeAlbumFromLibrary();
			}
			
			return null;
		}

