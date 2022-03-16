		@Override
		protected Boolean doInBackground(Boolean... params) {
			eqValues = mApp.getDBAccessHelper()
				 	   .getSongEQValues(mApp.getService()
						 			  		.getCurrentSong()
						 			  		.getId());
			
			return null;
		}

