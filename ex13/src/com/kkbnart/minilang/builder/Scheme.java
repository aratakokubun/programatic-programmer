package com.kkbnart.minilang.builder;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsNull;

import com.kkbnart.minilang.exception.SchemeBuildException;
import com.kkbnart.minilang.order.sheme.EndOrder;
import com.kkbnart.minilang.order.sheme.FuncOrder;
import com.kkbnart.minilang.order.sheme.MethodOrder;
import com.kkbnart.minilang.order.sheme.SchemeOrder;

import lombok.Data;
import lombok.NoArgsConstructor;

public abstract class Scheme {
  
  public abstract StringBuffer getContents();

  @Data
  @NoArgsConstructor
  public static class Builder<T extends Builder<T>> {
    private MethodOrder methodOrder = null;
    private List<FuncOrder> funcOrders = new ArrayList<>();
    private EndOrder endOrder = null;
    
    @SuppressWarnings("unchecked")
    public T addMethodOrder(final MethodOrder methodOrder) {
      this.methodOrder = methodOrder;
      return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T addEndOrder(final EndOrder endOrder) {
      this.endOrder = endOrder;
      return (T) this;
    }
    
    @SuppressWarnings("unchecked")
    public T addFuncOrder(final FuncOrder funcOrder) {
      this.funcOrders.add(funcOrder);
      return (T) this;
    }
    
    @SuppressWarnings("unchecked")
    public T addFuncOrders(final List<FuncOrder> funcOrders) {
      this.funcOrders.addAll(funcOrders);
      return (T) this;
    }
    
    public Scheme build() throws SchemeBuildException {
      if (!validateContent()) {
        throw new SchemeBuildException("Validation failed for scheme builder");
      }
      return buildContent();
    }
    
    protected boolean validateContent() {
      final IsNull<SchemeOrder> isSchemeOrderNull = new IsNull<>();
      return !isSchemeOrderNull.matches(methodOrder)
          && !isSchemeOrderNull.matches(endOrder)
          && funcOrders.size() > 0;
    }
    
    protected Scheme buildContent() throws SchemeBuildException {
      throw new SchemeBuildException("Action not defined");
    }
  }
}
