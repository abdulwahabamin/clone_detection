    private void restoreActiveTab(ActionBar actionBar) {
        String activeTab = getSharedPreferences(getPackageName(), MODE_PRIVATE).getString(SettingsActivity.ACTIVE_TAB, null);
        for (int i = 0; i < actionBar.getTabCount(); i++) {
            if (actionBar.getTabAt(i).getTag().equals(activeTab)) {
                actionBar.setSelectedNavigationItem(i);
                viewPager.setCurrentItem(i);
                break;
            }
        }
    }

