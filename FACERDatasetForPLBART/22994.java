    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_MEDIA_BUTTON.equals(intent.getAction())) {
            try {
                final Intent it;
                it = new Intent(context.getApplicationContext(), MainActivity.class);
                it.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                (context.getApplicationContext()).startActivity(it);
            } catch (Exception e) {
                Toast.makeText(context.getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            } catch (Error e) {
                Toast.makeText(context.getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

