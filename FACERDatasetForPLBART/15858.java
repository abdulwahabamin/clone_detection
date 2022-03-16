    private void newClient(Connection connection){
        try {
            String newClientDeviceAddress = connection.getNextString();
            JSONObject jsonObject = new JSONObject(connection.getNextString());
            connection.close();
            clientMap.put(newClientDeviceAddress, new Client(jsonObject));
            groupMemberListener.onNewMemberJoined(newClientDeviceAddress, null);
        } catch (IOException | JSONException e) {
            Log.d("new client", e.toString());
        }
    }

