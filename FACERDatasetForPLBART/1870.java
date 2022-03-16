    public BluetoothService(BluetoothSocket socket, String macAddress,String macAddress_my,String name_other) {
        this.macAddress=macAddress;
        this.macAddress_my=macAddress_my;
        this.name_other=name_other;
        connectedThread=new ConnectedThread(socket);
        connectedThread.start();
    }

