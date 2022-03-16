        @Override
        public void onReceive(Context context, Intent intent) {
            String command = intent.getStringExtra("player_command");
            handleCommand(command);
            changedSongFromNotification = true;
        }

