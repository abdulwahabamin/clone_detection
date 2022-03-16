    @Override
    public void onConnectionSuccess(String connectedGroup) {
        this.connectedGroupName = connectedGroup;
        ((ListView)rootView.findViewById(R.id.group_list)).setOnItemClickListener(null);
        setStatusConnected();
        joinStatus = ShareGroup.JoinStatus.CONNECTED;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1,
                ShareGroup.shareGroupWeakReference.get().getMemberList());
        ((ListView)rootView.findViewById(R.id.group_list)).setAdapter(adapter);
        ((TextView) rootView.findViewById(R.id.group_members_caption)).setText("Group Members");
    }

