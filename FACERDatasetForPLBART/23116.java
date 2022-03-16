		@Override
		public void onCompletion(MediaPlayer mp) {
			resetSongPlayingRef();
			// Play next
			playSong(playQueue.getNext());
		}

