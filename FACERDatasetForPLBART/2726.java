    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i)
        {
            case android.content.DialogInterface.BUTTON_POSITIVE:
                newName = nameInput.getText().toString();
                if (FileHelpers.isValidFilename(newName)) {
                    File f = new File(path + File.separator + newName);

                    switch (newFileType) {
                        case REG:
                            try {
                                if (f.createNewFile()) {
                                    Toast.makeText(getContext(), "New file created", Toast.LENGTH_SHORT).show();
                                } else {
                                    errorToast();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case DIR:
                            if (f.mkdir()) {
                                Toast.makeText(getContext(), "New folder created", Toast.LENGTH_SHORT).show();
                            } else {
                                errorToast();
                            }
                            break;
                    }
                    dismiss();
                } else {
                    errorToast();
                }
                break;
        }
    }

