    @Override
    public void startPlaylistFragment(MediaBrowserCompat.MediaItem item, View animatingView) {
        Log.d(TAG, "startAlbumFragment:called");

        if (mPlaylistFragment == null) {
            mPlaylistFragment = new PlaylistFragment();
        }

        Bundle args = new Bundle();
        args.putParcelable("mediaItem", item);
        mPlaylistFragment.setArguments(args);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack(PlaylistFragment.BACK_STACK_TAG, 0);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fade enterFade = new Fade();
        enterFade.setStartDelay(0);
        enterFade.setDuration(300);
        mPlaylistFragment.setEnterTransition(enterFade);

        fragmentTransaction.replace(R.id.upperFragmentFl, mPlaylistFragment);
        fragmentTransaction.addToBackStack(PlaylistFragment.BACK_STACK_TAG);
        fragmentTransaction.commit();
    }

