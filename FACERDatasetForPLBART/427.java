    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.halil.ozel.bluetoothchatapp", appContext.getPackageName());
    }

