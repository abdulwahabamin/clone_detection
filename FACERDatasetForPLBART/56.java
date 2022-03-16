    public void getPairedDevices()
    {
       Set<BluetoothDevice> devices=adapter.getBondedDevices();
        Iterator<BluetoothDevice> itr=devices.iterator();
        while(itr.hasNext())
        {
            BluetoothDevice bd=itr.next();
            al3.add(bd);
            al1.add(bd.getName());
            al2.add(bd.getAddress());
        }
        lv.setAdapter(new MyAdapter(MainPage.this,R.layout.cust_list));
    }

