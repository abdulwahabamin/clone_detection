                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.nav_menu_current_weather:
                            startActivity(new Intent(BaseActivity.this, MainActivity.class));
                            break;
                        case R.id.nav_menu_graphs:
                            createBackStack(new Intent(BaseActivity.this,
                                                       GraphsActivity.class));
                            break;
                        case R.id.nav_menu_weather_forecast:
                            createBackStack(new Intent(BaseActivity.this,
                                                       WeatherForecastActivity.class));
                            break;
                        case R.id.nav_settings:
                            createBackStack(new Intent(BaseActivity.this,
                                                       SettingsActivity.class));
                            break;
                        case R.id.nav_feedback:
                            Intent sendMessage = new Intent(Intent.ACTION_SEND);
                            sendMessage.setType("message/rfc822");
                            sendMessage.putExtra(Intent.EXTRA_EMAIL, new String[]{
                                    getResources().getString(R.string.feedback_email)});
                            try {
                                startActivity(Intent.createChooser(sendMessage, "Send feedback"));
                            } catch (android.content.ActivityNotFoundException e) {
                                Toast.makeText(BaseActivity.this, "Communication app not found",
                                               Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case R.id.nav_menu_bitcoin_donation:
                            BitcoinDonationDialog dialog = BitcoinDonationDialog.newInstance();
                            dialog.show(getFragmentManager(), "bitcoinDonationDialog");
                            break;
                    }

                    mDrawerLayout.closeDrawer(GravityCompat.START);
                    return true;
                }

