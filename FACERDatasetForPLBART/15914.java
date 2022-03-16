    @Override
    public void newGroupFound(String Id, String groupName, String ownerName, String deviceName, int memberCount) {
        GlidePlayerGroup newGroup = new GlidePlayerGroup(
                Id,
                new Member(ownerName, deviceName),
                groupName,
                memberCount);

        if(!foundGroups.contains(newGroup)) {
            foundGroups.add(newGroup);
            groupListAdapter.notifyDataSetChanged();
        }
    }

