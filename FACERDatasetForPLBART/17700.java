    @Override
    public void startArtistFragment(MediaBrowserCompat.MediaItem item) {
        if (mArtistFragment == null) {
            mArtistFragment = new ArtistFragment();
        }

        Bundle args = new Bundle();
        args.putParcelable("mediaItem", item);
        mArtistFragment.setArguments(args);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack(ArtistFragment.BACK_STACK_TAG, 0);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fade enterFade = new Fade();
        enterFade.setStartDelay(0);
        enterFade.setDuration(300);
        mArtistFragment.setEnterTransition(enterFade);

        fragmentTransaction.replace(R.id.upperFragmentFl, mArtistFragment);
        fragmentTransaction.addToBackStack(ArtistFragment.BACK_STACK_TAG);
        fragmentTransaction.commit();
    }

