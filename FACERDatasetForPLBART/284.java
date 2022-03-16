    private void updateValue() {
        BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(serviceUuid));
        if (service == null) return;
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString(charUuid));
        enableNotification(characteristic, charUuid);
        characteristic.setValue("on");
        bluetoothGatt.writeCharacteristic(characteristic);
    }

