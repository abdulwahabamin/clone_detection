    private void setListener() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = etInput.getText().toString();

                while (text.startsWith("\n")) {
                    text = text.substring(2, text.length());
                }
                while (text.endsWith("\n")) {
                    text = text.substring(0, text.length() - 2);
                }


                if (text.length() > 0) {
                    if (isClient) {
                        clientService.write(text);
                    } else {
                        serverService.write(text);
                    }
                    etInput.setText("");
                }
            }
        });
    }

