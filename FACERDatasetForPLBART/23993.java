    private void saveQueue(boolean full) {
        if (!mQueueIsSaveable) {
            return;
        }

        Editor ed = mPersistentState.edit();
        //long start = System.currentTimeMillis();
        if (full) {
            StringBuilder q = new StringBuilder();

            // The current playlist is saved as a list of "reverse hexadecimal"
            // numbers, which we can generate faster than normal decimal or
            // hexadecimal numbers, which in turn allows us to save the playlist
            // more often without worrying too much about performance.
            // (saving the full state takes about 40 ms under no-load conditions
            // on the phone)
            int len = mPlayListLen;
            for (int i = 0; i < len; i++) {
                long n = mPlayList[i];
                if (n == 0) {
                    q.append("0;");
                } else if (n > 0) {
                    while (n != 0) {
                        int digit = (int) (n & 0xf);
                        n >>>= 4;
                        q.append(HEXDIGITS[digit]);
                    }
                    q.append(";");
                }
            }
            ed.putString(SettingsActivity.PLAYQUEUE, q.toString());
            ed.putInt(SettingsActivity.CARDID, mCardId);
        }
        ed.putInt(SettingsActivity.CURPOS, mPlayPos);
        if (mPlayers[mCurrentPlayer].isInitialized()) {
            ed.putLong(SettingsActivity.SEEKPOS, mPlayers[mCurrentPlayer].currentPosition());
        }
        ed.putInt(SettingsActivity.REPEATMODE, mRepeatMode);
        ed.apply();
    }

