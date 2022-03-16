        @Override
        public void onClick(View view){
            if(view == shuffleButton){
                if(!fragmentCommunicator.shuffleSongs()){
                    fragmentCommunicator.setShuffle(true);
                    shuffleButton.setColorFilter(Color.BLACK);
                }else{
                    fragmentCommunicator.setShuffle(false);
                    shuffleButton.setColorFilter(Color.LTGRAY);
                }
            }else if(view == repeatButton){
                if (!fragmentCommunicator.repeatSong()){
                    fragmentCommunicator.setRepeat(true);
                    repeatButton.setImageResource(R.drawable.ic_repeat_one_black_24dp);
                }else{
                    fragmentCommunicator.setRepeat(false);
                    repeatButton.setImageResource(R.drawable.ic_repeat_black_24dp);
                }
            }else if(view == previousButton){
                fragmentCommunicator.previousButtonAction();
                currentSongName.setText(fragmentCommunicator.getCurrentSongName());
                totalTime.setText(fragmentCommunicator.getSongLengthText());
            }else if(view == playButton){
                if(fragmentCommunicator.isMusicPlaying()){
                    playButton.setImageResource(R.drawable.ic_play);
                }else{
                    playButton.setImageResource(R.drawable.ic_pause);
                }
                fragmentCommunicator.playButtonAction();
            }else{
                fragmentCommunicator.nextButtonAction();
                currentSongName.setText(fragmentCommunicator.getCurrentSongName());
                totalTime.setText(fragmentCommunicator.getSongLengthText());
            }
        }

