  private void setupTextSwitchers() {
    tempTextView.setFactory(new TextViewFactory(MainActivity.this, R.style.TempTextView, true, typeface));
    tempTextView.setInAnimation(MainActivity.this, R.anim.slide_in_right);
    tempTextView.setOutAnimation(MainActivity.this, R.anim.slide_out_left);
    descriptionTextView.setFactory(new TextViewFactory(MainActivity.this, R.style.DescriptionTextView, true, typeface));
    descriptionTextView.setInAnimation(MainActivity.this, R.anim.slide_in_right);
    descriptionTextView.setOutAnimation(MainActivity.this, R.anim.slide_out_left);
    humidityTextView.setFactory(new TextViewFactory(MainActivity.this, R.style.HumidityTextView, false, typeface));
    humidityTextView.setInAnimation(MainActivity.this, R.anim.slide_in_bottom);
    humidityTextView.setOutAnimation(MainActivity.this, R.anim.slide_out_top);
    windTextView.setFactory(new TextViewFactory(MainActivity.this, R.style.WindSpeedTextView, false, typeface));
    windTextView.setInAnimation(MainActivity.this, R.anim.slide_in_bottom);
    windTextView.setOutAnimation(MainActivity.this, R.anim.slide_out_top);
  }

