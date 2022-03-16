    @Override
    public void startAlbumFragment(MediaBrowserCompat.MediaItem item, View animatingView) {
        Log.d(TAG, "startAlbumFragment:called");

        if (mAlbumFragment == null) {
            mAlbumFragment = new AlbumFragment();
        }

        Bundle args = new Bundle();
        args.putParcelable("mediaItem", item);
        mAlbumFragment.setArguments(args);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack(AlbumFragment.BACK_STACK_TAG, 0);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fade enterFade = new Fade();
        enterFade.setStartDelay(0);
        enterFade.setDuration(300);
        mAlbumFragment.setEnterTransition(enterFade);

        fragmentTransaction.replace(R.id.upperFragmentFl, mAlbumFragment);
        fragmentTransaction.addToBackStack(AlbumFragment.BACK_STACK_TAG);
        fragmentTransaction.commit();
    }

