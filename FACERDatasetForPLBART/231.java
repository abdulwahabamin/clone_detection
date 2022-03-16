    private void initDeviceBondState() {
        bondState = mDevice.getBondState();

        if (bondState == BluetoothDevice.BOND_BONDED) {
            tvState.setText("已�?对");
        } else if (bondState == BluetoothDevice.BOND_BONDING) {
            tvState.setText("�?对中");
        } else {
            tvState.setText("未�?对");
        }

        initBondButton();

        if (mDevice.getUuids() != null && mDevice.getUuids().length > 0) {
            list.addAll(Arrays.asList(mDevice.getUuids()));
            uuidAdapter.notifyDataSetChanged();
        }
    }

