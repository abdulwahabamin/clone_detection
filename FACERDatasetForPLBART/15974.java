    @Override
    public void onPause() {
        super.onPause();
        if (group != null) {
            group.unregisterGroupConnectionListener(this);
            group.unregisterGroupMemberListener(this);

            if(joinStatus == ShareGroup.JoinStatus.NOT_CONNECTED
                    && getContext() != null) {
                group.stopFindingGroups();
            }
        }
    }

