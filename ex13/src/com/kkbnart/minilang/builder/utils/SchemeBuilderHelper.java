package com.kkbnart.minilang.builder.utils;

import java.util.ArrayList;
import java.util.List;

import com.kkbnart.minilang.builder.Scheme;
import com.kkbnart.minilang.builder.java.JavaScheme;
import com.kkbnart.minilang.order.sheme.MethodOrder;
import com.kkbnart.minilang.order.sheme.NullOrder;
import com.kkbnart.minilang.order.sheme.SchemeOrder;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SchemeBuilderHelper<T extends Scheme.Builder<?>> {
  private final T builder;
  
  public T composeBuilder(final List<SchemeOrder> orders) {
    orders.stream().forEach(order -> append(order));
    return builder;
  }

  public void append(final MethodOrder methodOrder) {
    builder.addMethodOrder(methodOrder);
    System.out.println(methodOrder.getMethodName());
  }
  
  public void append(final SchemeOrder order) {
    // Do nothing
  }
 
  
  public static void main(final String[] args) {
    final List<SchemeOrder> orders = new ArrayList<>();
    orders.add(new MethodOrder("hoge"));
    orders.add(new MethodOrder("fuga"));
    orders.add(new NullOrder());
    
    System.out.println("process start");
    final SchemeBuilderHelper<JavaScheme.Builder> helper =
        new SchemeBuilderHelper<>(new JavaScheme.Builder());
    final JavaScheme.Builder builder = helper.composeBuilder(orders);
  }
}
