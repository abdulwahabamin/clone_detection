    public static void closeBluetoothService(String macAddress)
    {
        if (BLUETOOTHSERVICE==null)
        {
            return;
        }


        try {
            if (!BLUETOOTHSERVICE.macAddress.equals(macAddress))
            {
                return;
            }

            String s=macAddress;
            if (s.isEmpty())
            {
                s=BLUETOOTHSERVICE.macAddress;
            }
            Utils.showToast(getINSTANCE().getApplicationContext(),addressName.get(s)+" "+Constants.ERROR_MSG[Constants.STATUS_DISCONNECTED]);
            Utils.log("application bservice close");
            BLUETOOTHSERVICE.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        BLUETOOTHSERVICE=null;
        Utils.log("application bservice null");
    }

