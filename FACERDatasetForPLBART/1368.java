    /**
     * Initializes all BLE Peripheral services so we can advertise later on.
     */
    private void initService() {
        mGattServer = mBluetoothManager.openGattServer(mContext, mGattServerCallback);

        BluetoothGattService service = new BluetoothGattService(BLEChatProfile.SERVICE_UUID,
                BluetoothGattService.SERVICE_TYPE_PRIMARY);

        BluetoothGattCharacteristic messageCharacteristic =
                new BluetoothGattCharacteristic(BLEChatProfile.CHARACTERISTIC_MESSAGE_UUID,
                        //Read-write characteristic, supports notifications
                        BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_NOTIFY,
                        BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE);
        BluetoothGattDescriptor messageDesc = new BluetoothGattDescriptor(BLEChatProfile.DESCRIPTOR_MESSAGE_UUID,
                BluetoothGattDescriptor.PERMISSION_WRITE | BluetoothGattDescriptor.PERMISSION_READ);
        messageCharacteristic.addDescriptor(messageDesc);

        BluetoothGattCharacteristic versionCharacteristic =
                new BluetoothGattCharacteristic(BLEChatProfile.CHARACTERISTIC_VERSION_UUID,
                        //Read-only characteristic
                        BluetoothGattCharacteristic.PROPERTY_READ,
                        BluetoothGattCharacteristic.PERMISSION_READ);

        BluetoothGattCharacteristic descriptionCharacteristic =
                new BluetoothGattCharacteristic(BLEChatProfile.CHARACTERISTIC_DESC_UUID,
                        //Read-write characteristic, supports notifications
                        BluetoothGattCharacteristic.PROPERTY_READ,
                        BluetoothGattCharacteristic.PERMISSION_READ);

        BluetoothGattCharacteristic transferCharacteristic =
                new BluetoothGattCharacteristic(BLEChatProfile.CHARACTERISTIC_RFCOMM_TRANSFER_UUID,
                        //Read-write characteristic, supports notifications
                        BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_NOTIFY,
                        BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE);
        BluetoothGattDescriptor transferRateDesc = new BluetoothGattDescriptor(BLEChatProfile.DESCRIPTOR_RFCOMM_TRANSFER_UUID,
                BluetoothGattDescriptor.PERMISSION_WRITE | BluetoothGattDescriptor.PERMISSION_READ);
        transferCharacteristic.addDescriptor(transferRateDesc);

        BluetoothGattCharacteristic transferBleCharacteristic =
                new BluetoothGattCharacteristic(BLEChatProfile.CHARACTERISTIC_BLE_TRANSFER_UUID,
                        //Read-write characteristic, supports notifications
                        BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE | BluetoothGattCharacteristic.PROPERTY_NOTIFY,
                        BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE);
        BluetoothGattDescriptor transferBleDesc = new BluetoothGattDescriptor(BLEChatProfile.DESCRIPTOR_BLE_TRANSFER_UUID,
                BluetoothGattDescriptor.PERMISSION_WRITE | BluetoothGattDescriptor.PERMISSION_READ);
        transferBleCharacteristic.addDescriptor(transferBleDesc);


        service.addCharacteristic(descriptionCharacteristic);
        service.addCharacteristic(versionCharacteristic);
        service.addCharacteristic(messageCharacteristic);
        service.addCharacteristic(transferCharacteristic);
        service.addCharacteristic(transferBleCharacteristic);


        mGattServer.addService(service);
    }

