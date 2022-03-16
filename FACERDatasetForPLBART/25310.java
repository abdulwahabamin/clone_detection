    public static void aboutDialog(final Context context){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context, R.style.RhythmAlertDialog);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View dialogView = inflater.inflate(R.layout.dialog_about_rhythm, null);
        PackageInfo pInfo;
        try {
            pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            TextView versionNameCode = (TextView)dialogView.findViewById(R.id.version_name_code);
            versionNameCode.setText(context.getResources().getString(R.string.version_name_code,
                    pInfo.versionName, pInfo.versionCode));
        } catch (PackageManager.NameNotFoundException e) {
            Timber.e(e, "packageInfo");
        }
        dialogView.findViewById(R.id.github_project).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/laithnurie/rhythm"));
                context.startActivity(i);
            }
        });
        dialogView.findViewById(R.id.design_page).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://dribbble.com/shots/2183234-Music-app-research"));
                context.startActivity(i);
            }
        });
        dialogBuilder.setView(dialogView);

        AlertDialog b = dialogBuilder.create();
        b.show();
    }

