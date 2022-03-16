    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_edit_name) {
            BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            String username = sharedPref.getString("username", bluetoothAdapter.getName());
            final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

            final EditText nameInput = new EditText(this);
            nameInput.setSingleLine();
            nameInput.setImeOptions(EditorInfo.IME_ACTION_DONE);
            nameInput.setText(username);
            nameInput.setSelectAllOnFocus(true);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(getString(R.string.enter_your_username));
            builder.setView(nameInput);
            builder.setPositiveButton(getString(R.string.submit), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    imm.hideSoftInputFromWindow(nameInput.getWindowToken(), 0);
                    sharedPref.edit().putString(getString(R.string.username), nameInput.getText().toString()).apply();
                }
            });
            builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    imm.hideSoftInputFromWindow(nameInput.getWindowToken(), 0);
                }
            });

            final AlertDialog dialog = builder.show();
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

            nameInput.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {}

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence.length() > 0 && charSequence.length() <= 22) {
                        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(true);
                    } else {
                        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {}
            });
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

