    /**
     * {@inheritDoc}
     */
    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (!AndroidHelper.isTablet(this) && fragment instanceof TitlePreferenceFragment) {
            this.mTitle.setText(((TitlePreferenceFragment)fragment).getTitle());
        } else {
            this.mTitle.setText(R.string.pref);
        }
    }

