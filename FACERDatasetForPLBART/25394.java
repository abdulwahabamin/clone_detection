    /**
     * Sets up the button for handling click events.
     */
    private void setupWidgets() {
        findViewById(R.id.wear_pause).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendCommand(Constants.ACTION_PAUSE);
            }
        });
        findViewById(R.id.wear_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendCommand(Constants.ACTION_PLAY);
            }
        });
        findViewById(R.id.wear_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendCommand(Constants.ACTION_NEXT);
            }
        });

        findViewById(R.id.wear_previous).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendCommand(Constants.ACTION_PREVIOUS);
            }
        });
    }

