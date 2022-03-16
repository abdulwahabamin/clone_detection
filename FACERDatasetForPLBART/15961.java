    public static JoinGroupFragment newInstance(ShareGroup group,
                                                ConnectionCloseListener closeListener) {
        JoinGroupFragment fragment = new JoinGroupFragment();
        fragment.group = group;

        if(group.getJoinStatus() != ShareGroup.JoinStatus.NOT_CONNECTED) {
            fragment.connectedGroupName = group.getGroupName();
            fragment.joinStatus = group.getJoinStatus();
        }

        fragment.closeListener = closeListener;
        return fragment;
    }

