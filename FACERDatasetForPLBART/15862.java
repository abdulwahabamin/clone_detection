    public void getRawSocket(String deviceId, ResponseListener responseListener) {
        try {
            Connection connection = new Connection(clientMap.get(deviceId).inetAddress,
                    clientMap.get(deviceId).port);

            connection.sendString(p2pBroadcastReceiver.myDevice.deviceAddress);
            connection.sendInt(ACTION_RAW_SOCKET);

            responseListener.onResponseReceived(connection.getSocket());
        } catch (IOException e) {
            responseListener.onRequestFailed();
        }
    }

