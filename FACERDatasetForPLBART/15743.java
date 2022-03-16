    private void showPlay() {
        ImageView playButton = (ImageView) findViewById(R.id.peek_player_play_pause);
        playButton.setImageResource(R.drawable.glideplayer_play_white);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(v);
            }
        });
    }

