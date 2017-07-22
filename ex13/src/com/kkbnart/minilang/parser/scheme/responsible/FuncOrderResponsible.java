package com.kkbnart.minilang.parser.scheme.responsible;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kkbnart.minilang.exception.SchemeParserException;
import com.kkbnart.minilang.order.sheme.FuncOrder;
import com.kkbnart.minilang.parser.SchemeParserAcceptor;

public class FuncOrderResponsible extends SchemeOrderResponsible {
  private static final String REGEX = "^F\\s([^\\s]+)\\s+([^\\s]+).*$";
  private static final Pattern REGEX_PATTERN;

  static {
    REGEX_PATTERN = Pattern.compile(REGEX);
  }
  
  @Override
  protected boolean isResponsible(final String orderLine) {
    final Matcher m = REGEX_PATTERN.matcher(orderLine);
    return m.find();
  }

  @Override
  protected FuncOrder parse(final String orderLine) throws SchemeParserException {
    final Matcher m = REGEX_PATTERN.matcher(orderLine);
    if (!m.find()) {
      throw new SchemeParserException(
          String.format(
              "specified string can not be compiled to this class. (string = {})", orderLine));
    }
    return new FuncOrder(
        m.group(/*attribute type index = */ 1), m.group(/*attribute name index = */ 2));
  }
  
  @Override
  protected void parse(final String orderLine, final SchemeParserAcceptor<?> acceptor)
      throws SchemeParserException {
    final Matcher m = REGEX_PATTERN.matcher(orderLine);
    if (!m.find()) {
      throw new SchemeParserException(
          String.format(
              "specified string can not be compiled to this class. (string = {})", orderLine));
    }
    System.out.println(String.format("Accepted as FuncOrder : %s", orderLine));
    acceptor.accept(
        new FuncOrder(
            m.group(/*attribute type index = */ 1), m.group(/*attribute name index = */ 2)));
  }
}
