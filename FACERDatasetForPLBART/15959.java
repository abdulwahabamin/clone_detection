    @Override
    public void onResume() {
        super.onResume();
        if(group != null) {
            group.registerGroupCreationListener(this);
            group.registerGroupMemberListener(this);
            ((ArrayAdapter) ((ListView) rootView.findViewById(R.id.peer_list))
                    .getAdapter()).notifyDataSetChanged();
        }
    }

