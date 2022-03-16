    @Override
    public void onReceive(Context context, Intent intent) {

            Log.e(BootUpReceiver.class.getSimpleName(),"Boot completed");
            Toast.makeText(context.getApplicationContext(),"Boot completed!!!",Toast.LENGTH_LONG).show();
            SharedPreferences sharedPreferences=context.getSharedPreferences(Util.DIR_DATA,Context.MODE_PRIVATE);
            sharedPreferences.edit().putString(Util.BASE_URI,"").apply();


    }

