    public void stopFindingGroups() {
        if(netService == null) { netService = NetworkService.getServiceBinder(); }
        netService.stopDiscovery();
        foundGroups.clear();
        groupListAdapter.clear();
    }

