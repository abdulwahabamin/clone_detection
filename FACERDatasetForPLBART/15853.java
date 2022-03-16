    void stopDiscovery() {
        if(discoveryRequest!=null) {
            p2pManager.removeServiceRequest(channel, discoveryRequest, null); //TODO: add action listener
            p2pManager.clearLocalServices(channel, null); //TODO: add action listener
            discoveryRequest = null;
            discoveredP2pGroups.clear();
        }
    }

