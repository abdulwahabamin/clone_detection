    @Override
    public void OnJoinGroupSelected(String username) {
        joinFragment = JoinGroupFragment.newInstance(new ShareGroup(getActivity(), username,
                ShareGroup.Mode.JOIN_GROUP), this);

        connectivityFragmentSwitcher.switchTo(joinFragment, JOIN_FRAGMENT_TAG);
    }

