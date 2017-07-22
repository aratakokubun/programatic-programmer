package com.kkbnart.minilang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.kkbnart.minilang.builder.Scheme;
import com.kkbnart.minilang.builder.Scheme.Builder;
import com.kkbnart.minilang.builder.SchemeBuilderAcceptor;
import com.kkbnart.minilang.builder.cpp.CppScheme;
import com.kkbnart.minilang.builder.java.JavaScheme;
import com.kkbnart.minilang.builder.output.FileSchemeOutputer;
import com.kkbnart.minilang.builder.output.SchemeOutputer;
import com.kkbnart.minilang.exception.SchemeBuildException;
import com.kkbnart.minilang.exception.SchemeOutputException;
import com.kkbnart.minilang.parser.scheme.SchemeOrderParser;
import com.kkbnart.minilang.parser.scheme.SchemeParserConsumer;
import com.kkbnart.minilang.parser.scheme.responsible.EndOrderResponsible;
import com.kkbnart.minilang.parser.scheme.responsible.FuncOrderResponsible;
import com.kkbnart.minilang.parser.scheme.responsible.MethodOrderResponsible;
import com.kkbnart.minilang.parser.scheme.responsible.SchemeOrderResponsible;

public class Main {

  public static void main(String[] args) {
    final File inFile = new File("./ex13/data/AddOrder.sch");
    final File outFileJava = new File("./ex13/data/AddOrder.java");
    final File outFileCpp = new File("./ex13/data/AddOrder.cpp");
    final List<String> orderLines = readFromFile(inFile);
    
    // Parse and build java scheme
    final SchemeParserConsumer consumerJava =
        new SchemeParserConsumer(
            new SchemeBuilderAcceptor<Builder<?>>(new JavaScheme.Builder()), composeResponsible());
    final SchemeOrderParser parserJava = new SchemeOrderParser(consumerJava);
    final SchemeOutputer outputerJava = new FileSchemeOutputer(outFileJava);

    parserJava.addOrders(orderLines);
    final Scheme.Builder<?> builderJava = (Builder<?>) parserJava.parse().getAcceptor().generate();
    try {
      outputerJava.output(builderJava.build());
    } catch (SchemeOutputException | SchemeBuildException e) {
      System.out.println("Failed to build java scheme!");
    }

    // Parse and build Cpp scheme
    final SchemeParserConsumer consumerCpp =
        new SchemeParserConsumer(
            new SchemeBuilderAcceptor<Builder<?>>(new CppScheme.Builder()), composeResponsible());
    final SchemeOrderParser parserCpp = new SchemeOrderParser(consumerCpp);
    final SchemeOutputer outputerCpp = new FileSchemeOutputer(outFileCpp);

    parserCpp.addOrders(orderLines);
    final Scheme.Builder<?> builderCpp =
        (Scheme.Builder<?>) parserCpp.parse().getAcceptor().generate();
    try {
      outputerCpp.output(builderCpp.build());
    } catch (SchemeOutputException | SchemeBuildException e) {
      System.out.println("Failed to build cpp scheme!");
    }
  }
  
  private static final List<String> readFromFile(final File file) {
    final List<String> lines = new ArrayList<>();
    try (final BufferedReader br =
        new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
      String s;
      while ((s = br.readLine()) != null) {
        lines.add(s);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return lines;
  }
  
  private static final SchemeOrderResponsible composeResponsible() {
    final SchemeOrderResponsible first =
        new MethodOrderResponsible();
    first.setNext(new FuncOrderResponsible()).setNext(new EndOrderResponsible());
    return first;
  }
}
