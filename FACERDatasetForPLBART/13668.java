    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            BaseFragment fragment = (BaseFragment) getFragmentManager().findFragmentByTag(CURRENT_TAG);
            if (fragment == null) {
                fragment = (BaseFragment) getFragmentManager().findFragmentByTag(TAG_DEFAULT);
            }

            fragment.performBackPressedOperation();
        }
    }

