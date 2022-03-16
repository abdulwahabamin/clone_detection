    private void updateMenu(PlayMode playMode) {
        MenuItem shuffle = menu.findItem(R.id.shuffle_mode);
        MenuItem repeat = menu.findItem(R.id.repeat_mode);
        switch (playMode) {
            case NONE:
                shuffle.setIcon(R.drawable.ic_shuffle_grey_24dp);
                repeat.setIcon(R.drawable.ic_repeat_grey_24dp);
                break;
            case SHUFFLE:
                shuffle.setIcon(R.drawable.ic_shuffle_white_24dp);
                repeat.setIcon(R.drawable.ic_repeat_grey_24dp);
                shuffleSongs();
                break;
            case SINGLE_REPEAT:
                shuffle.setIcon(R.drawable.ic_shuffle_grey_24dp);
                repeat.setIcon(R.drawable.ic_repeat_one_white_24dp);
                break;
            case ALL_REPEAT:
                shuffle.setIcon(R.drawable.ic_shuffle_grey_24dp);
                repeat.setIcon(R.drawable.ic_repeat_white_24dp);
                break;
            case SHUFFLE_REPEAT:
                shuffle.setIcon(R.drawable.ic_shuffle_white_24dp);
                repeat.setIcon(R.drawable.ic_repeat_white_24dp);
                break;
        }
    }

