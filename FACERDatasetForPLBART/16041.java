    @Override
    public void onNewMemberJoined(String memberId, String memberName) {
        if(memberListAdapter != null) {
            memberListAdapter.notifyDataSetChanged();
        }
    }

