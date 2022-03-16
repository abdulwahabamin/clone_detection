    @Override
    protected void onResume() {
        super.onResume();

        ViewUpdater.addSubsriber(this);
        ViewUpdater.addSubsriber(pagerAdapter);

        pagerAdapter.refreshData(false);
    }

