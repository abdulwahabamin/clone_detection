    public static BluetoothService getBLUETOOTHSERVICE(BluetoothSocket socket, String macAddress,String name_other)
    {

        if (BLUETOOTHSERVICE==null)
        {
            Utils.log("Creating new Bluetooth Service");
            BLUETOOTHSERVICE=new BluetoothService(socket,macAddress,macAdress_my,name_other);
            addressName.put(macAddress,name_other);
            if (!notify_id.containsKey(macAddress))
            {
                notify_id.put(macAddress,new Random().nextInt());
            }
            user= Realm.getDefaultInstance().where(User.class).equalTo("macAddress",macAddress).findFirst();
            return BLUETOOTHSERVICE;
        }

        if (BLUETOOTHSERVICE.macAddress.equals(macAddress))
        {
            Utils.log("bservice already exists, giving back");
            return BLUETOOTHSERVICE;
        }else {
            closeBluetoothService(BLUETOOTHSERVICE.macAddress);
            return getBLUETOOTHSERVICE(socket,macAddress,name_other);
        }
    }

