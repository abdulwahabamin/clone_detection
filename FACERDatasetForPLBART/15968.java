    private void setStatusConnected() {
        rootView.findViewById(R.id.creating_group_progress_bar).setVisibility(View.INVISIBLE);
        Toast.makeText(getContext(), "Connected to " + connectedGroupName,
                Toast.LENGTH_LONG).show();
        TextView connectionStatus = (TextView)rootView.findViewById(R.id.connection_status);
        connectionStatus.setText("Connected to " + connectedGroupName);
        connectionStatus.setTextColor(Color.parseColor("#FF0A5900"));
    }

