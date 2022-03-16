        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                //We've temporarily lost focus, so pause the mMediaPlayer, wherever it's at.
                try {
                    isPlay=false;
                    getCurrentMediaPlayer().pause();

                    //updateWidgets();
                    mAudioManagerHelper.setHasAudioFocus(false);
                    if(UtilFunctions.currentVersionSupportLockScreenControls()){
                        remoteControlClient.setPlaybackState(RemoteControlClient.PLAYSTATE_PAUSED);
                    }
                    MainActivity.changeButton();
                    updateNotification();

                } catch (Exception e) {
                }

            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                //Lower the current mMediaPlayer volume.
                mAudioManagerHelper.setAudioDucked(true);
                mAudioManagerHelper.setTargetVolume(5);
                mAudioManagerHelper.setStepDownIncrement(1);
                mAudioManagerHelper.setCurrentVolume(mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
                mAudioManagerHelper.setOriginalVolume(mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
                mHandler.post(duckDownVolumeRunnable);

            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                if(UtilFunctions.currentVersionSupportLockScreenControls()){
                    remoteControlClient.setPlaybackState(RemoteControlClient.PLAYSTATE_PLAYING);
                }
                if (mAudioManagerHelper.isAudioDucked()) {
                    //Crank the volume back up again.
                    mAudioManagerHelper.setTargetVolume(mAudioManagerHelper.getOriginalVolume());
                    mAudioManagerHelper.setStepUpIncrement(1);
                    mAudioManagerHelper.setCurrentVolume(mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC));

                    mHandler.post(duckUpVolumeRunnable);
                    mAudioManagerHelper.setAudioDucked(false);
                } else {
                    //We've regained focus. Update the audioFocus tag, but don't start the mMediaPlayer.
                    mAudioManagerHelper.setHasAudioFocus(true);
                    MainActivity.changeButton();
                    updateNotification();
                    UpdateMetadata();
                }



            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                //We've lost focus permanently so pause the service. We'll have to request focus again later.
                getCurrentMediaPlayer().pause();
                if(UtilFunctions.currentVersionSupportLockScreenControls()){
                    remoteControlClient.setPlaybackState(RemoteControlClient.PLAYSTATE_PAUSED);
                }
                isPlay=false;
                mAudioManagerHelper.setHasAudioFocus(false);

                MainActivity.changeButton();
                updateNotification();
            }

        }

