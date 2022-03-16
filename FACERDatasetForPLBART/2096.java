    public void replaceChildFragment(File currentFile) {
        this.currentFile = currentFile;
        childFragment = FileViewFragment.newInstance(currentFile);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.child_fragment_container, childFragment);
        if (!firstFragment) {
            transaction.addToBackStack(null);
        } else {
            firstFragment = false;
        }
        transaction.commit();
    }

