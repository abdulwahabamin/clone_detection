    private void incomingEstablishRequested(Connection newClientConnection,
                                            final String newClientDeviceAddress) {
        try {
            final InetAddress newClientInetAddress = newClientConnection.getRemoteInetAddress();
            final int newClientPort = newClientConnection.getNextInt();
            sendClientMap(newClientConnection);
            newClientConnection.close();
            clientMap.put(newClientDeviceAddress, new Client(newClientInetAddress, newClientPort));

            for (final String deviceAddress : clientMap.keySet()) {
                if(deviceAddress.equals(newClientDeviceAddress)) {
                    continue;
                }
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Client client = clientMap.get(deviceAddress);
                            Connection connection = new Connection(client.inetAddress, client.port);
                            connection.sendString(p2pBroadcastReceiver.myDevice.deviceAddress);
                            connection.sendInt(ACTION_NEW_CLIENT);
                            connection.sendString(newClientDeviceAddress);
                            connection.sendString(
                                    clientMap.get(newClientDeviceAddress).toJson().toString());
                            connection.close();
                        } catch (IOException | JSONException e) {
                            Log.d("notifying new client", e.toString());
                        }
                    }
                };
                new Thread(r).start();
            }

            groupMemberListener.onNewMemberJoined(newClientDeviceAddress, null);
        } catch (IOException | JSONException e) {
            Log.d("Incoming establish", e.toString());
        }
    }

