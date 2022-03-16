    private void setStatusConnecting() {
        TextView connectionStatus = (TextView)rootView.findViewById(R.id.connection_status);
        connectionStatus.setText("Connecting");
        connectionStatus.setTextColor(Color.parseColor("#FF00506B"));
        rootView.findViewById(R.id.creating_group_progress_bar).setVisibility(View.VISIBLE);
    }

