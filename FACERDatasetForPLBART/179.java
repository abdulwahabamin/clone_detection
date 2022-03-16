    @Override
    public void onServicesDiscovered(BluetoothGatt gatt, int status) {
       List<BluetoothGattService>  services=gatt.getServices();
       for (BluetoothGattService service:services){
           List<BluetoothGattCharacteristic> characteristics=service.getCharacteristics();
           for (BluetoothGattCharacteristic characteristic: characteristics){
                if (characteristic.getUuid().toString().equals(UUIDString)){
                    characteristic.setValue("找到你啦");
                   // service.writeToParcel(characteristic);
               }
           }
       }
    }

