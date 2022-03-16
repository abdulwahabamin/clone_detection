    private void playClick(int position) {
        MainActivity activity = (MainActivity) getActivity();
        if (null != musicService) {
            Music music = songs.get(position);
            musicService.setCurrentItem(position);
            musicService.setSongs(songs);
            musicService.playMusic(music.getPath());
            activity.showFragment(4);
        }
    }

