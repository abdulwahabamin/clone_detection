    @Override
    public void onMemberLeft(String member) {
        if(memberListAdapter != null) {
            memberListAdapter.notifyDataSetChanged();
        }
    }

