    private void initView() {
        uuidAdapter = new UuidAdapter(this, list);
        tvName.setText(mDevice.getName() + "");

        tvAddress.setText(mDevice.getAddress() + "");

        tvUUID.setText(selectedUuidStr);


        initDeviceBondState();

        if (mDevice.getType() == BluetoothDevice.DEVICE_TYPE_LE) {
            tvType.setText("ä½ŽåŠŸè€—è“?ç‰™");
        } else if (mDevice.getType() == BluetoothDevice.DEVICE_TYPE_CLASSIC) {
            tvType.setText("ç»?å…¸è“?ç‰™");
        } else if (mDevice.getType() == BluetoothDevice.DEVICE_TYPE_DUAL) {
            tvType.setText("å?Œæ¨¡è“?ç‰™");
        } else {
            tvType.setText("æœªçŸ¥");
        }


        lvUUID.setAdapter(uuidAdapter);

        lvUUID.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedUuidStr = list.get(position).getUuid().toString();
                tvUUID.setText(selectedUuidStr);
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (bond) {
                    mDevice.createBond();
                    return;
                }



                service = ClientService.getInstance(handler);

                service.connect(mDevice, selectedUuidStr);

            }
        });

        for (ParcelUuid uuid : list) {
            if (uuid.getUuid().toString().equals(ClientService.clientUuid)) {
                selectedUuidStr = ClientService.clientUuid;
                tvUUID.setText(selectedUuidStr);
                return;
            }
        }


    }

