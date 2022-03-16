    @Test
    public void decodeGenre() {
        assertNull(ID3Utils.decodeGenre(null));
        assertEquals("", ID3Utils.decodeGenre(""));
        assertEquals("f", ID3Utils.decodeGenre("f"));
        assertEquals("fo", ID3Utils.decodeGenre("fo"));
        assertEquals("foo", ID3Utils.decodeGenre("foo"));
        assertEquals("(foo)", ID3Utils.decodeGenre("(foo)"));
        assertEquals("Salsa", ID3Utils.decodeGenre("(143)"));
    }

