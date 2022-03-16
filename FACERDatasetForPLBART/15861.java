    private void clientLeftNotification(Connection connection) {
        try {
            String leftClientAddress = connection.getNextString();
            connection.close();
            clientMap.remove(leftClientAddress);
            groupMemberListener.onMemberLeft(leftClientAddress);
        } catch (IOException e) {
            //TODO: handle
        }
    }

