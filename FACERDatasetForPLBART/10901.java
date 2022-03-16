    /**
     * Method that checks the support for HardwareAcceleration. Check AOSP notice<br/>
     * <br/>
     * <pre>
     * 'ComposeShader can only contain shaders of different types (a BitmapShader and a
     * LinearGradient for instance, but not two instances of BitmapShader)'. But, 'If your
     * application is affected by any of these missing features or limitations, you can turn
     * off hardware acceleration for just the affected portion of your application by calling
     * setLayerType(View.LAYER_TYPE_SOFTWARE, null).'
     */
    private void checkHardwareAccelerationSupport() {
       // HardwareAcceleration sit is only available since ICS. 14 = ICS_VERSION_CODE
       if (android.os.Build.VERSION.SDK_INT >= 14) {
           try{
               // We need to use reflection to get that method to avoid compilation errors
               Method isHardwareAccelerated =
                       getClass().getMethod("isHardwareAccelerated", new Class[]{});
               Object o = isHardwareAccelerated.invoke(this, new Object[]{});
               if (null != o && o instanceof Boolean && (Boolean)o) {
                   // HardwareAcceleration is supported. Use SoftwareAcceleration
                   Method setLayerType =
                           getClass().getMethod(
                                   "setLayerType", int.class, android.graphics.Paint.class);
                   setLayerType.invoke(this, 1, (android.graphics.Paint)null);
               }
           } catch (Exception e) { /** NON BLOCK **/}
       }
   }

