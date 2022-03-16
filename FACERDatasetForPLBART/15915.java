    @Override
    public void onMemberLeft(final String member) {
        if(currentGroup.groupMembers.get(member) == null) {
            return;
        }
        final String memberName = currentGroup.groupMembers.get(member).name;

        Library.deleteUser(memberName);
        clearPlayQueue(memberName);

        memberList.remove(memberName);
        for(final GroupMemberListener listener : groupMemberListenerList) {
            EasyHandler.executeOnMainThread(new Runnable() {
                @Override
                public void run() {
                    listener.onMemberLeft(memberName);
                }
            });
        }

        //since above executeOnMainThread()'s could still be running and accessing currentGroup, removeMember() is also called on main thread
        EasyHandler.executeOnMainThread(new Runnable() {
            @Override

