package com.kkbnart.minilang.builder.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.kkbnart.minilang.builder.Scheme;
import com.kkbnart.minilang.builder.cpp.CppScheme;
import com.kkbnart.minilang.exception.SchemeBuildException;
import com.kkbnart.minilang.utils.StringUtils;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JavaScheme extends Scheme {
  
  private final List<String> body;

  @Override
  public StringBuffer getContents() {
    return StringUtils.strListToLinesBuffer(body);
  }
  
  public static class Builder extends Scheme.Builder<Builder> {
    @Override
    public CppScheme build() throws SchemeBuildException {
      final List<String> contents = new ArrayList<>();
      contents.add(buildImportes());
      contents.add(buildAnnote());
      contents.add(buildClassHead());
      contents.addAll(buildClassBody());
      contents.add(buildClassFoot());
      return new CppScheme(contents);
    }
    
    private final String buildImportes() {
      final StringBuffer buffer = new StringBuffer();
      buffer.append("import");
      buffer.append(StringUtils.SPACE);
      buffer.append("lombok.data");
      buffer.append(";");
      buffer.append(StringUtils.BR);
      return buffer.toString();
    }
    
    private final String buildAnnote() {
      return "@Data";
    }

    private final String buildClassHead() {
      final StringBuffer buffer = new StringBuffer();
      buffer.append("public");
      buffer.append(StringUtils.SPACE);
      buffer.append("class");
      buffer.append(StringUtils.SPACE);
      buffer.append(super.getMethodOrder().getMethodName());
      buffer.append(StringUtils.SPACE);
      buffer.append("{");
      return buffer.toString();
    }

    private final List<String> buildClassBody() {
      return super.getFuncOrders()
          .stream()
          .map(
              funcOrder -> {
                final StringBuffer buffer = new StringBuffer();
                buffer.append(StringUtils.TAB);
                buffer.append(funcOrder.getAttrType());
                buffer.append(StringUtils.SPACE);
                buffer.append(funcOrder.getAttrName());
                buffer.append(";");
                return buffer.toString();
              })
          .collect(Collectors.toList());
    }

    private final String buildClassFoot() {
      return "}";
    }
  }
}
