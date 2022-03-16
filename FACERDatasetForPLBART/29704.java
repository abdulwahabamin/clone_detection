  /**
   * Showing dialog for set api key value
   *
   * @param context  instance of {@link Context}
   * @param prefser  instance of {@link Prefser}
   * @param listener instance of {@link OnSetApiKeyEventListener}
   */
  public static void showSetAppIdDialog(Context context, Prefser prefser, OnSetApiKeyEventListener listener) {
    final Dialog dialog = new Dialog(context);
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
    dialog.setContentView(R.layout.dialog_set_appid);
    dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    dialog.setCancelable(false);
    WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
    lp.copyFrom(dialog.getWindow().getAttributes());
    lp.width = WindowManager.LayoutParams.MATCH_PARENT;
    lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
    dialog.getWindow().setAttributes(lp);
    dialog.findViewById(R.id.open_openweather_button).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW,
            Uri.parse(Constants.OPEN_WEATHER_MAP_WEBSITE));
        context.startActivity(i);
      }
    });
    dialog.findViewById(R.id.store_button).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        AppCompatEditText apiKeyEditText = dialog.findViewById(R.id.api_key_edit_text);
        String apiKey = apiKeyEditText.getText().toString();
        if (!apiKey.equals("")) {
          prefser.put(Constants.API_KEY, apiKey);
          listener.setApiKey();
          dialog.dismiss();
        }
      }
    });
    dialog.show();
  }

