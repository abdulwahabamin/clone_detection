    @Override
    public void onOwnerDisconnected() {
        Toast.makeText(getContext(), "Owner disconnected. Group closed", Toast.LENGTH_LONG).show();
        joinStatus = ShareGroup.JoinStatus.RECENTLY_DISCONNECTED;
        ((TextView) rootView.findViewById(R.id.group_members_caption)).setText("Nearby Groups");
        initializeViews();
    }

