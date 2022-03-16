		@Override
		protected String doInBackground(String... params) {
			//Check if the user is adding or removing an artist from the list.
			String operation = params[0];
			if (operation.equals("ADD")) {
				addArtistToLibrary();
			} else {
				removeArtistFromLibrary();
			}
			
			return null;
		}

