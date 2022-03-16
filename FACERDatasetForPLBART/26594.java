    @Override
    public void onClick(View v){
        Activity activity = (Activity) context;
        Log.i("onClick", "on View: " + v.toString());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ImageView ivWeatheric = (ImageView) v.findViewById(R.id.Stat);
            Intent i = new Intent(context.getApplicationContext(), ScrollingActivity.class);
            Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(activity, ivWeatheric, ivWeatheric.getTransitionName()).toBundle();
            Integer id = 1;
            i.putExtra("id", id);
            context.startActivity(i, bundle);
        } else {
            Intent i = new Intent(context.getApplicationContext(), ScrollingActivity.class);
            Integer id = 1;
            i.putExtra("id", id);
            context.startActivity(i);
        }
    }

