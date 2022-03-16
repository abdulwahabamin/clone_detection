    private void reloadQueue() {
        String q = null;

        int id = mCardId;
        if (mPersistentState.contains(SettingsActivity.CARDID)) {
            id = mPersistentState.getInt(SettingsActivity.CARDID, ~mCardId);
        }
        if (id == mCardId) {
            // Only restore the saved playlist if the card is still
            // the same one as when the playlist was saved
            q = mPersistentState.getString(SettingsActivity.PLAYQUEUE, "");
        }
        int qlen = q != null ? q.length() : 0;
        if (qlen > 1) {
            int plen = 0;
            int n = 0;
            int shift = 0;
            for (int i = 0; i < qlen; i++) {
                char c = q.charAt(i);
                if (c == ';') {
                    ensurePlayListCapacity(plen + 1);
                    mPlayList[plen] = n;
                    plen++;
                    n = 0;
                    shift = 0;
                } else {
                    if (c >= '0' && c <= '9') {
                        n += ((c - '0') << shift);
                    } else if (c >= 'a' && c <= 'f') {
                        n += ((10 + c - 'a') << shift);
                    } else {
                        // bogus playlist data
                        plen = 0;
                        break;
                    }
                    shift += 4;
                }
            }
            mPlayListLen = plen;

            int pos = mPersistentState.getInt(SettingsActivity.CURPOS, 0);
            if (pos < 0 || pos >= mPlayListLen) {
                // The saved playlist is bogus, discard it
                mPlayListLen = 0;
                return;
            }
            mPlayPos = pos;

            // When reloadQueue is called in response to a card-insertion,
            // we might not be able to query the media provider right away.
            // To deal with this, try querying for the current file, and if
            // that fails, wait a while and try again. If that too fails,
            // assume there is a problem and don't restore the state.
            Cursor crsr = MusicUtils.query(this,
                    MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                    new String[]{"_id"}, "_id=" + mPlayList[mPlayPos], null, null);
            if (crsr == null || crsr.getCount() == 0) {
                // wait a bit and try again
                SystemClock.sleep(3000);
                crsr = getContentResolver().query(
                        MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                        CURSOR_COLS, "_id=" + mPlayList[mPlayPos], null, null);
            }
            if (crsr != null) {
                crsr.close();
            }

            if (mPlayListLen > 0) {
                stop();
                if (prepare(mPlayList[mPlayPos])) {
                    fetchMetadata(mPlayList[mPlayPos]);
                } else {
                    mPlayListLen = 0;
                    return;
                }
            }

            long seekpos = mPersistentState.getLong(SettingsActivity.SEEKPOS, 0);
            seek(seekpos >= 0 && seekpos < duration() ? seekpos : 0);

            int repmode = mPersistentState.getInt(SettingsActivity.REPEATMODE, REPEAT_NONE);
            if (repmode != REPEAT_ALL && repmode != REPEAT_CURRENT) {
                repmode = REPEAT_NONE;
            }
            mRepeatMode = repmode;
        }
    }

