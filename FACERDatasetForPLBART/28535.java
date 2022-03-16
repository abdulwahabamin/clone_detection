    @Override
    protected void onPause() {
        super.onPause();

        ViewUpdater.removeSubsriber(this);
        ViewUpdater.removeSubsriber(pagerAdapter);
    }

