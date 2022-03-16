    private void sendClientMap(Connection connection) throws IOException, JSONException {
        connection.sendInt(clientMap.entrySet().size());

        for(String deviceId : clientMap.keySet()) {
            connection.sendString(deviceId);
            JSONObject jsonObject = clientMap.get(deviceId).toJson();
            connection.sendString(jsonObject.toString());
        }
    }

