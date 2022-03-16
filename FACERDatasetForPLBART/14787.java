    /**
     * Sets up the image buttons to the correct state.
     *
     */
    public void setupButtons(){
        if(fragmentCommunicator.repeatSong()){
            repeatButton.setImageResource(R.drawable.ic_repeat_one_black_24dp);
        }else{
            repeatButton.setImageResource(R.drawable.ic_repeat_black_24dp);
        }

        if(fragmentCommunicator.shuffleSongs()){
            shuffleButton.setColorFilter(Color.BLACK);
        }else{
            shuffleButton.setColorFilter(Color.LTGRAY);
        }
    }

