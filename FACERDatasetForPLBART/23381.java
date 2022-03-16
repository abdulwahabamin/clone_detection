    /**
     * Opens the specified file and readies it for playback.
     *
     * @param path The full path of the file to be opened.
     * @param oneshot when set to true, playback will stop after this file completes, instead
     * of moving on to the next track in the list 
     */
    public boolean open(String path, boolean oneshot) {
        synchronized (this) {
            if (path == null) {
                return true;
            }
            
            if (oneshot) {
                mRepeatMode = REPEAT_NONE;
                ensurePlayListCapacity(1);
                mPlayListLen = 1;
                mPlayPos = -1;
            }
            
            // if mCursor is null, try to associate path with a database cursor
            if (mCursor == null) {

                ContentResolver resolver = getContentResolver();
                Uri uri;
                String where;
                String selectionArgs[];
                if (path.startsWith("content://media/")) {
                    uri = Uri.parse(path);
                    where = null;
                    selectionArgs = null;
                } else {
                   uri = MediaStore.Audio.Media.getContentUriForPath(path);
                   where = MediaStore.Audio.Media.DATA + "=?";
                   selectionArgs = new String[] { path };
                }
                
                try {
                    mCursor = resolver.query(uri, mCursorCols, where, selectionArgs, null);
                    if  (mCursor != null) {
                        if (mCursor.getCount() == 0) {
                            mCursor.close();
                            mCursor = null;
                        } else {
                            mCursor.moveToNext();
                            ensurePlayListCapacity(1);
                            mPlayListLen = 1;
                            mPlayList[0] = mCursor.getInt(IDCOLIDX);
                            mPlayPos = 0;
                        }
                    }
                } catch (UnsupportedOperationException ex) {
                }
            }
            mFileToPlay = path;
            mPlayer.setDataSource(mFileToPlay);
            mOneShot = oneshot;
            mSkipPlay = false;
            if (! mPlayer.isInitialized()) {
                stop(true);
                mOpenFailedCounter++;
                // If there is only one clip in the playlist and is invalid content, notify user,
                // otherwise skip to next clip
                // need to make sure we only shows this once
                if ( mPlayListLen == 1 ) {
                    gotoIdleState();
                    notifyChange(PLAYBACK_COMPLETE);
                    mIsSupposedToBePlaying = false;
                    if(!mQuietMode) {
                        Toast.makeText(this, R.string.playback_failed, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    mSkipPlay = true;
                    next(false);
                    mSkipPlay = false;
                    return false;
                }
            } else {
                mOpenFailedCounter = 0;
            }
        }
        return true;
    }

