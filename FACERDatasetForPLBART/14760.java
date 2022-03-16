    @Override
    public void playSong(int songIndex){
        try{
//            sendNotification(songIndex);
            mediaPlayer.stop();
            mediaPlayer.reset();

            currentSongIndex = songIndex;
            File filePath = songList.get(currentSongIndex);

            FileInputStream fileInputStream = new FileInputStream(filePath);

            mediaPlayer.setDataSource(fileInputStream.getFD());
            mediaPlayer.prepare();

            long totalDuration = mediaPlayer.getDuration();
            long currentPosition = mediaPlayer.getCurrentPosition();

            seekBar.setProgress(0);
            currentTime.setText(milliSecondsToTime(currentPosition));
            seekBar.setMax(mediaPlayer.getDuration()/1000);
            totalTime.setText(milliSecondsToTime(totalDuration));
            currentSongName.setText(songList.get(songIndex).getName());

            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    seekBar.setProgress(0);

                    if(!mediaPlayer.isPlaying()){
                        if(repeatSong){
                            playSong(currentSongIndex);
                        }else if(shuffleSongs){
                            Random rand = new Random();
                            currentSongIndex = rand.nextInt((songList.size() - 1) + 1);
                            playSong(currentSongIndex);
                        }else if(repeatSong && shuffleSongs){
                            Random rand = new Random();
                            currentSongIndex = rand.nextInt((songList.size() - 1) + 1);
                            playSong(currentSongIndex);
                        }else{
                            if(currentSongIndex < (songList.size() - 1)){
                                playSong(currentSongIndex + 1);
                            }else{
                                playSong(0);
                            }
                        }
                    }
                }
            });

            currentSongLayout.setVisibility(View.VISIBLE);
            playButton.setImageResource(R.drawable.ic_pause);
            MainActivity.this.runOnUiThread(updateTimeTask);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

