    @Override
    public void close() {
        netService = null;
        context.stopService(new Intent(context, NetworkService.class));
        handler.closeAllHandlers();
        deleteFiles();
        shareGroupWeakReference = null;
        networkNotification.dismissNetworkNotification();
    }

