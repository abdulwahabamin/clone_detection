    public static CreateGroupFragment newInstance(ShareGroup group,
                                                  ConnectionCloseListener closeListener) {
        CreateGroupFragment fragment = new CreateGroupFragment();
        fragment.group = group;
        fragment.closeListener = closeListener;

        if(group.getCreationStatus() != ShareGroup.CreationStatus.GROUP_NOT_CREATED) {
            fragment.groupName = group.getGroupName();
            fragment.groupCreationStatus = group.getCreationStatus();
        }

        return fragment;
    }

