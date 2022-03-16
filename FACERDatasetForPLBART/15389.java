        private boolean setDataSourceImpl(MediaPlayer player, String path) {
            try {
                player.reset();
                player.setOnPreparedListener(null);
                if (path.startsWith("content://")) {
                    player.setDataSource(ApolloService.this, Uri.parse(path));
                } else {
                    player.setDataSource(path);
                }
                player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                player.prepare();
            } catch (IOException ex) {
                return false;
            } catch (IllegalArgumentException ex) {
                return false;
            }
            player.setOnCompletionListener(listener);
            player.setOnErrorListener(errorListener);
            Intent i = new Intent(AudioEffect.ACTION_OPEN_AUDIO_EFFECT_CONTROL_SESSION);
            i.putExtra(AudioEffect.EXTRA_AUDIO_SESSION, getAudioSessionId());
            i.putExtra(AudioEffect.EXTRA_PACKAGE_NAME, getPackageName());
            sendBroadcast(i);
            Intent intent = new Intent(AudioEffect.ACTION_DISPLAY_AUDIO_EFFECT_CONTROL_PANEL);
    	    if (getPackageManager().resolveActivity(intent, 0) == null) {
    	    	MusicUtils.initEqualizer( player , getApplicationContext());
    	    }    	                                
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            String type = sp.getString(VISUALIZATION_TYPE, getResources().getString(R.string.visual_none));                    
    	    if(!type.equals(getResources().getString(R.string.visual_none))){
        	    VisualizerUtils.initVisualizer( player );
            }
            return true;
        }

