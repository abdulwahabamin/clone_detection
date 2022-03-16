    private void openCurrent() {
        synchronized (this) {
            if (mCursor != null) {
                mCursor.close();
                mCursor = null;
            }
            if (mPlayListLen == 0) {
                return;
            }
            boolean retCode = false;
            while(retCode != true)
            {
                stop(false);
                String id = String.valueOf(mPlayList[mPlayPos]);
                mCursor = getContentResolver().query(
                        MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                        mCursorCols, "_id=" + id , null, null);
                retCode = true;
                if (mCursor != null) {
                    mCursor.moveToFirst();
                    retCode = open(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI + "/" + id, false);
                    if(retCode == false)
                        continue;
                    // go to bookmark if needed
                    if (isPodcast()) {
                        long bookmark = getBookmark();
                        // Start playing a little bit before the bookmark,
                        // so it's easier to get back in to the narrative.
                        seek(bookmark - 5000);
                    }
                }
            }
            if(mPlayClip)
            {
                mPlayClip = false;
                play();
                notifyChange(META_CHANGED);
            }
        }
    }

