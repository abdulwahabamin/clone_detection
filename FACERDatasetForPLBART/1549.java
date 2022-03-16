    public boolean scanDevice() {
        if (bluetoothAdapter.isDiscovering()) {
            return true;
        } else {
            return false;
        }

    }

