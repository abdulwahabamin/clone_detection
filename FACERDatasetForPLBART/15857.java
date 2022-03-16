    private void establish(InetAddress inetAddress, int port)throws IOException, JSONException {
        Connection ownerCon = new Connection(inetAddress, port);
        ownerCon.sendString(p2pBroadcastReceiver.myDevice.deviceAddress);

        ownerCon.sendInt(ACTION_ESTABLISH);
        ownerCon.sendInt(server.getPort());
        getClientMap(ownerCon);

        ownerCon.close();
    }

