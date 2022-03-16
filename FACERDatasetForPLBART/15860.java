    private void sendClientLeftNotification(String leftClientAddress) {
        Connection connection = null;

        for(String deviceAddress : clientMap.keySet()) {
            try {
                Client client = clientMap.get(deviceAddress);
                connection = new Connection(client.inetAddress, client.port);
                connection.sendString(deviceAddress);
                connection.sendInt(ACTION_CLIENT_LEFT);
                connection.sendString(leftClientAddress);
            } catch (IOException e) {
                Log.d("sendClientNotification", e.toString());
            } finally {
                if(connection != null) {
                    connection.close();
                }
            }
        }
    }

