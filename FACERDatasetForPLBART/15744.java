    private void showPause() {
        ImageView playButton = (ImageView) findViewById(R.id.peek_player_play_pause);
        playButton.setImageResource(R.drawable.glideplayer_pause_white);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause(v);
            }
        });
    }

