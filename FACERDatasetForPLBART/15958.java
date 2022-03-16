    @Override
    public void onPause() {
        super.onPause();
        if(group != null) {
            group.unregisterGroupCreationListener(this);
            group.unregisterGroupMemberListener(this);
        }
    }

