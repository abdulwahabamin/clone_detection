    @Override
    public void OnCreateGroupSelected(String username) {
        createFragment = CreateGroupFragment.newInstance(new ShareGroup(getActivity(), username,
                ShareGroup.Mode.CREATE_GROUP), this);

        connectivityFragmentSwitcher.switchTo(createFragment,CREATE_FRAGMENT_TAG);
    }

