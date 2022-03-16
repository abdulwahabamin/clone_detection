    private void getClientMap(Connection connection)throws IOException, JSONException {
        int size = connection.getNextInt();

        for(; size>0; size--) {
            String deviceId = connection.getNextString();
            JSONObject jsonObject = new JSONObject(connection.getNextString());
            clientMap.put(deviceId, new Client(jsonObject));
        }
    }

