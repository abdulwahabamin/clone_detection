    public static void setDiscoverable(Context ctx){

        if (counter==0 || ((System.currentTimeMillis()/1000)-counter)>300) {
            Intent discoverableIntent =
                    new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
            discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
            ctx.startActivity(discoverableIntent);
            counter=System.currentTimeMillis()/1000;
        }
    }

