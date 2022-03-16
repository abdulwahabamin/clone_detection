		@Override
		public boolean onError(MediaPlayer mMediaPlayer, int what, int extra) {
			/* This error listener might seem like it's not doing anything. 
			 * However, removing this will cause the mMediaPlayer object to go crazy 
			 * and skip around. The key here is to make this method return true. This 
			 * notifies the mMediaPlayer object that we've handled all errors and that 
			 * it shouldn't do anything else to try and remedy the situation. 
			 * 
			 * TL;DR: Don't touch this interface. Ever.
			 */
			return true;
		}

