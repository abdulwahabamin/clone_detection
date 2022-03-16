	private synchronized void next() {
		mp.stop();
		mp.reset();
		try {
			fis.close();
		} catch (Exception e) {
			Log.w(TAG, "Failed to close the file");
			e.printStackTrace();
		}

		if(!this._shuffle){
			songAbsoluteFileNamesPosition = (songAbsoluteFileNamesPosition + 1)
					% songAbsoluteFileNames.length;
		} else {
			songAbsoluteFileNamesPosition = grabNextShuffledPosition();
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
			// I think our best chance is to go to the next song
			next();
		}
		updateNotification();
	}

