package com.kkbnart.minilang.parser.scheme.responsible;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kkbnart.minilang.exception.SchemeParserException;
import com.kkbnart.minilang.order.sheme.MethodOrder;
import com.kkbnart.minilang.parser.SchemeParserAcceptor;

public class MethodOrderResponsible extends SchemeOrderResponsible {
  private static final String REGEX = "^M[\\s]+([^\\s]+).*$";
  private static final Pattern REGEX_PATTERN;
 
  static {
    REGEX_PATTERN = Pattern.compile(REGEX);
  }

  @Override
  protected boolean isResponsible(String orderLine) {
    final Matcher m = REGEX_PATTERN.matcher(orderLine);
    return m.find();
  }

  @Override
  protected MethodOrder parse(String orderLine) throws SchemeParserException {
    final Matcher m = REGEX_PATTERN.matcher(orderLine);
    if (!m.find()) {
      throw new SchemeParserException(
          String.format(
              "specified string can not be compiled to this class. (string = %s)", orderLine));
    }
    return new MethodOrder(m.group(/*method name index = */ 1));
  }
  
  @Override
  protected void parse(String orderLine, final SchemeParserAcceptor<?> acceptor)
      throws SchemeParserException {
    final Matcher m = REGEX_PATTERN.matcher(orderLine);
    if (!m.find()) {
      throw new SchemeParserException(
          String.format(
              "specified string can not be compiled to this class. (string = %s)", orderLine));
    }
    System.out.println(String.format("Accepted as MethodOrder : %s", orderLine));
    acceptor.accept(new MethodOrder(m.group(/*method name index = */ 1)));
  }
}
