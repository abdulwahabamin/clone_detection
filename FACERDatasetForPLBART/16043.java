    @Override
    public void onOwnerDisconnected() {
        if(memberListAdapter != null) {
            memberListAdapter.notifyDataSetChanged();
        }
    }

