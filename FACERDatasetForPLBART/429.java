    private void implementListeners() {



        // listelemeye tıklayınca neler olacak
        listDevices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // devices cihazların listelendiği
                Set<BluetoothDevice> devices = bluetoothAdapter.getBondedDevices();

                // cihazların değeri kadar al ve diziye ata
                String[] strings = new String[devices.size()];

                // bluetoothDevices size değerini ata
                bluetoothDevices =new BluetoothDevice[devices.size()];

                // index değeri 0 olarak verdik.
                int index=0;

                // cihazlarının boyutu 0 dan büyükse
                if (devices.size()>0){

                    // loop ile cihazları döndür.
                    for (BluetoothDevice device : devices){

                        // bluetoothDevices index değerine device ata
                        bluetoothDevices[index] = device;

                        // isimleri index değerine koy
                        strings[index] = device.getName();

                        // index değerini arttır
                        index++;
                    }

                    // adapter nesnesi tanımlandı.
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,strings);

                    // listview'e adapteri ata
                    listView.setAdapter(arrayAdapter);
                }

            }
        });


        // listen butonuna tıklanınca neler olacak
        listen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // ServerClass oluşturma
                ServerClass serverClass = new ServerClass();

                // serverclass başlat
                serverClass.start();
            }
        });


        // listviewe tıklanınca neler olacak
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                // ClientClass oluşturma
                ClientClass clientClass = new ClientClass(bluetoothDevices[i]);

                // clientClass başlat
                clientClass.start();


                // text değerini yaz
                status.setText("Connecting");
            }
        });


        // send butonuna basınca neler olacak
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // mesajın değerini al
                String string = String.valueOf(writeMessage.getText());

                // mesajı bytes halinde yolla
                sendReceive.write(string.getBytes());
            }
        });

    }

