package org.example;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWebClientInicial{

    @BeforeAll
    public static void setUp() {
    }

    @AfterAll
    public static void tearDown() {
        // Se detiene Jetty.
    }

    @Test
    @Disabled(value = "Esto es un ejemplo de prueba inicial . Por tanto si se ejecuta no funciona.")
    public void testGetContentOk() throws MalformedURLException {
        WebClient client = new WebClient();
        String workingContent = client.getContent(new URL("http://localhost:8081/testGetContentOk"));

        assertEquals("Esto funciona", workingContent);
    }

    @Test
    public void testStubGetContentOk() throws MalformedURLException{
        URL.setURLStreamHandlerFactory(new StubStreamHandlerFactory());

        WebClient client = new WebClient();
        String result = client.getContent(new URL("http://example.com"));
        assertEquals("Esto funciona", result);
    }

    private static class StubStreamHandlerFactory implements URLStreamHandlerFactory {
        @Override
        public URLStreamHandler createURLStreamHandler(String protocol) {
            return new StubHttpURLStreamHandler();
        }
    }

    private static class StubHttpURLStreamHandler extends URLStreamHandler {
        @Override
        protected URLConnection openConnection(URL url) throws IOException {
            return new StubHttpURLConnection(url);
        }
    }

    private static class StubHttpURLConnection extends HttpURLConnection {
        public StubHttpURLConnection(URL url) {
            super(url);
        }

        @Override
        public InputStream getInputStream() throws IOException {
            return new ByteArrayInputStream("Esto funciona".getBytes());
        }

        @Override
        public void disconnect() {
        }

        @Override
        public boolean usingProxy() {
            return false;
        }

        @Override
        public void connect() throws IOException {
        }
    }
}
