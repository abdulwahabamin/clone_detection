    private void setupGroupList() {
        ListView groupList = (ListView) rootView.findViewById(R.id.group_list);
        groupList.setAdapter(groupAdapter);
        final JoinGroupFragment fragment = this;
        groupList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                group.connectToGroup(position, fragment, fragment);
                setStatusConnecting();
                joinStatus = ShareGroup.JoinStatus.CONNECTING;
            }
        });
    }

