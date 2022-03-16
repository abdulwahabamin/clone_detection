    private void updateLibraryLists(String memberId) {
        final Member member = currentGroup.groupMembers.get(memberId);

        memberList.add(member.name);

        for(final GroupMemberListener listener : groupMemberListenerList) {
            EasyHandler.executeOnMainThread(new Runnable() {
                @Override
                public void run() {
                    listener.onNewMemberJoined(null, member.name);
                }
            });
        }
    }

