    public String getGroupName() {
        if(currentGroup != null) {
            return currentGroup.groupName;
        } else {
            return lastJoinedGroupName;
        }
    }

