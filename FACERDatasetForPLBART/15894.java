    public void createGroup(final String groupName, final GroupCreationListener groupCreationListener,
                            GroupMemberListener groupMemberListener) {
        if(netService == null) { netService = NetworkService.getServiceBinder(); }
        isOwner = true;
        currentGroup = new GlidePlayerGroup(null,null,groupName, 1);

        registerGroupCreationListener(groupCreationListener);
        GroupCreationListener localCreationListener = new GroupCreationListener() {
            @Override
            public void onGroupCreated() {
                networkNotification.displayNetworkNotification(currentGroup.groupName, true);
                for(final GroupCreationListener listener : groupCreationListenerList) {
                    creationStatus = CreationStatus.GROUP_CREATED;
                    EasyHandler.executeOnMainThread(new Runnable() {
                        @Override
                        public void run() {
                            listener.onGroupCreated();
                        }
                    });
                }
            }

            @Override
            public void onGroupCreationFailed(final String failureMessage) {
                for(final GroupCreationListener listener : groupCreationListenerList) {
                    EasyHandler.executeOnMainThread(new Runnable() {
                        @Override
                        public void run() {
                            creationStatus = CreationStatus.GROUP_NOT_CREATED;
                            listener.onGroupCreationFailed(failureMessage);
                        }
                    });
                }
            }
        };

        registerGroupMemberListener(groupMemberListener);
        creationStatus = CreationStatus.GROUP_WAITING_FOR_CREATION;
        netService.createGroup(userName, groupName, localCreationListener, this, this);
    }

