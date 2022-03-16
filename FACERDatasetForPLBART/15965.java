    private void closeConnection() {
        group.stopFindingGroups();
        group.deleteGroup();
        group.close();
        group = null;
        closeListener.onConnectionClose();
    }

