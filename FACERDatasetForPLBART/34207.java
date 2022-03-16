    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.dialog_donation_bitcoin, null);
        TextView bitcoinAddress = (TextView) v.findViewById(R.id.bitcoin_address);
        Button copyBitcoinAddress = (Button) v.findViewById(R.id.copy_bitcoin_address_button);
        Button openBitcoinApp = (Button) v.findViewById(R.id.open_bitcoin_app_button);

        bitcoinAddress.setText(Constants.BITCOIN_ADDRESS);
        copyBitcoinAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.copyToClipboard(getActivity(), Constants.BITCOIN_ADDRESS);
                Toast.makeText(getActivity(),
                               R.string.donation_bitcoin_copy_message,
                               Toast.LENGTH_SHORT).show();
            }
        });
        openBitcoinApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("bitcoin:" + Constants.BITCOIN_ADDRESS));
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getActivity(),
                                   R.string.donation_bitcoin_copy_message,
                                   Toast.LENGTH_SHORT).show();
                }
            }
        });

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("Bitcoin");
        alertDialog.setView(v);
        alertDialog.setNegativeButton(android.R.string.cancel,
                                      new DialogInterface.OnClickListener() {
                                          @Override
                                          public void onClick(DialogInterface dialogInterface,
                                                              int i) {
                                              dialogInterface.cancel();
                                          }
                                      });
        return alertDialog.create();
    }

