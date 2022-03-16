    private void resolveBondingState(final int bondState) {
        if (pairCallback == null) {
            return;
        }
        switch (bondState) {
            case BluetoothDevice.BOND_BONDED://已�?对
                pairCallback.bonded();
                break;
            case BluetoothDevice.BOND_BONDING://�?对中
                pairCallback.bonding();
                break;
            case BluetoothDevice.BOND_NONE://未�?对
                pairCallback.unBonded();
                break;
            default:
                pairCallback.bondFail();
                break;
        }
    }

