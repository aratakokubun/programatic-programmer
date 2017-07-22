package com.kkbnart.minilang.builder.output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.kkbnart.minilang.builder.Scheme;
import com.kkbnart.minilang.exception.SchemeOutputException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FileSchemeOutputer implements SchemeOutputer {
  private final File outputFile;
  
  @Override
  public void output(Scheme scheme) throws SchemeOutputException {
    try {
      try (FileWriter writer = new FileWriter(outputFile)) {
        final StringBuffer sb = scheme.getContents();
        writer.write(sb.toString());
      }
    } catch (IOException e) {
      // TODO
      // Handle Exception
    }
  }
}
