    public void connectToGroup(int groupListIndex, final GroupConnectionListener connectionListener,
                               final GroupMemberListener memberListener) {
        //TODO: check if anyone else in the group has the same username
        if(netService == null) { netService = NetworkService.getServiceBinder(); }
        isOwner = false;
        String groupId = foundGroups.get(groupListIndex).ownerId;
        registerGroupConnectionListener(connectionListener);
        GroupConnectionListener connectionListener2 = new GroupConnectionListener() {
            @Override
            public void onConnectionSuccess(String connectedGroup) {
                for(GlidePlayerGroup group : foundGroups) {
                    if (group.ownerId.equals(connectedGroup)) {
                        currentGroup = group;
                        break;
                    }
                }
                stopFindingGroups();
                currentGroup.connected();
                lastJoinedGroupName = currentGroup.groupName;
                joinStatus = JoinStatus.EXCHANGING_INFO;
                networkNotification.displayNetworkNotification(currentGroup.groupName, false);
                for(GroupConnectionListener listener : groupConnectionListenerList) {
                    listener.onExchangingInfo();
                }
            }

            @Override
            public void onExchangingInfo() {} //never called
            @Override
            public void onConnectionFailed(final String failureMessage) {
                joinStatus = JoinStatus.NOT_CONNECTED;
                EasyHandler.executeOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        for(GroupConnectionListener listener : groupConnectionListenerList) {
                            listener.onConnectionFailed(failureMessage);
                        }
                    }
                });
            }

            @Override
            public void onOwnerDisconnected() {
                if(currentGroup == null) return;
                for(Member member: currentGroup.groupMembers.values()) {
                    clearPlayQueue(member.name);
                }

                memberList.clear();
                memberList.add(userName);
                Library.clearRemoteTables();
                currentGroup = null;
                stopFindingGroups();
                joinStatus = JoinStatus.RECENTLY_DISCONNECTED;
                networkNotification.displayNetworkNotification(null, false);
                for(final GroupConnectionListener listener : groupConnectionListenerList) {
                    EasyHandler.executeOnMainThread(new Runnable() {
                        @Override
                        public void run() {
                            listener.onOwnerDisconnected();
                        }
                    });
                }
            }
        };

        registerGroupMemberListener(memberListener);

        joinStatus = JoinStatus.CONNECTING;
        netService.connectToGroup(groupId, connectionListener2, this, this);
    }

