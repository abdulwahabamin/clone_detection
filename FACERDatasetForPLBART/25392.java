        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle dataBundle = intent.getBundleExtra("wear_data");
            TextView songTitle = (TextView) findViewById(R.id.wear_song_played_title);
            songTitle.setText(dataBundle.getString("song_title"));
            byte[] songCover = dataBundle.getByteArray("song_cover");

            CircleImageView circleImageView = (CircleImageView) findViewById(R.id.wear_song_cover);
            if (songCover != null) {
                Bitmap bmp = BitmapFactory.decodeByteArray(songCover, 0, songCover.length);
                circleImageView.setImageBitmap(bmp);
            } else {
                circleImageView.setImageResource(android.R.color.transparent);
            }

        }

