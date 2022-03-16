        @Override
        public void onReceive(Context context, Intent intent) {
            if (AudioManager.ACTION_AUDIO_BECOMING_NOISY.equals(intent.getAction())) {
                FireLog.d(TAG, "Headphones disconnected.");
                if (isPlaying()) {
                    Intent i = new Intent(context, MusicPlayerService.class);
                    i.setAction(MusicPlayerService.ACTION_CMD);
                    i.putExtra(MusicPlayerService.CMD_NAME, MusicPlayerService.CMD_PAUSE);
                    context.startService(i);
                }
            }
        }

