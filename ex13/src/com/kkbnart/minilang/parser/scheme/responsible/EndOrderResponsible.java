package com.kkbnart.minilang.parser.scheme.responsible;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kkbnart.minilang.exception.SchemeParserException;
import com.kkbnart.minilang.order.sheme.EndOrder;
import com.kkbnart.minilang.parser.SchemeParserAcceptor;

public class EndOrderResponsible extends SchemeOrderResponsible {
  private static final String REGEX = "^E.*$";
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
  protected EndOrder parse(String orderLine) throws SchemeParserException {
    final Matcher m = REGEX_PATTERN.matcher(orderLine);
    if (!m.find()) {
      throw new SchemeParserException(
          String.format(
              "specified string can not be compiled to this class. (string = %s)", orderLine));
    }
    return new EndOrder();
  }

  @Override
  protected void parse(String orderLine, SchemeParserAcceptor<?> acceptor)
      throws SchemeParserException {
    final Matcher m = REGEX_PATTERN.matcher(orderLine);
    if (!m.find()) {
      throw new SchemeParserException(
          String.format(
              "specified string can not be compiled to this class. (string = %s)", orderLine));
    }
    System.out.println(String.format("Accepted as EndOrder : %s", orderLine));
    acceptor.accept(new EndOrder());
  }
}
