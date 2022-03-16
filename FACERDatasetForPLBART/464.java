    private void findViewsByIds() {
        status = (TextView) findViewById(R.id.status);
        btnConnect = (Button) findViewById(R.id.btn_connect);
        listView = (ListView) findViewById(R.id.list);
        inputLayout = (TextInputLayout) findViewById(R.id.input_layout);
        View btnSend = findViewById(R.id.btn_send);
        View btnSendImg = findViewById(R.id.btn_sendImg);
        imagen = (ImageView)findViewById(R.id.imgSelect);

        btnSendImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                    intent.addCategory(Intent.CATEGORY_OPENABLE);
                    intent.setType("image/*");
                    startActivityForResult(Intent.createChooser(intent, "Seleccionar Imagen"), SELECT_PICTURE);
                } else {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(intent, "Seleccionar Imagen"), SELECT_PICTURE);
                }
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tipo_mensaje.equals("texto")){
                    if (inputLayout.getEditText().getText().toString().equals("")) {
                        Toast.makeText(MainActivity.this, "Escriba un mensaje por favor", Toast.LENGTH_SHORT).show();
                    } else {
                        sendMessage(inputLayout.getEditText().getText().toString());
                        inputLayout.getEditText().setText("");
                    }
                }
                else if (tipo_mensaje.equals("imagen")){
                    try{

                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.PNG, 50, stream);
                        byte[] imageBytes = stream.toByteArray();
                        int subArraySize = 400;
                        sendMultimediaMessage(String.valueOf(imageBytes.length).getBytes());
                        for(int i = 0; i < imageBytes.length; i+=subArraySize){
                            byte[] tempArray;
                            tempArray = Arrays.copyOfRange(imageBytes, i,  Math.min(imageBytes.length, i+subArraySize));
                            sendMultimediaMessage(tempArray);
                        }


                        /* Segunda forma de envío
                        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 40, bytes);
                        byte[] image = bytes.toByteArray();
                        sendMultimediaMessage(String.valueOf(image.length).getBytes());*/

                    }catch (Exception e){
                        Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

