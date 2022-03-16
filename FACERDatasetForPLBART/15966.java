    @Override
    public void onConnectionFailed(String failureMessage) {
        Toast.makeText(getContext(), failureMessage, Toast.LENGTH_LONG).show();
        rootView.findViewById(R.id.creating_group_progress_bar).setVisibility(View.INVISIBLE);
        TextView connectionStatus = (TextView)rootView.findViewById(R.id.connection_status);
        connectionStatus.setText("Not Connected");
        connectionStatus.setTextColor(Color.parseColor("#0a5900"));
        this.joinStatus = ShareGroup.JoinStatus.NOT_CONNECTED;
        initializeViews();
    }

