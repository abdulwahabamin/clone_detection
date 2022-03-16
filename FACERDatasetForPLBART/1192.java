    public void startConnection(BluetoothSocket socket) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(mActivity);
        String username = sharedPref.getString("username", BluetoothAdapter.getDefaultAdapter().getName());
        mConnectedThread = new ConnectedThread(socket);
        mConnectedThread.start();

        if (isHost) {
            connections.add(mConnectedThread);
            byte[] idAssignmentPacket = buildPacket(
                    MESSAGE_ID,
                    username,
                    new byte[] { (byte) connections.size() }
            );
            mConnectedThread.write(idAssignmentPacket);
        }
    }

