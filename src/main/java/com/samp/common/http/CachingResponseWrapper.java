package com.samp.common.http;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.WriteListener;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.output.TeeOutputStream;
import org.springframework.util.FastByteArrayOutputStream;

import java.io.*;

@Slf4j
public class CachingResponseWrapper extends HttpServletResponseWrapper {

    private final FastByteArrayOutputStream content = new FastByteArrayOutputStream(1024);
    private ServletOutputStream outputStream;
    private PrintWriter writer;
  
    public CachingResponseWrapper(HttpServletResponse response) {
      super(response);
    }
  
    @Override
    public ServletOutputStream getOutputStream() throws IOException {
      if (this.outputStream == null) {
        log.info("=========CachingResponseWrapper============");
        this.outputStream = new CachedServletOutputStream(getResponse().getOutputStream(), this.content);
      }
      return this.outputStream;
    }
  
    @Override
    public PrintWriter getWriter() throws IOException {
      if (writer == null) {
        writer = new PrintWriter(new OutputStreamWriter(content, this.getCharacterEncoding()), true);
      }
      return writer;
    }
  
    public InputStream getContentInputStream() {
      return this.content.getInputStream();
    }
  
    private class CachedServletOutputStream extends ServletOutputStream {
  
      private final TeeOutputStream targetStream;
  
      public CachedServletOutputStream(OutputStream one, OutputStream two) {
        targetStream = new TeeOutputStream(one, two);
      }
  
      @Override
      public void write(int arg) throws IOException {
        this.targetStream.write(arg);
      }
  
      @Override
      public void write(byte[] buf, int off, int len) throws IOException {
        this.targetStream.write(buf, off, len);
      }
  
      @Override
      public void flush() throws IOException {
        super.flush();
        this.targetStream.flush();
      }
  
      @Override
      public void close() throws IOException {
        super.close();
        this.targetStream.close();
      }
  
      @Override
      public boolean isReady() {
        return false;
      }

      @Override
      public void setWriteListener(WriteListener writeListener) {
        throw new UnsupportedOperationException("not support");
      }
    }

   
  }