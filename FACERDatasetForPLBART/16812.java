    @Override
    public void onCategorySelected(MediaBrowserCompat.MediaItem mediaItem) {
        FireLog.d(TAG, "(++) onCategorySelected, mediaItem= " + mediaItem);
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(CategoryFragment.TAG);
        if (fragment != null && fragment instanceof CategoryFragment) {
            title = mediaItem.getDescription().getTitle() + "";
            fragment = MediaListFragment.newInstance(title, mediaItem.getMediaId());
            String tag = MediaListFragment.TAG;

            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(
                            R.anim.slide_in_from_right, R.anim.slide_out_to_left,
                            R.anim.slide_in_from_left, R.anim.slide_out_to_right)
                    .replace(R.id.flContent, fragment, tag)
                    .addToBackStack(null)
                    .commit();
        }
    }

