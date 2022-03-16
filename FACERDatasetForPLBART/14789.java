    /**
     * Retrieves the tab item
     *
     * @param position - position of the tab fragment.
     * @return - New fragment.
     */
    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                AllMusicFragment allMusicFragment = new AllMusicFragment();
                return allMusicFragment;
            case 1:
                PlaylistFragment playlistFragment = new PlaylistFragment();
                return playlistFragment;
            case 2:
                BonusFragment bonusFragment = new BonusFragment();
                return bonusFragment;
            case 3:
                PlaylistMusicListFragment playlistMusicListFragment = new PlaylistMusicListFragment();
                return playlistMusicListFragment;
            default:
                return null;
        }
    }

