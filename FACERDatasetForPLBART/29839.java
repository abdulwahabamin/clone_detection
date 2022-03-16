    private void checkForCity(final String city) {
        final FetchWeather wt = new FetchWeather(this);
        final Context context = this;
        new Thread() {
            @Override
            public void run() {
                try {
                    json = wt.execute(city).get();
                } catch (InterruptedException | ExecutionException ex) {
                    ex.printStackTrace();
                }
                if (json == null) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            new MaterialDialog.Builder(context)
                                    .title(getString(R.string.city_not_found))
                                    .content(getString(R.string.city_not_found))
                                    .onAny(new MaterialDialog.SingleButtonCallback() {
                                        @Override
                                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .negativeText(getString(android.R.string.ok))
                                    .onNegative(new MaterialDialog.SingleButtonCallback() {
                                        @Override
                                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                            dialog.dismiss();
                                        }
                                    });
                        }
                    });
                } else {
                        if (dbHelper.cityExists(json.day.getName() + "," + json.day.getSys().getCountry())) {
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    new MaterialDialog.Builder(context)
                                            .title(getString(R.string.city_already_exists))
                                            .content(getString(R.string.need_not_add))
                                            .negativeText(getString(android.R.string.ok))
                                            .onNegative(new MaterialDialog.SingleButtonCallback() {
                                                @Override
                                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                                    dialog.dismiss();
                                                }
                                            })
                                            .show();
                                }
                            });
                        }
                        else {
                            dbHelper.addCity(json.day.getName() + "," + json.day.getSys().getCountry());
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    SecondaryDrawerItem itemx = new SecondaryDrawerItem().withName(json.day.getName() + "," + json.day.getSys().getCountry())
                                            .withIcon(new IconicsDrawable(context)
                                                    .icon(GoogleMaterial.Icon.gmd_place))
                                            .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                                                @Override
                                                public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                                                    if (!(f instanceof WeatherFragment)) {
                                                        wf = new WeatherFragment().setCity(json.day.getName() + "," + json.day.getSys().getCountry());
                                                        getSupportFragmentManager().beginTransaction()
                                                                .replace(R.id.fragment, wf)
                                                                .commit();
                                                    }
                                                    return true;
                                                }
                                            });
                                    drawer.addItemAtPosition(itemx, ++i);
                                }
                            });
                        }
                }
            }
        }.start();
    }

