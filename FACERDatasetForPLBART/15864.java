    private String standardErrors(int reason) {
        if(reason == WifiP2pManager.ERROR) {
            return "Internal error occured";
        } else if (reason == WifiP2pManager.BUSY) {
            return "System busy. Try again";
        } else if (reason == WifiP2pManager.P2P_UNSUPPORTED){
            return "Device does not support Wifi Direct";
        }
        else return "Unknown error";
    }

