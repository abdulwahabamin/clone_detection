    private void closeConnection() {
        group.deleteGroup();
        group.close();
        group = null;
        closeListener.onConnectionClose();
    }

