    private void switchTo(Fragment fragment, String tag, boolean destroyPreviousFragment,
                         boolean forceReattach) {
        if(fragment == currentFragment && !forceReattach)
            return;

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if(currentFragment != null) {
            if(destroyPreviousFragment)
                transaction.remove(currentFragment);
            else
                transaction.detach(currentFragment);
        }

        if(fragmentManager.findFragmentByTag(tag) == null)
            transaction.add(containerViewId,fragment,tag);
        else
            transaction.attach(fragment);
        currentFragment = fragment;
        currentFragmentTag = tag;
        transaction.commit();
    }

