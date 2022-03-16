    private void initializeViews() {
        switch (joinStatus) {
            case CONNECTED:
                onConnectionSuccess(connectedGroupName);
                break;
            case CONNECTING:
                setStatusConnecting();
                break;
            case RECENTLY_DISCONNECTED:
                ((TextView)rootView.findViewById(R.id.connection_status))
                        .setText("Disconnected from " + connectedGroupName + ". Owner closed the group");
            case NOT_CONNECTED:
                groupAdapter = new GroupAdapter(getContext(), group.getGroupList());
                setupGroupList();
                group.findGroups(groupAdapter);
                break;
            case EXCHANGING_INFO:
                onExchangingInfo();
                break;
        }
    }

