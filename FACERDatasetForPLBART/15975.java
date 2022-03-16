    @Override
    public void onResume() {
        super.onResume();
        if (group != null) {
            group.registerGroupConnectionListener(this);
            group.registerGroupMemberListener(this);
            joinStatus = group.getJoinStatus();
        }
    }

