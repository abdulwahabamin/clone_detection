    public void deleteGroup()  {
        for(Client client : clientMap.values()) {
            Connection connection = null;
            try {
                connection = new Connection(client.inetAddress, client.port);
                connection.sendString(p2pBroadcastReceiver.myDevice.deviceAddress);
                connection.sendInt(ACTION_PEACEOUT);
                Log.d("deleteGroup","notified "+client.inetAddress);
            } catch (IOException e) {
                Log.d("deleteGroup", "failed to inform "+client.inetAddress+"\n"+e.toString());
            } finally {
                if(connection != null) {
                    connection.close();
                }
            }
        }

        p2pManager.removeGroup(channel, null);
        p2pManager.clearLocalServices(channel, null);
        server.close();
        p2pBroadcastReceiver.clearGroupInfoListener();
    }

