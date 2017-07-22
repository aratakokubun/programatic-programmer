package com.kkbnart.minilang.builder.cpp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.kkbnart.minilang.builder.Scheme;
import com.kkbnart.minilang.exception.SchemeBuildException;
import com.kkbnart.minilang.utils.StringUtils;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CppScheme extends Scheme {
  
  private final List<String> body;
  
  @Override
  public StringBuffer getContents() {
    return StringUtils.strListToLinesBuffer(body);
  }
  
  public static class Builder extends Scheme.Builder<Builder> {
    @Override
    public CppScheme build() throws SchemeBuildException {
      final List<String> contents = new ArrayList<>();
      contents.add(buildTypeHead());
      contents.addAll(buildTypeContent());
      contents.add(buildTypeFoot());
      return new CppScheme(contents);
    }
    
    private final String buildTypeHead() {
      final StringBuffer buffer = new StringBuffer();
      buffer.append("typedef");
      buffer.append(StringUtils.SPACE);
      buffer.append("struct");
      buffer.append(StringUtils.SPACE);
      buffer.append("{");
      return buffer.toString();
    }

    private final String buildTypeFoot() {
      final StringBuffer buffer = new StringBuffer();
      buffer.append("}");
      buffer.append(StringUtils.SPACE);
      buffer.append(super.getMethodOrder().getMethodName());
      buffer.append(";");
      return buffer.toString();
    }

    private final List<String> buildTypeContent() {
      return super.getFuncOrders()
          .stream()
          .map(
              funcOrder -> {
                final StringBuffer buffer = new StringBuffer();
                buffer.append(StringUtils.TAB);
                buffer.append(funcOrder.getAttrType());
                buffer.append(StringUtils.TAB);
                buffer.append(funcOrder.getAttrName());
                buffer.append(";");
                return buffer.toString();
              })
          .collect(Collectors.toList());
    }
  }
}
