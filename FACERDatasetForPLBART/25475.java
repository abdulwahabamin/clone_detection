	private synchronized void previous() {
		// if we're playing, and we're more than 3 seconds into the file, then
		// just
		// start the song over
		if (mp.isPlaying()) {
			int progressMillis = mp.getCurrentPosition();
			if (progressMillis > 3000) {
				mp.seekTo(0);
				return;
			}
		}

		mp.stop();
		mp.reset();
		try {
			fis.close();
		} catch (IOException e) {
			Log.w(TAG, "Failed to close the file");
			e.printStackTrace();
		}
		songAbsoluteFileNamesPosition = songAbsoluteFileNamesPosition - 1;
		if (songAbsoluteFileNamesPosition < 0) {
			songAbsoluteFileNamesPosition = songAbsoluteFileNames.length - 1;
		}
		String next = songAbsoluteFileNames[songAbsoluteFileNamesPosition];
		try {
			songFile = new File(next);
			fis = new FileInputStream(songFile);
			mp.setDataSource(fis.getFD());
			mReadaheadThread.setSource(songFile.getAbsolutePath());
			mp.prepare();
			mp.start();
		} catch (IOException e) {
			Log.w(TAG, "Failed to open " + next);
			e.printStackTrace();
			// Just go to the next song back
			previous();
		}
		updateNotification();
	}

