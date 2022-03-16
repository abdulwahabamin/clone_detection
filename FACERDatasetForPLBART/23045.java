		@Override
		public void onClick(View v) {
			v.setClickable(false);
			if (v.equals(textViewCurrentSong)) {
				// The textView with the name of the song is pressed so the
				// play queue fragment is shown
				MainActivity mainActivity = (MainActivity) ButtonsFragment.this.getActivity();
				if (mainActivity != null)
					mainActivity.addPlayQueueFragment();
			} else {
				if (v.equals(playButton)) {
					// The play button becomes pause button when playing
					if (playQueue.isPlaying()) {
						intent.setAction(MusicService.ACTION_PAUSE);
					} else {
						intent.setAction(MusicService.ACTION_PLAY);
					}
				} else if (v.equals(previousButton)) {
					intent.setAction(MusicService.ACTION_PREVIOUS);

				} else if (v.equals(nextButton)) {
					intent.setAction(MusicService.ACTION_NEXT);

				} else {
					return;
				}
				// Don't start the music service if the playing queue is empty
				if (!playQueue.isEmpty()) {
					getActivity().startService(intent);
				}
			}
			v.setClickable(true);

		}

