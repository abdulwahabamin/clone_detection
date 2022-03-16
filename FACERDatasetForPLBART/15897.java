    public void deleteGroup() {
        if(netService == null) { netService = NetworkService.getServiceBinder(); }
        netService.deleteGroup();
        if(currentGroup != null) {
            Library.clearRemoteTables();
            for (Member member : currentGroup.groupMembers.values()) {
                clearPlayQueue(member.name);
            }
        }
    }

