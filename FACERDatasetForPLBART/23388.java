    public void next(boolean force) {
        synchronized (this) {
            if (mOneShot) {
                // we were playing a specific file not part of a playlist, so there is no 'next'
                seek(0);
                play();
                return;
            }

            if (mPlayListLen <= 0) {
                return;
            }

            // Store the current file in the history, but keep the history at a
            // reasonable size
            if (mPlayPos >= 0) {
                mHistory.add(Integer.valueOf(mPlayPos));
            }
            if (mHistory.size() > MAX_HISTORY_SIZE) {
                mHistory.removeElementAt(0);
            }

            if (mShuffleMode == SHUFFLE_NORMAL) {
                // Pick random next track from the not-yet-played ones
                // TODO: make it work right after adding/removing items in the queue.

                int numTracks = mPlayListLen;
                int[] tracks = new int[numTracks];
                for (int i=0;i < numTracks; i++) {
                    tracks[i] = i;
                }

                int numHistory = mHistory.size();
                int numUnplayed = numTracks;
                for (int i=0;i < numHistory; i++) {
                    int idx = mHistory.get(i).intValue();
                    if (idx < numTracks && tracks[idx] >= 0) {
                        numUnplayed--;
                        tracks[idx] = -1;
                    }
                }

                // 'numUnplayed' now indicates how many tracks have not yet
                // been played, and 'tracks' contains the indices of those
                // tracks.
                if (numUnplayed <=0) {
                    // everything's already been played
                    if (mRepeatMode == REPEAT_ALL || force) {
                        //pick from full set
                        numUnplayed = numTracks;
                        // The following check is to prevent the scenario
                        // where songs are deleted after creating the song
                        // play list and in the repeat all mode it still
                        // assumes that there will be some songs present in
                        // the play list. if no. of unplayed songs become -ve then
                        // all songs are already played. Go to the idle State
                        if (numUnplayed <= 0) {
                            Log.e("@@@@ Service","Songs Play list is empty so going to the idle State");
                            if (mPlayer.isInitialized()) {
                                mPlayer.stop(); // Moving the Player to stop state, to acknowledge suspend
                            }
                            gotoIdleState();
                            return;
                        }
                        for (int i=0;i < numTracks; i++) {
                            tracks[i] = i;
                        }
                    } else {
                        // all done
                        if (mPlayer.isInitialized()) {
                            mPlayer.stop(); // Moving the Player to stop state, to acknowledge suspend
                        }
                        gotoIdleState();
                        return;
                    }
                }
                int skip = mRand.nextInt(numUnplayed);
                int cnt = -1;
                while (true) {
                    while (tracks[++cnt] < 0)
                        ;
                    skip--;
                    if (skip < 0) {
                        break;
                    }
                }
                mPlayPos = cnt;
            } else if (mShuffleMode == SHUFFLE_AUTO) {
                doAutoShuffleUpdate();
                mPlayPos++;
            } else {
                if (mPlayPos >= mPlayListLen - 1) {
                    // we're at the end of the list
                    if (mRepeatMode == REPEAT_NONE && !force) {
                        // all done
                        if (mPlayer.isInitialized()) {
                            mPlayer.stop(); // Moving the Player to stop state, to acknowledge suspend
                        }
                        gotoIdleState();
                        notifyChange(PLAYBACK_COMPLETE);
                        mIsSupposedToBePlaying = false;
                        return;
                    } else if (mRepeatMode == REPEAT_ALL || force) {
                        mPlayPos = 0;
                    } else if ((mRepeatMode == REPEAT_CURRENT) && (mOpenFailedCounter > 0)) {
                        // If the last clip in the playlist is an unsupported one, skip to the first
                        // clip in the playlist even if the "repeat current song" option is selected.
                        // This is the same behaviour as when the unsupported content is not the last
                        // clip in the playlist.
                        mPlayPos = 0;
                    }
                } else {
                    mPlayPos++;
                }
            }
            saveBookmarkIfNeeded();
            stop(false);
            if(!mSkipPlay)
            {
                openCurrent();
                play();
                notifyChange(META_CHANGED);
            }
            mPlayClip = mSkipPlay;
        }
    }

