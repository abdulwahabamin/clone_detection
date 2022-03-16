    public void showChangeLog(){
        SharedPreferences = getSharedPreferences(PREFS_NAME, 0);
        changelog = new AlertDialog.Builder(this, R.style.AppCompatAlertDialogStyle);
        changelog.setTitle("Neu in " + getResources().getString(R.string.versionDesc));
        changelog.setMessage(Html.fromHtml(
                "- Wöchentliche Vorschau redesignt<br/>" +
                "- Home Screen: Farbe ändert sich mit Wetter<br/>" +
                "- Kleine Verbesserungen, Bugfixes<br/><br/>" +
                "<b>Bitte alle Bugs + Fehler melden!<br/> Feature Requests sind erwünscht!</b>"));
        changelog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                SharedPreferences.Editor editor = SharedPreferences.edit();
                editor.putBoolean("updatenews4", true);
                editor.apply();
            }
        });
        changelog.show();
    }

