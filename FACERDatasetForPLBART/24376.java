    private void setupTab(ActionBar actionBar, String preferenceKey, int titleResId,
                          Class<? extends Fragment> fragmentClass) {
        Fragment fragment = MusicBrowserActivity.this.getFragmentManager().findFragmentByTag(fragmentClass.getCanonicalName());
        if (fragment != null && !fragment.isDetached()) {
            FragmentTransaction ft = MusicBrowserActivity.this.getFragmentManager().beginTransaction();
            ft.detach(fragment);
            ft.commit();
        }

        if (PreferenceManager.getDefaultSharedPreferences(this).getBoolean(preferenceKey, true)) {
            actionBar.addTab(actionBar.newTab()
                    .setText(titleResId)
                    .setTag(fragmentClass.getCanonicalName())
                    .setTabListener(tabListener));
        }
    }

